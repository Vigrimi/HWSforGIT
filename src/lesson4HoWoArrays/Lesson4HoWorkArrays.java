package lesson4HoWoArrays;

import java.util.Arrays;

public class Lesson4HoWorkArrays
{
    public static void main(String[] args)
    {
        /*1. Создать одномерный массив типа int на 20 элементов.
        Заполнить его рандомными значениями от 3 до 500.
        Поменять местами минимальный и максимальный элементы.*/
        int qtyElem = 20;
        int[] odnomerArr = new int[qtyElem];
        int randomDigitInt5;
        for (int i = 0; i < qtyElem; i++)
        {
            while (true)
            {
                double randomDigit5 = Math.random();
                randomDigit5 *= 1000;
                randomDigitInt5 = (int) randomDigit5;
                if (randomDigit5 >= 3 && randomDigitInt5 < 501) break;
            }
            odnomerArr[i] = randomDigitInt5;
        }
        System.out.println("1. создание рандомного массива: " + Arrays.toString(odnomerArr));
        int maxInt = Integer.MIN_VALUE;
        int minInt = Integer.MAX_VALUE;
        int indexMinElementa = -1;
        int indexMaxElementa = -2;
        for (int j = 0; j < qtyElem; j++)
        {
            if (odnomerArr[j] < minInt)
            {
                minInt = odnomerArr[j];
                indexMinElementa = j;
            }
        }
        for (int k = 0; k < qtyElem; k++)
        {
            if (odnomerArr[k] > maxInt)
            {
                maxInt = odnomerArr[k];
                indexMaxElementa = k;
            }
        }
        odnomerArr[indexMaxElementa] = minInt;
        odnomerArr[indexMinElementa] = maxInt;
        System.out.println("1. переставленный массив min<>max: " + Arrays.toString(odnomerArr));

        /*2. Дан массив целых чисел [78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90].
        Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.*/
        int[] ints2 = new int[] {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        int qtyElemChet = 0;
        int[] intsChetnye = new int[ints2.length];
        int qtyElemNeChet = 0;
        int[] intsNechetnye = new int[ints2.length];
        for (int i = 0; i < ints2.length; i++)
        {
            if (ints2[i] % 2 == 0)
            {
                intsChetnye[qtyElemChet] = ints2[i];
                qtyElemChet++;
            } else if (ints2[i] % 2 != 0 && ints2[i] != 0)
            {
                intsNechetnye[qtyElemNeChet] = ints2[i];
                qtyElemNeChet++;
            }
        }
        int[] intsChetnyeSorted = Arrays.copyOf(intsChetnye, qtyElemChet);
        Arrays.sort(intsChetnyeSorted);
        System.out.println("2. чётный массив отсортирован: " + Arrays.toString(intsChetnyeSorted));
        int[] intsNeChetnyeSorted = Arrays.copyOf(intsNechetnye, qtyElemNeChet);
        Arrays.sort(intsNeChetnyeSorted);
        System.out.println("2. НЕчётный массив отсортирован: " + Arrays.toString(intsNeChetnyeSorted));

        /*3. Дан массив целых чисел [-321, 894, -45, 782, -29, 12, -88].
        Отрицательные элементы массива перенести в новый массив.
 Размер массива должен быть равен количеству отрицательных элементов.*/
        int[] ints3 = new int[] {-321, 894, -45, 782, -29, 12, -88};
        int qtyElemOtr = 0;
        int a = 0;
        for (int i = 0; i < ints3.length; i++)
        {
            if (ints3[i] < 0) qtyElemOtr++;
        }
        int[] ints3Otr = new int[qtyElemOtr];
        for (int j = 0; j < ints3.length; j++)
        {
            if (ints3[j] < 0)
            {
                ints3Otr[a] = ints3[j];
                a++;
            }
        }
        System.out.println("3. Отрицательные элементы массива: " + Arrays.toString(ints3Otr));

        /*  4. Создать массив из чётных чисел [2, 4, 6, 8, 10, 12 ... 18, 20]
        и вывести элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)*/
        int[] ints4 = new int[10];
        int b = 2;
        for (int i = 0; i < 10; i++)
        {
            ints4[i] = b;
            b +=2;
        }
        System.out.println("4. массив из чётных чисел: " + Arrays.toString(ints4));
        System.out.print("4. элементы массива в консоль в обратном порядке: ");
        for (int j = ints4.length; j > 0; j--)
        {
            System.out.print(ints4[j-1] + " ");
        }
        /*5. Создать массив из 11 случайных целых чисел из отрезка [-1;1], вывести массив в консоль.
        Определить какой элемент встречается в массиве чаще всего и вывести информацию об этом в консоль.*/
        int[] ints5 = new int[11];
        int qtyMinusOdin = 0, qtyPlusOdin = 0, qtyZero = 0;
        for (int i = 0; i < ints5.length; i++)
        {
            while (true)
            {
                double randomDigit5 = Math.random();
                randomDigit5 *= 1000;
                randomDigitInt5 = (int) randomDigit5;
                if (randomDigit5 >= 3 && randomDigitInt5 < 501) break;
            }
            if (randomDigitInt5 >= 3 && randomDigitInt5 <= 175){
                ints5[i] = -1;
                qtyMinusOdin++;
            }
            else if (randomDigitInt5 >= 176 && randomDigitInt5 <= 350){
                ints5[i] = 0;
                qtyZero++;
            }
            else if (randomDigitInt5 >= 351 && randomDigitInt5 <= 500){
                ints5[i] = 1;
                qtyPlusOdin++;
            }
        }
        System.out.println("\n5. Создать массив из 11 случайных целых чисел из отрезка [-1;1]: " + Arrays.toString(ints5));

        if (qtyMinusOdin == qtyZero && qtyZero == qtyPlusOdin) System.out.println("в массиве чаще всего встречается: все три элемента одинаковое количество раз = " + qtyMinusOdin);

        if (qtyMinusOdin > qtyZero && qtyMinusOdin > qtyPlusOdin) System.out.println("в массиве чаще всего встречается: элемент \"-1\" такое количество раз = " + qtyMinusOdin);
        if (qtyMinusOdin == qtyZero && qtyMinusOdin > qtyPlusOdin) System.out.println("в массиве чаще всего встречается: элементы \"-1\" и \"0\" такое количество раз = " + qtyMinusOdin);
        if (qtyMinusOdin > qtyZero && qtyMinusOdin == qtyPlusOdin) System.out.println("в массиве чаще всего встречается: элементы \"-1\" и \"1\" такое количество раз = " + qtyMinusOdin);

        if (qtyZero > qtyMinusOdin && qtyZero > qtyPlusOdin) System.out.println("в массиве чаще всего встречается: элемент \"0\" такое количество раз = " + qtyZero);
        if (qtyZero > qtyMinusOdin && qtyZero == qtyPlusOdin) System.out.println("в массиве чаще всего встречается: элементы \"0\" и \"1\" такое количество раз = " + qtyZero);

        if (qtyPlusOdin > qtyZero && qtyPlusOdin > qtyMinusOdin) System.out.println("в массиве чаще всего встречается: элемент \"1\" такое количество раз = " + qtyPlusOdin);

    }
}
