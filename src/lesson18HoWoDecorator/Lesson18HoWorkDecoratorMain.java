package lesson18HoWoDecorator;

import java.io.File;
import java.util.Arrays;

public class Lesson18HoWorkDecoratorMain
{
    public static void main(String[] args)
    {
        /*1. Написать декораторы, наследующиеся от FilterOutputStream и FilterInputStream,
        шифрующие и дешифрующие исходящие и входящие байты XOR-шифрованием. ^
            программа -> decorator(outputStream) -> outputStream
        программа <- decorator(inputStream) <- inputStream*/
        String pKey = "qwerty";
        ReadFromFile readFromFile = new ReadFromFile(new File("lesson18.txt"));
        byte[] bytes = readFromFile.readFromFile();
        System.out.println("\nИз файла с текстом с компа в массив байты bytes: " + Arrays.toString(bytes));
        byte[] encodeBytes = encode(bytes,pKey);
        System.out.println("\nмассив байты закодирован ключом encodeBytes: " + Arrays.toString(encodeBytes));
        byte[] decodeBytes = decode(encodeBytes,pKey);
        System.out.println("\nмассив закодированые байты ключом раскодировали в " +
                "decodeBytes: " + Arrays.toString(decodeBytes));
        WritoToFile writoToFile1 = new WritoToFile(new File("newlesson18.txt"));
        byte[] qwe = {-18, -22,32,32,-18, -22,32,32,-18, -22,32,32,-18, -22,32,32};
        writoToFile1.writeToFile(qwe);
        writoToFile1.writeToFile(decodeBytes);


    }
    public static byte[] encode(byte[] pText, String pKey) //реализация шифрования
    {
        byte[] txt = pText; //.getBytes();
        byte[] key = pKey.getBytes();
        byte[] res = new byte[pText.length];

        for (int i = 0; i < txt.length; i++)
        {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }
        return res;
    }
    public static byte[] decode(byte[] pText, String pKey) //реализация дешифрования
    {
        byte[] res = new byte[pText.length];
        byte[] key = pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }
        return res;
    }
}
