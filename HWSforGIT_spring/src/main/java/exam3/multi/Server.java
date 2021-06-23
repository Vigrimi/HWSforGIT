package exam3.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;

public class Server implements Runnable //СЕРВЕРНАЯ ЧАСТЬ
{
    static Client[] clients = new Client[10];
    static ServerSocket serverSocket;
    //private ArrayBlockingQueue<Client> clientsBlQu;
    private ArrayBlockingQueue<SimpleMessage> msgsBlQu;

    public Server() {
        //clientsBlQu = new ArrayBlockingQueue<>(5);
        //msgsBlQu = new ArrayBlockingQueue<>(15);
        msgsBlQu = new ArrayBlockingQueue<SimpleMessage>(15);
    }

    @Override
    public void run()
    {
        System.out.println("сервер_ждёт_клиентов");
        try
        {
            serverSocket = new ServerSocket(8999, 10);

//            Producer p = new Producer(msgsBlQu);
//            new Thread(p).start();

            while (!serverSocket.isClosed())
            {
                Socket socket = serverSocket.accept();
//                Consumer c = new Consumer(msgsBlQu);
//                new Thread(c).start();

                /*//BlockingQueue q = new SomeQueueImplementation();
                ArrayBlockingQueue<SimpleMessage> msgsBlQuq = new ArrayBlockingQueue<>(15);
                Producer p = new Producer(msgsBlQuq);
                Consumer c1 = new Consumer(msgsBlQuq);
                Consumer c2 = new Consumer(msgsBlQuq);
                new Thread(p).start();
                new Thread(c1).start();
                new Thread(c2).start();*/

    //эта штука работает и рассылает всем клиентам
                for (int i = 0; i < 9; i++)
                {
                    if (clients[i] == null)
                    {
                        if( (i % 2) == 0 ) //.take() блокирует этот поток если очередь пустая
                        {
                            (clients[i] = new Client(socket, clients)).start();
                        } else if ( (i % 2) != 0 ) // то метод .put заблокирует этот поток - приостановит
                        {
                            (clients[i] = new Client(socket, clients)).start();
                        }
                        break;
                    }
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}