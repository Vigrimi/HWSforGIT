package lesson19HoWo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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

                if (message.getText().equalsIgnoreCase("image"))  // принимаем картинку
                {
                    byte[] data = new byte[0];
                    data = message.getData();

                    ImageRSHoWo19 imageRSHoWo19FmServer = new ImageRSHoWo19(new File("nEWlsn19howoPng.png"));
                    imageRSHoWo19FmServer.writeToFile(data);

                    // типа попробую подработать изображение
                    //BufferedImage img = readFromFile(fileName);
                    BufferedImage bi = ImageIO.read(new File("nEWlsn19howoPng.png"));
                    int height = bi.getHeight();
                    int width = bi.getWidth();
                   // bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    int[] pixels = new int[height*width];
                    for (int i = 0; i < height; i++) // Формирование массива пикселей из BufferedImage
                        for (int j = 0; j < width; j++)
                            pixels[i*width + j] = bi.getRGB(j, i) & 0xFFFFFF; // 0xFFFFFF: записываем только 3 младших байта RGB

                    //convertToNegative() {
                    for (int i = 0; i < height; i++)
                        for (int j = 0; j < width; j++)
                            // Применяем логическое отрицание и отбрасываем старший байт
                            pixels[i*width + j] = ~pixels[i*width + j] & 0xFFFFFF;

                /*    // конвертация изображения в черно-белый вид
                    //public void convertToBlackAndWhite()
                    //{
                    //int getRed = color >> 16;
                        for (int i = 0; i < height; i++)
                            for (int j = 0; j < width; j++)
                            {
                                // находим среднюю арифметическую интенсивность пикселя по всем цветам
                                int intens = ((pixels[i * width + j])>>16 + //getRed
                                        (((pixels[i * width + j]) >> 8) & 0xFF)   +  //getGreen
                                        ((pixels[i * width + j])& 0xFF) ) / 3;  // getBlue
                                // ... и записываем ее в каждый цвет за раз , сдвигая байты RGB на свои места
                                pixels[i * width + j] = intens + (intens << 8) + (intens << 16);
                            }*/
                    // Формирование BufferedImage из массива pixels
                    //private BufferedImage copyToBufferedImage()  {
                    BufferedImage bi1 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    for (int i = 0; i < height; i++)
                        for (int j = 0; j < width; j++)
                            bi1.setRGB(j, i, pixels[i*width +j]);

                        //типа записать файл конвертированное изображение
                    ImageIO.write(bi1,"png",new File("nEWlsn19howoPng.png"));

                    connection.sendMessage(SimpleMessageHoWo.getServerMessage("server\n"
                            ,"была введена " +
                                    "команда \"image\" - сервер принял файл и удачно его себе сохранил и даже обработал в негатив. Спасибо! " +
                                    "\nЗЫ надеюсь в нём нет вирусов :ор"
                            ,LocalDateTime.now())); //отправка сообщения
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
