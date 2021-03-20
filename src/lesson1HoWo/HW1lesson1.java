package lesson1HoWo;

public class HW1lesson1
{
    public static void main(String[] args)
    {
        long start = 32L, end = 235L, between = 0L;
        between = end - start;
        System.out.print("2. Задача на тернарный оператор:");
        System.out.println(start < end ? between : "-1");

        System.out.println("3. Задача на арифметические операторы (2х значного): " + (start / 10 + start % 10) );

        long sotni = end / 100;
        long desyatki = (end - sotni * 100) / 10;
        long edinitsy = end - sotni * 100 - desyatki * 10;
        System.out.println("4. Задача на арифметические операторы (3х значного): " + (sotni + desyatki + edinitsy));

    }

}
