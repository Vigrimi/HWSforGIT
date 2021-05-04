package lesson19HoWo;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
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

                if (message.getSender().contains("SendAnImage"))  // принимаем картинку
                {
                    //TODO
                    //... дописать приём байтов картинки и сохранение картинки в файл на сервере
                    String textBytesImgFmClient = message.getText();
                    byte[] data = new byte[0];
                    data = textBytesImgFmClient.getBytes(); // (StandardCharsets.UTF_8);
                    ImageRSHoWo19 imageRSHoWo19FmServer = new ImageRSHoWo19(new File("nEWlsn19howo.jpg"));
                    imageRSHoWo19FmServer.writeToFile(data);
                    connection.sendMessage(SimpleMessageHoWo.getServerMessage("server\n","была введена " +
                                    "команда \"image\" - сервер принял файл и удачно его себе сохранил. Спасибо! " +
                                    "ЗЫ надеюсь в нём нет вирусов :ор",
                            LocalDateTime.now())); //отправка сообщения
                }

                if (message.getText().contains("ping"))  //equalsIgnoreCase("ping"))
                {
                    String text1 = message.getText();
                    String text2 = text1.substring(4, text1.length() );
                    connection.sendMessage(SimpleMessageHoWo.getServerMessage("serverT",text2,
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
