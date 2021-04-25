package lesson16HoWoPupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

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
        Random random = new Random();

        // Используя Stream API:
    // 1. Разделить учеников на две группы: мальчиков и девочек.
    // Результат: Map<Pupil.Gender, ArrayList<Pupil>> = СДЕЛАНО!!!!!!!!!
        Map<Pupil.Gender, ArrayList<Pupil>> groupsMF = Arrays.stream(arrPupils)
                .collect(Collectors.groupingBy(pupil -> pupil.getGender(),
                        Collectors.toCollection(ArrayList::new)));
        System.out.println("\n1. Разделить учеников на две группы: мальчиков и девочек.");
        for (Map.Entry<Pupil.Gender, ArrayList<Pupil>> entry: groupsMF.entrySet())
        {
            System.out.println("                 " + entry.getKey()); // возвращает ключ
            System.out.println(entry.getValue()); // возвращает значение
        }

    // 2. Найти средний возраст учеников = СДЕЛАНО!!!!!!!!!
        double betweenSred = Arrays.stream(arrPupils).collect(Collectors.averagingLong(Pupil::getMonthsBetween));
        int let = (int) (betweenSred / 12);
        System.out.println("\n2. Найти средний возраст учеников (" + ((int)(betweenSred)) +
                " мес.), составляет: " + let + " лет и " +
                ((int)(betweenSred - let * 12)) + " мес." );
        // на уроке такой вариант:
//                double avgAge = Arrays.stream(arrPupils)
//                .mapToInt(pupil -> LocalDate.now().getYear() -
//                pupil.getBirth().getYear())
//                .average().orElse(0);

    // 3. Найти самого младшего ученика = СДЕЛАНО!!!!!!!!!
        Pupil mladshiy = Arrays.stream(arrPupils).max(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getInstance());
        long betweenMlad = Math.abs(ChronoUnit.MONTHS.between(atNow, mladshiy.getBirth()));
        long betweenMladLet = betweenMlad / 12;
        System.out.println("\n3. Найти самого младшего ученика (" + mladshiy.getBirth() +
                "): ему " + (betweenMladLet) + " лет и " + (betweenMlad - (betweenMladLet * 12)) + " мес." );

    // 4. Найти самого взрослого ученика = СДЕЛАНО!!!!!!!!!
        Pupil starshiy = Arrays.stream(arrPupils).min(Comparator.comparing(Pupil::getBirth)).orElse(Pupil.getInstance());
        long betweenStar = Math.abs(ChronoUnit.MONTHS.between(atNow, starshiy.getBirth()));
        long betweenStarLet = betweenStar / 12;
        System.out.println("\n4. Найти самого взрослого ученика (" + starshiy.getBirth() +
                "): ему " + (betweenStarLet) + " лет и " + (betweenStar - (betweenStarLet * 12)) + " мес." );

    // 5. Собрать учеников в группы по году рождения = СДЕЛАНО!!!!!!!!!
        Map<Integer, ArrayList<Pupil>> groupsBirthYear = Arrays.stream(arrPupils)
                .collect( Collectors.groupingBy( pupil -> pupil.getBirth().getYear() ,
                        Collectors.toCollection(ArrayList::new ) ) );
        System.out.println("\n5. Собрать учеников в группы по году рождения: ");
        for (Map.Entry<Integer, ArrayList<Pupil>> entry: groupsBirthYear.entrySet())
        {
            System.out.println("                 " + entry.getKey()); // возвращает ключ
            System.out.println(entry.getValue()); // возвращает значение
        }

    // 6. Оставить учеников с неповторяющимися именами, = СДЕЛАНО!!!!!!!!!
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]
        System.out.print("\n6. Оставить учеников с неповторяющимися именами: ");
        Map<String,List<Pupil>> num6 = Arrays.stream(arrPupils) // работает, но не как надо
                .collect(Collectors.groupingBy(Pupil::getName));
        num6.forEach((key,value) ->
                        {
                            System.out.println("\n" + key + ":");
                            value.forEach( pupil ->
                                    System.out.printf("   %s: %s", pupil.getName(), pupil.getBirth() ));
                        });

    // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List) = СДЕЛАНО!!!!!!!!!
        System.out.print("\n\n7. Отсортировать по полу, потом по ГОДУ рождения, потом по имени (в обратном порядке), собрать в список (List): ");
        List<Pupil> num7 = Arrays.stream(arrPupils)
                .sorted(
                Comparator.comparing(Pupil::getGender)
                        .thenComparing(Comparator.comparing( pupil -> pupil.getBirth().getYear() )) //(Pupil::getBirth))
                .thenComparing(Comparator.comparing(Pupil::getName).reversed())
        ).collect(Collectors.toList());
        System.out.println(num7);

    // 8. Вывести в консоль всех учеников в возрасте от N до M лет = СДЕЛАНО!!!!!!!!!
        long otLong = betweenMladLet + 1;
        long otLongMesyatsy = otLong * 12;
        long doLong = betweenStarLet - 1;
        long doLongMesyatsy = doLong * 12;
        System.out.println("\n8. Вывести в консоль всех учеников в возрасте от N = " + otLong + "лет (" +
                otLongMesyatsy + "мес.) до M = " + doLong + " лет (" + doLongMesyatsy + "мес.):");
        List<Pupil> num8 = Arrays.stream(arrPupils)
                .filter( pupil -> pupil.getMonthsBetween() > otLongMesyatsy && pupil.getMonthsBetween() < doLongMesyatsy )
                .collect(Collectors.toList());
        System.out.println(num8);

    // 9. Собрать в список всех учеников с именем=someName = СДЕЛАНО!!!!!!!!!
        String[] arrNames = new String[qtyP];
        for (int i = 0; i < qtyP; i++)
        {
            arrNames[i] = arrPupils[i].getName();
        }
        String someName = arrNames[random.nextInt(qtyP)];
        System.out.print("\n9. Собрать в список всех учеников с именем=someName: -=" + someName + "=-: ");
        List<Pupil> num9 = Arrays.stream(arrPupils).filter( pupil -> pupil.getName().equalsIgnoreCase(someName) )
                .collect(Collectors.toList());
        System.out.println(num9);

    // 10. Собрать Map<Pupil.Gender, Integer>,  = СДЕЛАНО!!!!!!!!!
        // где Pupil.Gender - пол,
        // Integer - суммарный возраст учеников данного пола
        System.out.println("\n10. Собрать Map<Pupil.Gender, Integer>, где Integer - суммарный возраст учеников данного пола: ");
        Map<Pupil.Gender, Long> num10 = Arrays.stream(arrPupils)
                .collect(Collectors.groupingBy(Pupil::getGender,
                        Collectors.summingLong(
                                //pupil -> LocalDate.now().getYear() - pupil.getBirth().getYear()
                                pupil -> pupil.getMonthsBetween()
                        )
                ));
        for (Map.Entry<Pupil.Gender, Long> entry: num10.entrySet())
        {
            System.out.println("                 " + entry.getKey()); // возвращает ключ
            System.out.println("суммарный возраст учеников данного пола: " + entry.getValue() + " мес. = " + ( entry.getValue() / 12 ) + " лет и " +
                    ( entry.getValue() - ( entry.getValue() / 12 ) *12 ) + "мес." ); // возвращает значение
        }
    }
}