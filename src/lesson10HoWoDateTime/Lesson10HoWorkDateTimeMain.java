package lesson10HoWoDateTime;

import java.time.*;
import java.time.format.DateTimeFormatter;

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

        System.out.println("\nДата " + formatterDate.format(nowMoscow));
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



    }
}
