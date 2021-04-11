package kursovaya1;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Kursovaya1Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Fitness fitness = new Fitness();
        fitness.DelaNaFitnese();
        int daNet = scanner.nextInt();
        if (daNet == 9) return; //Погнали? 8- да; 9-нет
        System.out.println("На часах 08ч 00минут и фитнесс-центр открыт.");
        for (int i = 0; i < 10; i++)
        {
            fitness.DelaNaFitneseFm8To22Hours();
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}
