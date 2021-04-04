package lesson7HoWoFerma;

import java.util.Arrays;

public class Lesson7HoWorkFermaMain
{
    public static void main(String[] args)
    {
        System.out.println("Дела на ферме нынче такие.");
        Fermer fermer = new Fermer();
        System.out.println(fermer);
        System.out.println("Армия домашних животных состоит из: " + Arrays.toString(DomashZhivotnye.getDomashZhivotnye()));
        System.out.println("Армия ДИКИХ животных состоит из: " + Arrays.toString(DikieZhivotnye.getDikieZhivotnye()));

    }
}
