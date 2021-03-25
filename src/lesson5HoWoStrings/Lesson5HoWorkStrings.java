package lesson5HoWoStrings;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson5HoWorkStrings
{
    public static void main(String[] args)
    {
      /*  1. Задать массив на n слов.
            В цикле считывать с консоли слова (scanner.nextLine()),
            и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Задать массив на n слов... \nвведи целое число - кол-во элементов словесного массива: ");
        double arrLengthDb = scanner.nextDouble();
        int arrLength = (int) arrLengthDb;
        int fallInArr = 0;
        if (arrLength == 0) arrLength++;
        else arrLength = Math.abs(arrLength);
        //System.out.println("arrlen: " + arrLength);
        String[] arrStr1 = new String[arrLength];
        System.out.println("вводи слова, после каждого слова жми Enter\n или пиши все слова в строке через пробел и жми Enter,\n  Выход их программы по слову exit: ");
        for (int i = 0; i < arrLength; i++)
        {
            String elemArrStr1 = scanner.next();
            int a = 0;
            if (elemArrStr1.equals("exit")) break;
            for (int j = 0; j < arrLength; j++)
            {
                if (elemArrStr1.equals(arrStr1[j]))
                {
                    a++;
                    //System.out.println(a);
                }
            }
            if (a == 0)
            {
                arrStr1[i] = elemArrStr1;
                fallInArr++;
            } else i--;
        }
        String[] arrStr1Output = Arrays.copyOf(arrStr1, fallInArr);
        System.out.println(Arrays.toString(arrStr1Output));

      /*  2. Найти количество вхождений одной строки в другую.
            Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза */

    }
}
