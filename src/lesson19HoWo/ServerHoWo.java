package lesson19HoWo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServerHoWo
{
    //private String ip; не нужен так как он уже на компе
    private int port;
    private ConnectionHoWo connection;

    public ServerHoWo(int port) {
        //this.ip = ip;
        this.port = port;
    }

    public void start()
    {
        try (ServerSocket serverSocket = new ServerSocket(port)) // ServerSocket создаётся
        // и ждёт входящих подключений на указанном порту
        {
            System.out.println("сервер запущен");
            int countPodklyuch = 0;
            while (true)
            {
                Socket newClient = serverSocket.accept(); // момент установки соединения с клиентом, вошёл запрос от клиента на
                // установку соединения и устанавливается соединение
                connection = new ConnectionHoWo(newClient);
                countPodklyuch++;
                SimpleMessageHoWo message = (SimpleMessageHoWo) connection.readMessage() ; // чтение сообщения
                System.out.println(message);
                String countPodklyuchString = countPodklyuch + "";
                LocalDateTime messageOnServerDateTime = message.getDateTime();

                if (message.getText().equalsIgnoreCase("ping"))
                {
                    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss.ms");
                    String ldStr = messageOnServerDateTime.format(dtf1) + "T" + messageOnServerDateTime.format(dtf2);
                    //LocalDateTime parseDate = LocalDateTime.parse(ldStr);

                    connection.sendMessage(SimpleMessageHoWo.getServerMessage("serverT",ldStr,
                            LocalDateTime.now())); //отправка сообщения
                }

                if (message.getText().equalsIgnoreCase("count"))
                    connection.sendMessage(SimpleMessageHoWo.getServerMessage("server\n","была введена " +
                            "команда \"count\" - количество " +
                            "клиентов, которые подключались к серверу = " + countPodklyuchString,
                            LocalDateTime.now())); //отправка сообщения

                if (message.getText().equalsIgnoreCase("help"))
                connection.sendMessage(SimpleMessageHoWo.getServerMessage("server","help",
                        LocalDateTime.now())); //отправка сообщения

                else connection.sendMessage(SimpleMessageHoWo.getServerMessage("server","soobshenie",
                        LocalDateTime.now()));
            }
        } catch (IOException ioException) {
            System.out.println("ошибка сервера");
        } catch (ClassNotFoundException e)
        {
            System.out.println("ошибка чтения сообщения"); // надо останавливать выполнение программы и исправлять, типа нет класса
        }
    }
}
