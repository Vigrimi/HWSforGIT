package lesson7HoWoFerma;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson7HoWorkFermaMain
{
    public static void main(String[] args)
    {
        System.out.println("Дела на ферме нынче такие.");
        Fermer fermer = new Fermer();
        System.out.println(fermer);
        System.out.println("Армия домашних животных состоит из: " + Arrays.toString(DomashZhivotnye.getDomashZhivotnye()));
        System.out.println("Армия ДИКИХ животных состоит из: " + Arrays.toString(DikieZhivotnye.getDikieZhivotnye()));
        System.out.println("На ферме начинается новый день.");

        Scanner scanner = new Scanner(System.in);
        int daNet = 1;
        while (daNet == 1)
        {
            FermaZhivet fermaZhivet = new FermaZhivet();
            fermaZhivet.DenFermy();
            //System.out.println(fermaZhivet);
            System.out.println("День закончился. Следующий день? 1-да, 0 - нет");
            daNet = scanner.nextInt();
        }



    }
}
