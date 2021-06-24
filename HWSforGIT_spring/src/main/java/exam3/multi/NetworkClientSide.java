package exam3.multi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class NetworkClientSide implements Runnable // КЛИЕНТСКАЯ ЧАСТЬ
{
    // не static
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream outputStream;

    @Override
    public void run()
    {
        try {
            socket = new Socket("127.0.0.1", 8999);

            // создаем сначала outputStream, потом inputStream, чтобы не было конфликтов
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            // передаем
            new Thread(new OutputClientSide(outputStream)).start();
            System.out.println("клиент_готов");

            // получением сообщений из консоли занимается другой поток
            while (true)
            {
                String msg = input.readObject().toString();

                if (msg.contains("Server closed!"))
                {
                    System.out.println("Server closed!");
                    closeNetwork();
                } else {
                    System.out.println("Сервер получил сообщение и переслал его: " + msg);
                    System.out.println("введи сообщение (quit - для выхода из чата)");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    void closeNetwork()
    {
        try
        {
            outputStream.flush();
            outputStream.close();
            input.close();
            socket.close();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}