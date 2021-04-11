package kursovaya1;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Randoms
{
    public static int getRandomFm0To55()
    {
        int randomFm0To55 = (int) (Math.random() * 56);
        return randomFm0To55;
    }
    public static int getRandomFm0To2()
    {
        int randomFm0To2 = (int) (Math.random() * 3);
        return randomFm0To2;
    }
    public static int getRandomFm1To6()
    {
        int randomFm1To6 = (int) (Math.random() * 6 + 1);
        return randomFm1To6;
    }
    public static int getRandomFm12To26()
    {
        int randomFm12To26 = (int) ( Math.random() * 15 + 12 );
        return randomFm12To26;
    }
    public static int getRandomGodRozhdeniya()
    {
        LocalDateTime god = LocalDateTime.now();
        int god1 = god.getYear();
        int randomGodRozhdeniya = 1;
        while (!(randomGodRozhdeniya < (god1 - 16) && randomGodRozhdeniya > (god1 - 120)))
        {
            randomGodRozhdeniya = (int) (Math.random() * 60 + 1935);
        }
        return randomGodRozhdeniya;
    }
    public static LocalDateTime getDateTime()
    {
        LocalDateTime nachaloAbonementa = LocalDateTime.now();
        nachaloAbonementa = nachaloAbonementa
                .plusMonths(-(getRandomFm1To6()))
                .minusDays(getRandomFm1To6())
                .minusMinutes(3 * getRandomFm1To6()).
                minusSeconds(8 * getRandomFm1To6());
        return nachaloAbonementa;
    }
}
