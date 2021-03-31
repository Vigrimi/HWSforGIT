package Lesson6HoWoCats;

import java.util.Scanner;

public class Lesson6HoWorkCatsMain
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int go = 1;
        while (go > 0)
        {
            Mouse mouse = new Mouse();
            mouse.getSpeedMouse();

            Cat cat = new Cat();
            cat.getNameCat();
            cat.getColourCat();
            cat.getSpeedCat();
            cat.getWeightCat();

            System.out.println(mouse);
            System.out.println(cat);

            System.out.println("\nПогнали дальше? 1-да 0-нет: ");
            go = scanner.nextInt();

        }

        System.out.println("_G A M E  O V E R_");
    }
}
