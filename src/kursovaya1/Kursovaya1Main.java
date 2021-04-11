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
            //fitness.generateArrAbonentyKtoGde();
        fitness.DelaNaFitnese();
        int daNet = scanner.nextInt();
        if (daNet == 9)
        {
            System.out.println(" \\_G_A_M_E___O_V_E_R_/ ");
            return; //Погнали? 8- да; 9-нет
        }
        System.out.println("На часах 08ч 00минут и фитнесс-центр открыт.");

        while (true)
        {
            for (int i = 0; i < 3; i++)
            {
                fitness.DelaNaFitneseFm8To22Hours();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("\nЕсли пришли ещё абоненты - нажми 7.");
            System.out.println("Если надо посмотреть в каком зале кто находится и пришли ещё абоненты - нажми 6.");
            System.out.println("Если на часах время приближается к 22ч и пора закрывать фитнесс-центр - нажми 5.");
            int aa = scanner.nextInt();
            if (aa == 5) break;
            if (aa == 6) fitness.generateArrAbonentyKtoGde();
        }
        System.out.println("\nНа часах 21ч 59 мин и в залах такая обстановка.");
        fitness.generateArrAbonentyKtoGde(); // печатаем людей по залам

        System.out.println("\nНа часах 22ч 01 мин, фитнес клуб закрывается, клиенты покидают его и в залах такая обстановка и список всех абонентов.");
        fitness.generateVseUhodyatNaNoch(); // печатаем общий массив абонентов - должно быть у всех "сейчас находится: ни в каком из спортзалов."
        fitness.generateArrAbonentyKtoGde(); // печатаем людей по залам - должно быть по нулям



        System.out.println("\n \\_G_A_M_E___O_V_E_R_/ ");


    }
}
