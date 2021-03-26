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
            if (elemArrStr1.equalsIgnoreCase("exit")) break;
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
        System.out.println("вывести получившийся массив в консоль: " + Arrays.toString(arrStr1Output));

      /*  2. Найти количество вхождений одной строки в другую.
            Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза */
        System.out.println("\n2. Найти количество вхождений одной строки в другую.\nвведи исходный текст: ");
        String inpTextNull = scanner.nextLine();
        String inpText = scanner.nextLine();
        //System.out.println("1: " + inpText);
        System.out.println("введи искомую фразу: ");
        String etalonText = scanner.nextLine();
        int intsEtalonTextLen = etalonText.length();
        //System.out.println("2: " + etalonText);
        String inpTextBezProbelov = inpText.replaceAll(" ", "");
        //System.out.println("3: " + inpTextBezProbelov);
        char[] vseSimvoly = inpTextBezProbelov.toCharArray();
        int textLen = inpTextBezProbelov.length();
        int qtySovpadeniy = 0;
        for (int i = 0; i < (textLen - (intsEtalonTextLen - 1)); i++)
        {
            String sravni = new String(vseSimvoly, i, intsEtalonTextLen);
            //System.out.println("4: " + sravni);
            if (etalonText.equals(sravni)) qtySovpadeniy++;
        }
        System.out.println("количество вхождений одной строки в другую = " + qtySovpadeniy + " раз(а).");

        /*3. Написать функцию, которая проверяет, является ли строка палиндромом.
            Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются
            по буквам или по словам как слева направо, так и справа налево.
        Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/
        System.out.println("\n3. Написать функцию, которая проверяет, является ли строка палиндромом.\nвведи текст для проверки: ");
        String inpTextPalindrom = scanner.nextLine();
        inpTextPalindrom = inpTextPalindrom.replaceAll("[^A-Za-zА-яа-я0-9]", "");
        StringBuilder strBuiNaProverku = new StringBuilder(inpTextPalindrom);
        strBuiNaProverku = strBuiNaProverku.reverse();
        String strNaProverku = strBuiNaProverku.toString ();
        System.out.println(strNaProverku.equalsIgnoreCase(inpTextPalindrom) ? "да, введённое - это палиндром!" : "нет, введённое - это НЕ палиндром!");

        /*4. Заменить все буквы в слове на строчные, а первую букву на заглавную
        Например, дано hello, получаем Hello / дано HeLLO, получаем Hello*/


    }
}
