package exam3.multi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class OutputClientSide implements Runnable
{
    // не static
    private ObjectOutputStream output;
    private Scanner scanner;
 
    public OutputClientSide(ObjectOutputStream output){
        this.output = output;
        scanner = new Scanner(System.in);
    }
 
    @Override
    public void run()
    {
        // оба потока должны использовать один сокет, поэтому создавать его не нужно (он уже в конструкторе передан)
        System.out.println("ввести имя");
        String userName = scanner.nextLine();
        String text;
        while (true)
        {
            System.out.println("введи сообщение (quit - для выхода из чата)");
            text = scanner.nextLine();
            SimpleMessage simMessage = new SimpleMessage(userName, text);
            simMessage.setDateTime();
            sendMsg(simMessage);
        }
    }

    /*synchronized void nextMsg(SimpleMessage simMessage)
    {
        //String s = userName + ", " + text + i;
//        String s = text + i;
//        SimpleMessage simMessage = new SimpleMessage(userName,s);
//        simMessage.setDateTime();
        sendMsg(simMessage);
    }*/

    void sendMsg(SimpleMessage msg)
    {
        try
        {
            // сначала пишем, потом flush
            output.writeObject(msg);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}