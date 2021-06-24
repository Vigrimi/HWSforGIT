package exam3.multi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServerClientProducerConsumer implements Runnable //СЕРВЕРНАЯ ЧАСТЬ
{
    // не массив, нужно использовать потокобезопасную коллекцию или мапу, тк с ними будут работать разные потоки
    private Map<String, ObjectOutputStream> clients;
    private ArrayBlockingQueue<SimpleMessage> msgsBlQu;
    private CopyOnWriteArrayList<SimpleMessage> simMesArrList; // = new CopyOnWriteArrayList<>();

    public ServerClientProducerConsumer() /*throws IOException*/ {
        msgsBlQu = new ArrayBlockingQueue<>(15);
        clients = new ConcurrentHashMap<>();
        simMesArrList = new CopyOnWriteArrayList<>();
    }

    @Override
    public void run()
    {
        System.out.println("сервер_ждёт_клиентов");
        try( ServerSocket serverSocket = new ServerSocket(8999, 10) )
        {
// у отправителя есть доступ к списку клиентов и очереди сообщений
            Producer producer = new Producer();
            new Thread(producer).start();

            while (!serverSocket.isClosed())
            {
                Socket socket = serverSocket.accept();
                // сначала objectOutputStream, потом objectInputStream, чтобы не было блокировки получения данных
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

                // читаем первое сообщение, чтобы добавить в мапу клиента
                SimpleMessage firstMessage = (SimpleMessage) objectInputStream.readObject();
                System.out.println("Первое сообщение-> " + firstMessage);
                simMesArrList.add(firstMessage);
                msgsBlQu.put(firstMessage);

                //добавить в мапу клиента и его поток
                clients.put(firstMessage.getSender(), objectOutputStream);

                Consumer consumer = new Consumer(objectInputStream);
                new Thread(consumer).start();
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class Producer implements Runnable //class insertElements implements Runnable // типа Producer
    {
        public void run()
        {
            while (true)
            {
                try
                {
                    String nameQuitedClient = "";
                    // получаем сообщение из очереди (если она пуста, поток будет автоматически заблокирован)
                    SimpleMessage message = msgsBlQu.take();
                    simMesArrList.remove(message);

                    // теперь перебираем клиентов
                    for (Map.Entry<String, ObjectOutputStream> entry : clients.entrySet())
                    {
                        // проверяем, если отправитель сообщения совпадает с ключом в мапе,
                        // то ему не оправляем, тк он автор сообщения

                        if(message.getText().equalsIgnoreCase("quit"))
                        {
                            if(entry.getKey().equals(message.getSender()))
                            {
                                SimpleMessage quitToCl = new SimpleMessage("\n_С_Е_Р_В_Е_Р_",
                                        "Server closed!");
                                quitToCl.setDateTime();
                                entry.getValue().writeObject(quitToCl);
                                entry.getValue().flush();
                                entry.getValue().close();
                                nameQuitedClient = entry.getKey();
                            }
                        }

                        int a = 0; // для проверки - если подключён только один - то некому пересылать
                        for (Map.Entry<String, ObjectOutputStream> entry1 : clients.entrySet())
                        {
                            String s = entry1.getKey();
                            a++;
                            if (a > 1) break;
                        }
                        if (a == 1)
                        {
                            SimpleMessage onlyYou = SimpleMessage.getMessage("\n_С_Е_Р_В_Е_Р_",
                          "\nк серверу подключены только вы, пересылать ваше сообщение некому {:,,(");
                            onlyYou.setDateTime();
                            entry.getValue().writeObject(onlyYou);
                            entry.getValue().flush();
                        }

                        if (!entry.getKey().equals(message.getSender()))
                        {
                            if(message.getText().equalsIgnoreCase("quit"))
                            {
                                SimpleMessage quitToAll = new SimpleMessage("\n_С_Е_Р_В_Е_Р_",
                                        "\nклиент: (" + message.getSender() + ") вышел из чата");
                                quitToAll.setDateTime();
                                entry.getValue().writeObject(quitToAll);
                                entry.getValue().flush();
                            } else
                            {
                                entry.getValue().writeObject(message);
                                entry.getValue().flush();
                            }
                        }
                    }
                    clients.remove(nameQuitedClient);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable //class removeElements implements Runnable
    {
        private ObjectInputStream inputStream;

        public Consumer(ObjectInputStream inputStream) {
            this.inputStream = inputStream;
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    SimpleMessage message = (SimpleMessage) inputStream.readObject();
                    simMesArrList.add(message);
                    // добавляем в очередь, если в очереди нет мест поток автоматически заблокируется
                    msgsBlQu.put(message);
                    System.out.println("сервер получил сообщение-> " + message);
                }
            } catch (InterruptedException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
