package exam3.multi;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NetworkClientSide implements Runnable // КЛИЕНТСКАЯ ЧАСТЬ
{
    static Socket socket;
    static ObjectInputStream input;
//    private JPanel botPanel;
//    private JTextField textField;
    private Scanner scanner;

    public NetworkClientSide() throws IOException {

//    }public NetworkClientSide(JPanel botPanel, JTextField textField){
//        this.botPanel = botPanel;
//        this.textField = textField;
        scanner = new Scanner(System.in);
       // input = new ObjectInputStream(socket.getInputStream());
    }
 
    /*static void closeNetwork()
    {
        try {
            Output.output.flush();
            Output.output.close();
            NetworkClientSide.input.close();
            NetworkClientSide.socket.close();
            Database.disconnectDatabase();
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
   }*/
 
    @Override
    public void run()
    {
        try {
            //socket = new Socket(InetAddress.getByName("127.0.0.1"), 8999);
            socket = new Socket("127.0.0.1", 8999);
            new Thread(new OutputClientSide(/*botPanel, textField,*/ socket)).start();
            System.out.println("клиент_готов");
            input = new ObjectInputStream(socket.getInputStream());

//            new Thread(input).start();
//            Thread threadClient1 = new Thread(clientMultiThread);
//            threadClient1.start();


            String msgFmServer = input.readObject().toString();
            System.out.println("Сервер получил сообщение и переслал его: " + msgFmServer);
            System.out.println("введи сообщение");
            //while (socket.getKeepAlive())
            while (true)
            {
                String msg = input.readObject().toString();
                //System.out.println("msgFmServer2 ## " + msgFmServer);
                //System.out.println("Сервер получил сообщение и переслал его2:  " + msg);

                if (msg.equals("Server closed!")){
                    //closeNetwork();
                    System.out.println("Server closed!");
                } else {
                    System.out.println("Сервер получил сообщение и переслал его: " + msg);
                    System.out.println("введи сообщение");
                    //ChatFrame.addMsg(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}