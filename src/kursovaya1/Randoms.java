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
