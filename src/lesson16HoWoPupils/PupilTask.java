package lesson16HoWoPupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PupilTask
{
    public static void main(String[] args)
    {
        int qtyP = 10;
        Pupil[] arrPupils = new Pupil[qtyP];
        for (int i = 0; i < qtyP; i++)
        {
            arrPupils[i] = Pupil.getInstance();
        }
        System.out.println(Arrays.toString(arrPupils));
        LocalDate atNow = LocalDate.now();

        // Используя Stream API:
        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        /*Map<String, ArrayList<Pupil>> groupsMF = Arrays.stream(arrPupils)
                        //.collect(Collectors.toMap(Function.identity(), Collectors.toCollection(ArrayList::new), (item1, item2) -> item1 ) ;
                .collect(Collectors.groupingBy(gender -> Pupil::getGender),Collectors.toCollection(ArrayList::new));*/

    // 2. Найти средний возраст учеников = СДЕЛАНО!!!!!!!!!
        double betweenSred = Arrays.stream(arrPupils).collect(Collectors.averagingLong(Pupil::getMonthsBetween));
        int let = (int) (betweenSred / 12);
        System.out.println("\n2. Найти средний возраст учеников (" + ((int)(betweenSred)) +
                " мес.), составляет: " + let + " лет и " +
                ((int)(betweenSred - let * 12)) + " мес." );

    // 3. Найти самого младшего ученика = СДЕЛАНО!!!!!!!!!
        Pupil mladshiy = Arrays.stream(arrPupils).max(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getInstance());
        long betweenMlad = Math.abs(ChronoUnit.MONTHS.between(atNow, mladshiy.getBirth()));
        System.out.println("\n3. Найти самого младшего ученика (" + mladshiy.getBirth() +
                "): ему " + (betweenMlad / 12) + " лет и " + (betweenMlad - (betweenMlad / 12) * 12) + " мес." );

    // 4. Найти самого взрослого ученика = СДЕЛАНО!!!!!!!!!
        Pupil starshiy = Arrays.stream(arrPupils).min(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getInstance());
        long betweenStar = Math.abs(ChronoUnit.MONTHS.between(atNow, starshiy.getBirth()));
        System.out.println("\n4. Найти самого взрослого ученика (" + starshiy.getBirth() +
                "): ему " + (betweenStar / 12) + " лет и " + (betweenStar - (betweenStar / 12) * 12) + " мес." );

        // 5. Собрать учеников в группы по году рождения

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет

        // 9. Собрать в список всех учеников с именем=someName

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
    }
}