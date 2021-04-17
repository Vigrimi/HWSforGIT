package lesson10HoWoDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import static java.time.DayOfWeek.*;

public class Lesson10HoWorkDateTimeMain
{
    public static void main(String[] args)
    {
        /*Задача 1
        Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.*/

        LocalDateTime nowMoscow = LocalDateTime.now();

        DateTimeFormatter formatterDate = DateTimeFormatter
                .ofPattern("dd MMMM yyyy.");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH часов mm минут.");

        System.out.println("\nЗадача 1.\nДата " + formatterDate.format(nowMoscow));
        ZonedDateTime msk = nowMoscow.atZone(ZoneId.of("Europe/Moscow"));
        System.out.println("Сейчас время московское: " + formatterTime.format(msk));
        ZonedDateTime sydney = msk.withZoneSameInstant(ZoneId.of("Australia/Sydney"));
        System.out.println("Самолет вылетает из Сиднея: " + formatterDate.format(sydney) +
                " Время местное " + formatterTime.format(sydney));
        System.out.println("Время в пути Сидней -  Хьюстон - 15 часов 35 минут.");
        ZonedDateTime sydneyPriletHuston = sydney.plusHours(15).plusMinutes(35);
        System.out.println("Самолет прилетел в Хьюстон: " + formatterDate.format(sydneyPriletHuston) +
                " Время по Cиднею " + formatterTime.format(sydneyPriletHuston));
        ZonedDateTime hustonPrilet = sydneyPriletHuston.withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println("Самолет прилетел в Хьюстон: " + formatterDate.format(hustonPrilet) +
                " Время по Хьюстонy " + formatterTime.format(hustonPrilet));
        ZonedDateTime hustonVylet = hustonPrilet.plusHours(1);
        System.out.println("Время ожидания в аэропорту Хьюстона - 1 час. Самолёт вылетает. Время по Хьюстонy "
                + formatterTime.format(hustonVylet));
        System.out.println("Время в пути  Хьюстон - Вашингтон = 2 часа 49 минут.");
        ZonedDateTime hustonPriletWashington = hustonVylet.plusHours(2).plusMinutes(49);
        System.out.println("Самолет прилетел в Вашингтон: " + formatterDate.format(hustonPriletWashington) +
                " Время по Хьюстонy " + formatterTime.format(hustonPriletWashington));
        ZonedDateTime washingtonPrilet = hustonPriletWashington.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Самолет прилетел в Вашингтон: " + formatterDate.format(washingtonPrilet) +
                " Время по Вашингтонy " + formatterTime.format(washingtonPrilet));
        ZonedDateTime washingtonVylet = washingtonPrilet.plusHours(1).plusMinutes(10);
        System.out.println("Время ожидания в аэропорту Вашингтона - 1 час 10 минут. Самолёт вылетает. Время по Вашингтонy "
                + formatterTime.format(washingtonVylet));
        System.out.println("Время в пути Вашингтон - Оттава - 1 час 40 минут.");
        ZonedDateTime washingtonPriletOttawa = washingtonVylet.plusHours(1).plusMinutes(40);
        System.out.println("Самолет прилетел в Оттавy: " + formatterDate.format(washingtonPriletOttawa) +
                " Время по Вашингтонy " + formatterTime.format(washingtonPriletOttawa));
        ZonedDateTime ottawaPrilet = washingtonPriletOttawa.withZoneSameInstant(ZoneId.of("America/Toronto"));
        System.out.println("Самолет прилетел в Оттавy: " + formatterDate.format(ottawaPrilet) +
                " Время по Оттавe " + formatterTime.format(ottawaPrilet));
        System.out.println("Задача 1.\nTHE END ");

        ///////////////////////////////////////////////////////////////////////////////
        /*Задача 2*/
        LocalTime nowTime = LocalTime.now();
        LocalTime sevenOclock = LocalTime.of(07, 00, 00);
        LocalTime fifteenOclock = LocalTime.of(15, 00, 00);
        LocalTime twentyThreeOclock = LocalTime.of(23, 00, 00);
        //System.out.println("Сейчас время московское: " + formatterTime.format(sevenOclock));
        System.out.println("\nЗадача 2. \nЕсть три рабочие смены :\n" +
                "с 7:00 до 15:00 утренняя;\n" +
                "с 15:00 до 23:00 дневная;\n" +
                "с 23:00 до 7:00 ночная.\n");
        if (nowTime.isAfter(sevenOclock) && nowTime.isBefore(fifteenOclock))
            System.out.println("Сейчас УТРЕННЯЯ смена, так как на часах: " + formatterTime.format(nowTime));
        else if (nowTime.isAfter(fifteenOclock) && nowTime.isBefore(twentyThreeOclock))
            System.out.println("Сейчас ДНЕВНАЯ смена, так как на часах: " + formatterTime.format(nowTime));
        else System.out.println("Сейчас НОЧНАЯ смена, так как на часах: " + formatterTime.format(nowTime));
        System.out.println("Задача 2.\nTHE END ");

        ///////////////////////////////////////////////////////////////////////////////
        /*Задача 3
        Допустим, наше последнее занятие состоится 16 июня 2021 года.*/
        LocalDateTime june162021 = LocalDateTime.of(2021,Month.JUNE,16,10,00);
        System.out.println("\nЗадача 3. Допустим, наше последнее занятие состоится 16 июня 2021 года " +
                "(" + june162021.getDayOfWeek() + ").");
        LocalDateTime atNow = LocalDateTime.now();
        System.out.println("Сегодня дата: " + formatterDate.format(atNow));
        int qtyMon = 0, qtyWed = 0, qtyFri = 0;
        long between = ChronoUnit.DAYS.between(atNow, june162021);
        for (long i = 0; i <= (between + 1); i++)
        {
            if (atNow.getDayOfWeek().compareTo(MONDAY) == 0) qtyMon++;
            else if (atNow.getDayOfWeek().compareTo(WEDNESDAY) == 0) qtyWed++;
            else if (atNow.getDayOfWeek().compareTo(FRIDAY) == 0) qtyFri++;
            atNow = atNow.plusDays(1);
        }
        System.out.println("Занятия проходят 3 раза в неделю (пн, ср, пт). \nДо назначенной " +
                "даты осталось: " + qtyMon + " понедельников, " + qtyWed + " сред, " +
                qtyFri + " пятниц. \nИтого, всего в сумме понедельников, сред и " +
                "пятниц, в количестве = " + (qtyFri + qtyWed + qtyMon) + " шт.");
        System.out.println("На подготовку диплома дается 2 недели после последнего занятия, защита " +
                "диплома состоится " + formatterDate.format(june162021.plusWeeks(2)));
        System.out.println("Задача 3.\nTHE END ");
    }
}
