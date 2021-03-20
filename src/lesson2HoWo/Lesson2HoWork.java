package lesson2HoWo;

import java.util.Scanner;

public class Lesson2HoWork
{
    public static void main(String[] args)
    {
        /*1. Задача на if
        Дана целочисленная переменная count - количество верных ответов.
        В зависимости от значения этой переменной вывести в консоль оценку:
        100 - 90 правильных ответов - отлично
        89 - 60 правильных ответов - хорошо
        59 - 40 правильных ответов - удовлетворительно
        39 - 0 правильных ответов - попробуйте в следующий раз  */

        Scanner in = new Scanner(System.in);
        System.out.println("1. Задача на if.\n Введи целое число от 0 до 100: ");
        int count = in.nextInt();
        while (count < 0 || count > 100)
        {
            System.out.println("Ошибка! Введи целое число от 0 до 100: ");
            count = in.nextInt();
        }
        if (count >= 90 && count <= 100) System.out.println("отлично");
        else if (count >= 60 && count <= 89) System.out.println("хорошо");
        else if (count >= 40 && count <= 59) System.out.println("удовлетворительно");
        else if (count >= 0 && count <= 39) System.out.println("попробуйте в следующий раз");

        /*2. Задача на switch
        Пользователь вводит 3 числа:
        1е - первый операнд
        2e - второй операнд
        3е - оператор
        В зависимости от третьего введенного числа нужно вывести в консоль:
        сумму, разность, умножение, деления чисел, которые ввел пользователь.
        Если 3е введенное число 3, нужно найти сумму,
        если 5 - разность,
        если 7 - результат умножения,
        если 9 - результат деления.*/

        System.out.println("\n2. Задача на switch\n Введи целое число первый операнд: ");
        int firstOper = in.nextInt();
        System.out.println("Введи целое число второй операнд: ");
        int secondOper = in.nextInt();
        System.out.println("Введи значение оператора - 3 или 5 или 7 или 9: ");
        int operator;
        while (true)
        {
            operator = in.nextInt();
            if (operator == 3 || operator == 5 || operator == 7 || operator == 9) break;
            System.out.println("Ошибка! Введи значение оператора: 3 или 5 или 7 или 9: ");
        }
        double resDeleniya = (double) firstOper / (double) secondOper;

        switch (operator)
        {
            case 3:
                System.out.println("введённое число 3, сумма: " + (firstOper + secondOper));
                break;
            case 5:
                System.out.println("введённое число 5, разность: " + (firstOper - secondOper));
                break;
            case 7:
                System.out.println("введённое число 7, результат умножения: " + (firstOper * secondOper));
                break;
            case 9:
                System.out.println("введённое число 9, результат деления: " + resDeleniya); //(firstOper / secondOper) + " с остатком " + (firstOper % secondOper));
                break;
        }

 /*       3. Задача на цикл while
        Считать с консоли количество тарелок и количество моющего средства
        Моющее средство расходуется из расчета 0.5 на 1 тарелку
        В цикле выводить сколько моющего средства осталось после мытья каждой тарелки.
            В конце вывести сколько тарелок осталось, когда моющее средство закончилось или
        наоборот.*/
        int qtyPlates;
        while (true)
        {
            System.out.println("\n3. Задача на цикл while\n Введи целое число количество тарелок: ");
            qtyPlates = in.nextInt();
            if (qtyPlates > 0) break;
        }

        //int qtyPlatesLeft = qtyPlates;
        System.out.println("Введи число количество моющего средства (разделение целого через запятую): ");
        double qtyWashing = in.nextDouble();
        //System.out.println(qtyPlates + "///" + qtyWashing);
        //double qtyWashingLeft = qtyWashing;
        while (true)
        {
            if (qtyPlates <= 0 || qtyWashing <= 0.49) break;
            qtyPlates -= 1;
            qtyWashing -= 0.5;
        }
        System.out.println(qtyPlates == 0 ? "Тарелки закончились, а осталось моющее средство: " + qtyWashing : "Моющее средство закончилось или его недостаточно для мытья одной тарелки, а остались тарелки: " + qtyPlates);

     /*   4. Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        если введен 0, выводит "выход из программы" (программа завершает работу)*/
        int randomDigitInt;
        while (true)
        {
            double randomDigit = Math.random();
            //System.out.println(randomDigit);
            randomDigit *= 10;
            //System.out.println(randomDigit);
            randomDigitInt = (int) randomDigit;
            //System.out.println(randomDigitInt);
            if (randomDigit >= 1 && randomDigitInt < 10) break;
        }
        System.out.println("\n4. Программа загадывает число в диапазоне от 1 до 9.\n Введи целое число, чтобы угадать его: ");
        int inputDigit = in.nextInt();
        if (inputDigit == 0)
        {
            System.out.println("выход из программы (программа завершает работу)");
        } else
            while (true)
            {
                if (inputDigit > randomDigitInt && inputDigit != 0)
                {
                    System.out.println("загаданное число меньше, введи другое число");
                    inputDigit = in.nextInt();
                }
                else if (inputDigit < randomDigitInt && inputDigit != 0)
                {
                    System.out.println("загаданное число больше, введи другое число");
                    inputDigit = in.nextInt();
                }
                else if (inputDigit == 0)
                {
                    System.out.println("выход из программы (программа завершает работу)");
                    break;
                }
                else if (inputDigit == randomDigitInt)
                {
                    System.out.println("Вы угадали!!! :o)) (программа завершает работу)");
                    break;
                }
            }

      /*  5. Задача на Math.random() и if
        Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500]
        в интервал (25;200) и выводить результат в консоль.
            Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)*/
        int randomDigitInt5;
        while (true)
        {
            double randomDigit5 = Math.random();
            randomDigit5 *= 1000;
            randomDigitInt5 = (int) randomDigit5;
            if (randomDigit5 >= 10 && randomDigitInt5 < 501) break;
        }
        if (randomDigitInt5 < 25 || randomDigitInt5 > 200) System.out.println("5. Задача на Math.random() и if\n Число " + randomDigitInt5 + " HE содержится в интервале (25;200)");
        else System.out.println("\n5. Задача на Math.random() и if\n Число " + randomDigitInt5 + " содержится в интервале (25;200)");

        /*6. Пользователь!!! загадывает число в диапазоне от [1 до 100]
        Программа пытается его угадать (используйте метод !!!бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы:
    Число равно ...? / Число больше ...? / Число меньше ...?
        и в зависимости от ответа пользователя принимать решения.
        !!! Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/
        int daNet = 100;
        int zagadannoe = 50, delta = 50;
        int a = 2, steps = 1;

        System.out.println("\n6. Пользователь!!! загадывает число в диапазоне от [1 до 99].\nКомпьютер попытается угадать максимум за 7 шагов.\n1) Загаданное число - это 50?");
        System.out.println("Если компьютер угадал - нажми 1. Если загаданное число больше - нажми 2. Если загаданное число меньше - нажми 3");

        while (zagadannoe > 0 && zagadannoe <100)
        {
            steps++;
            delta = delta / 2;
            if (delta == 0) delta = 1;

            daNet = in.nextInt();
            if (daNet == 3) //no i menshe
            {
                zagadannoe = zagadannoe - delta;
                System.out.println(steps + ") Загаданное число - это " + zagadannoe + "?" );
                delta++;
            } else if (daNet == 2) //no i bolshe
            {
                zagadannoe = zagadannoe + delta;
                System.out.println(steps + ") Загаданное число - это " + zagadannoe + "?" );
                delta++;
            } else if (daNet == 1) break;
        }
        if (zagadannoe <= 0 || zagadannoe >= 100)
        {
            System.out.println("Оййй, кто-то заврался >:()");
        } else System.out.println("Ура! Число отгадано!");

    }
}
