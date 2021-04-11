package kursovaya1;

public interface KtonGde
{
    default void ktoChemZanimaetsya (FioAbonenta[] fioAbonenta,
                                     FioAbonenta[] arrLyudiVZale,
                                     FioAbonenta[] arrNePopal,
                                     int gdeNahoditsyaAbonent, // 0-nigde, 1-v basseyne, 2-v trenazherke, 3-v zale gruppovyh
                                     int maxQtyLyudeyBassein,
                                     int vBassHotyatPopast)
    {
        //int vBassHotyatPopast = (int) ( Math.random() * 15 + 12 );
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
                    /*System.out.println("Абонент " + fioAbonenta[k].nameAbonenta + " " +
                            fioAbonenta[k].surnameAbonenta +
                            " номер абоненемента " + fioAbonenta[k].unikNomerAbonementa +
                            " хотел попасть в бассейн, но " +
                            "в нём уже находится максимально число посетитетелей в количестве " + maxQtyLyudeyBassein +
                            " человек.");*/
                    }
                }

            }
        }
    }
}
