package kursovaya1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public interface KtonGde
{
    default void ktoChemZanimaetsya(FioAbonenta[] arrAbonenty)
        /*(FioAbonenta[] fioAbonenta,
                                     FioAbonenta[] arrLyudiVZale,
                                     FioAbonenta[] arrNePopal,
                                     int gdeNahoditsyaAbonent, // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                                     int maxQtyLyudeyBassein,
                                     int vBassHotyatPopast)*/
    {
        //перебираем кто в каком зале
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        System.out.println("\nВ бассейне сейчас находятся: "); // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            if (arrAbonenty[i].gdeNahoditsyaAbonent == 1) System.out.println(arrAbonenty[i] +
                    " Дата " + ld + " и время посещения " + lt);
        }

        System.out.println("\nВ тренажёрном зале сейчас находятся: "); // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            if (arrAbonenty[i].gdeNahoditsyaAbonent == 2) System.out.println(arrAbonenty[i] +
                    " Дата " + ld + " и время посещения " + lt);
        }

        System.out.println("\nВ зале групповых занятий сейчас находятся: "); // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            if (arrAbonenty[i].gdeNahoditsyaAbonent == 3) System.out.println(arrAbonenty[i] +
                    " Дата " + ld + " и время посещения " + lt);
        }
        //System.out.println("interface");
        // передумал
        /*//int vBassHotyatPopast = (int) ( Math.random() * 15 + 12 );
        if (vBassHotyatPopast <= maxQtyLyudeyBassein)
        {
            for (int i = 0; i < arrLyudiVZale.length; i++)
            {
                for (int j = 0; j < fioAbonenta.length; j++)
                {
                    if (fioAbonenta[j].gdeNahoditsyaAbonent == 0)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                    {
                        arrLyudiVZale[i] = fioAbonenta[j];
                        fioAbonenta[j].gdeNahoditsyaAbonent = 1;
                        break;
                    }
                }
            }
        }
        if (vBassHotyatPopast > maxQtyLyudeyBassein)
        {
            for (int i = 0; i < arrLyudiVZale.length; i++)
            {
                for (int j = 0; j < fioAbonenta.length; j++)
                {
                    if (fioAbonenta[j].gdeNahoditsyaAbonent == 0)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                    {
                        arrLyudiVZale[i] = fioAbonenta[j];
                        fioAbonenta[j].gdeNahoditsyaAbonent = 1;
                        break;
                    }
                }
            }
            for (int k = 0; k < (vBassHotyatPopast - maxQtyLyudeyBassein); k++)
            {
                for (int n = 0; n < fioAbonenta.length; n++)
                {
                    if (fioAbonenta[n].gdeNahoditsyaAbonent != 1)  // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                    {
                        arrNePopal[k] = fioAbonenta[n];
                    *//*System.out.println("Абонент " + fioAbonenta[k].nameAbonenta + " " +
                            fioAbonenta[k].surnameAbonenta +
                            " номер абоненемента " + fioAbonenta[k].unikNomerAbonementa +
                            " хотел попасть в бассейн, но " +
                            "в нём уже находится максимально число посетитетелей в количестве " + maxQtyLyudeyBassein +
                            " человек.");*//*
                    }
                }

            }
        }*/
    }

    default void vseUhodyatNaNoch(FioAbonenta[] arrAbonenty)
    {
        for (int i = 0; i < arrAbonenty.length; i++)
        {
            arrAbonenty[i].gdeNahoditsyaAbonent = 0;
        }
        System.out.println(Arrays.toString(arrAbonenty));
    }
}
