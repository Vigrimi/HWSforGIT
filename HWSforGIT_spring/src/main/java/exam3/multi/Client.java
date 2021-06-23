package exam3.multi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

// это типа
public class Client/*ToServer implements Runnable*/ extends Thread //СЕРВЕРНАЯ ЧАСТЬ ДЛЯ СВЯЗИ С КЛИЕНТОМ
{
    private ArrayBlockingQueue<SimpleMessage> msgsBlQu;
    private Socket socket;
    private Client[] clients;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private SimpleMessage[] simpleMessagesFmClient = new SimpleMessage[16];
    public SimpleMessage simpleMessage;
    private final SimpleMessage DONE = new SimpleMessage("done","done");

    public Client(){}
    public Client(Socket socket, Client[] clients) throws IOException {
        this.socket = socket;
        //this.socket = (new ServerSocket(8999, 10)).accept(); // для блокир очереди
        this.clients = clients;
        output = new ObjectOutputStream(socket.getOutputStream());
        msgsBlQu = new ArrayBlockingQueue<SimpleMessage>(15);
        (new Thread(new Producer())).start();
        (new Thread(new Consumer())).start();

    }

    /*public synchronized String[] messagesFmClient(String msg)
    {
        //for (String msgs : messagesFmClient)
        for (int i = 0; i < 15; i++)
        {

        }
        return messagesFmClient;
    }*/

    @Override
    public void run()
    {
//        (new Thread(new Producer())).start();
//        (new Thread(new Consumer())).start();
        //// !!!!!!!!!!!!! возможно тут надо создавать новый массив сообщений чтобы он был новым для каждого клиента
        //SimpleMessage[] simpleMessagesFmClient = new SimpleMessage[16];
//        Producer p = new Producer(msgsBlQu);
//        Consumer c1 = new Consumer(msgsBlQu);
//        new Thread(p).start();
//        new Thread(c1).start();
        try {
            //Socket socket = (new ServerSocket(8999, 10)).accept(); // для блокир очеред
            input = new ObjectInputStream(socket.getInputStream());

            //while (true)
            //while (socket.getKeepAlive())
   while (!Thread.currentThread().isInterrupted()) // 59,62,138,
            //while (Thread.currentThread().isAlive())
            //while (msgsBlQu.isEmpty())
   {
            output = new ObjectOutputStream(socket.getOutputStream());

                SimpleMessage msg = (SimpleMessage) input.readObject()/*.toString()*/;
                            //msgsBlQu.put(msg);
                // для блокир очереди
                for (int i = 0; i < simpleMessagesFmClient.length; i++)
                {
                    if(simpleMessagesFmClient[i] == null)
                    {
                        simpleMessagesFmClient[i] = msg;
                       // msgsBlQu.put(simpleMessagesFmClient[i]);
                        break;
                    }
                }
                System.out.println("11--- " + Arrays.toString(simpleMessagesFmClient));
                if (msg.getText().contains("quit"))
                {
              //      ChatFrame.addMsg(login + " left chat. Bye Bye Bye");
                    for (int i = 0; i < 9; i++){
                        if ((clients[i] != null) && (clients[i] != this))
                        {
             //               clients[i].sendMsg(/*login + */" left chat. Bye Bye Bye");
                        }
                    }
                    //break;
                }
             //   ChatFrame.addMsg(login + ": " + msg);
                System.out.println("Сервер получил сообщение и пересылает его всем кроме самого " +
                        "отправителя: " + msg ); //ранее подключившегося
                        //+ currentThread().getName()); //ранее подключившегося
                //Producer.produce(msg);


                sleep(2_000);

                for (int i = 0; i < 9; i++)
                {
                    if ((clients[i] != null) && (clients[i] != this))
                    //if ((clients[i] != null) && (clients[i] != this) && (clients[i] != msg.getSender()) ) // для блокирующ
                    {
        // убрал для блокир очереди
        //clients[i].sendMsg(/*login + ": " + */msg);

                            //clients[i].sendMsg(msgsBlQu.take()); // consume(queue.take()); = блокир очер
                        //sendMsg(msgsBlQu.take());
                    }
                   /* // для блокирующ очереди
                    if (simpleMessagesFmClient[i] == null)
                    {
                        simpleMessagesFmClient[i] = msg;
                        //break;
                    }*/
                    // для блокирующ очереди
                    //msgsBlQu.put(DONE);
                }
                //sendMsg(msg);
                System.out.println("963"); // печатает каждый раз при добавлении в массив

   }
            System.out.println("9644"); // не печатает, не выходит сюда
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    class Producer implements Runnable
    {
        public Producer() {
        }

        public void run()
        {
            System.out.println("20" + msgsBlQu);
            System.out.println("21--- " + Arrays.toString(simpleMessagesFmClient));
            try
            {
              //  while (true)
                //while (simpleMessagesFmClient[0] != null)
              //  {
//                    Client client = new Client();
//                    client.start();
                    for (int i = 0; i < simpleMessagesFmClient.length; i++)
                    {
                        if(simpleMessagesFmClient[i] != null)
                        {
                            msgsBlQu.put(simpleMessagesFmClient[i]);
//                        }
//                        else if (simpleMessagesFmClient[i] == null)
//                        {
//                            msgsBlQu.put(DONE);
                            break;
                        }
                    }
                    //начитать в массив пришедшие сообщения
                    // и потом каждое сообщение в цикле положить в пут

                    //queue.put(produce());
              //  }
            } catch (InterruptedException ex)
            { ex.printStackTrace();}
        }
    }

    class Consumer implements Runnable
    {
        public Consumer() {
        }

        public void run()
        {
            System.out.println("30" + msgsBlQu);
            System.out.println("31--- " + Arrays.toString(simpleMessagesFmClient));
            try
            {
                String msg1 = null;
                //SimpleMessage msg1 = null;
                System.out.println("44" + msgsBlQu);
                //while (!((msg1 = msgsBlQu.take()).equals(DONE)))
                //while (!((msg1 = msgsBlQu.take().getText()).equalsIgnoreCase("DONE")))
                while (!(msgsBlQu.isEmpty()))
                //while (msgsBlQu.isEmpty())
               // while (true)
                {
                    //System.out.println(msg);
                    System.out.println("123");
                    /*for (int i = 0; i < 9; i++)
                    {
                        if ((clients[i] != null) *//*&& (clients[i] != this)*//*)
                        //if ((clients[i] != null) && !(clients[i] == this))
                        {
                            // убрал для блокир очереди
                            clients[i].sendMsg(*//*login + ": " + *//*msg1);
                        }
                    }*/
                    //sendMsg(msg1);
                    msgsBlQu.take();
                    sendMsg(msgsBlQu.take());
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    void sendMsg(SimpleMessage msg)
    {
        try {
//            (new Thread(new Producer())).start();
//            (new Thread(new Consumer())).start();
            System.out.println("321");
            for (int i = 0; i < 9; i++)
            {
                if ((clients[i] != null) && (clients[i] != this))
                //if ((clients[i] != null) && !(clients[i] == this))
                {
                    // убрал для блокир очереди
                    //clients[i].sendMsg(/*login + ": " + */msg1);
                    output.flush();
                    output.writeObject(msg);
                    System.out.println("432 " + msg);
                }
            }
//            output.flush();
//            output.writeObject(msg);
            System.out.println(msg + " ## void sendMsg(String msg)" + currentThread().getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}