package lesson19HoWo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientHoWo19
{
    private String ip;
    private int port; // порт компа для передачи данных
    private Scanner scanner;

    public ClientHoWo19(String ip,int port ) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start()
    {
        System.out.println("ввести имя");
        String userName = scanner.nextLine();
        String text;
        while (true)
        {
            System.out.println("\nвведи одну из команд из списка: \n\u2708 help - пользователь хочет узнать список " +
                    "доступных команд; \n\u2708 count - пользователь хочет узнать количество клиентов, которые " +
                    "подключались к серверу; \n\u2708 ping - пользователь хочет узнать время за которое сообщение " +
                    "доходит до сервера и возвращается обратно; \n\u2708 exit - пользователь хочет выйти из " +
                    "программы (завершение программы); \n\u2708 file - передача изображения(й) от клиента на сервер.");
            text = scanner.nextLine();
            if("exit".equalsIgnoreCase(text)) break;
            sendAndPrintMessage(SimpleMessageHoWo.getMessage(userName,text, LocalDateTime.now())); // вызываем отправку
        }
    }

    public void sendAndPrintMessage(SimpleMessageHoWo message)
    {
        try (ConnectionHoWo connection = new ConnectionHoWo(new Socket(ip,port))) // устанавливаем соединение с сервером
        {
            connection.sendMessage(message);
            SimpleMessageHoWo fromServer = connection.readMessage();
            System.out.println("\nот сервера: " + fromServer);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            System.out.println("ошибка отправки-получения сообщения");;
        } catch (Exception e) {
            System.out.println("ошибка соединения");;
        }
    }
}
