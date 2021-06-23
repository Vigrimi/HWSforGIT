package exam3.multi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class OutputClientSide implements Runnable
{
   // private ArrayBlockingQueue<SimpleMessage> msgsBlQu;
    private SimpleMessage[] simpleMessagesArr;
    private Socket socket;
    static ObjectOutputStream output;
    private Scanner scanner;
//    JPanel botPanel;
//    JTextField textField;
 
    public OutputClientSide(/*JPanel botPanel, JTextField textField,*/ Socket socket){
        this.socket = socket;
//        this.botPanel = botPanel;
//        this.textField = textField;
        scanner = new Scanner(System.in);
        simpleMessagesArr = new SimpleMessage[5];
       // msgsBlQu = new ArrayBlockingQueue<SimpleMessage>(15);
    }
 
    @Override
    public void run()
    {
        try {
            socket = new Socket("127.0.0.1", 8999);
            output = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("ввести имя");
            String userName = scanner.nextLine();
            String text;
            System.out.println("введи сообщение");
            while (true)
            {
                //System.out.println("введи сообщение1");
                text = scanner.nextLine();

                for (int i = 0; i < 5; i++)
                {
            //        int i = 0;
                    //String s = userName + ", " + text + i;
                    //sendMsg(s);
                    String s = text + i;
                    SimpleMessage simMessage = new SimpleMessage(userName,s);
                    simMessage.setDateTime();
                    simpleMessagesArr[i] = simMessage;

                    nextMsg(simMessage);
                  //  msgsBlQu.put(simpleMessagesArr[i]);
                }

                System.out.println("введи сообщение");
            }

            //output.writeObject(LauncherFrame.getLogin());
//            JButton button = new JButton("Send");
//            button.setFocusable(false);
//            botPanel.add(button);
//            botPanel.repaint();
//            botPanel.revalidate();
            /*button.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (textField.getText().equalsIgnoreCase("quit")){
                        try {
                            output.flush();
                            output.writeObject(textField.getText());
                            output.close();
                            NetworkClientSide.input.close();
                            NetworkClientSide.socket.close();
                            //Database.disconnectDatabase();
                            System.exit(1);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        //ChatFrame.addMsg("You: " + textField.getText());
                        try {
                            output.flush();
                            output.writeObject(textField.getText());
                            textField.setText("");
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });*/
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    synchronized void nextMsg(SimpleMessage simMessage)
    {
        //String s = userName + ", " + text + i;
//        String s = text + i;
//        SimpleMessage simMessage = new SimpleMessage(userName,s);
//        simMessage.setDateTime();
        sendMsg(simMessage);

    }

    void sendMsg(SimpleMessage msg)
    {
        try {
            output.flush();
            output.writeObject(msg);
            //System.out.println(msg + " ## void sendMsg(String msg)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}