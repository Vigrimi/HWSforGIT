package kursovaya1;

public class ZalBasseyn
{
    public static final int maxQtyLyudeyBassein = 20;
    public static FioAbonenta[] arrAbonenty;
    public static ZalBasseyn[] arrLyudiVBasseine;
    public static int vBassHotyatPopast;

    public static ZalBasseyn[] getArrLyudiVBasseine()
    {
        vBassHotyatPopast = (int) ( Math.random() * 15 + 12 );
        arrLyudiVBasseine = new ZalBasseyn[maxQtyLyudeyBassein];
        if (vBassHotyatPopast <= maxQtyLyudeyBassein)
        {
            for (int i = 0; i < arrLyudiVBasseine.length; i++)
            {

            }
        }

        return arrLyudiVBasseine;
    }


}
