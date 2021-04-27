package lesson14HoWoCustomer;

import java.util.*;

public class MapTask {
    public static ArrayList<String> getListLoginov (HashMap<String, String> hashMap, String cityName)
    {
        ArrayList<String> arrListLoginov = new ArrayList<>();
        for (Map.Entry<String,String> entry : hashMap.entrySet())
        {
            if ( entry.getValue().compareToIgnoreCase(cityName) == 0 )
            {
                arrListLoginov.add(entry.getKey());
            }
        }
        return arrListLoginov;
    }

    public static HashMap<String, Integer> getQtyOdinakSlov (List<String> arrayList)
    {
        HashMap<String, Integer> hmQtyOdinakSlov = new HashMap<>();
        for (String al: arrayList)
        {
            hmQtyOdinakSlov.put(al, hmQtyOdinakSlov.getOrDefault(al, 0) +1 );
        }
        return hmQtyOdinakSlov;
    }

    public static void main(String[] args)
    {
        // TODO:: 1. написать статический метод,  - СДЕЛАНО!!!
        //  который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";
        System.out.println("\n1. написать статический метод, который принимает на вход мапу (например, firstTaskMap) " +
                "и город (например, city), формирует и возвращает список (List) логинов, которые соответствуют " +
                "переданному городу (city = \"Тверь\"): " + getListLoginov(firstTaskMap,city));

        // TODO:: 2. дан список слов (например, words).  - СДЕЛАНО!!!
        //  Написать статический метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        System.out.println("\n2. возвращать количество одинаковых слов с списке в виде Map<String, " +
                "Integer>: \n" + getQtyOdinakSlov(words));


        // TODO:: 3. дана мапа (например, customerMap). - СДЕЛАНО!!!
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));
        System.out.println("\n3. дана мапа (например, customerMap).\n" + customerMap);
        Random random = new Random();
        int ot = (random.nextInt(17) + 17);
        int doOo = (random.nextInt(54) + 36);
        HashMap<String, Customer> customerMapByYear = new HashMap<>();
        for (Map.Entry<String, Customer> entry: customerMap.entrySet())
        {
            if( (entry.getValue().getAge() >= ot) &&
                    (entry.getValue().getAge() < doOo) )
                customerMapByYear.put(entry.getKey(), entry.getValue());
        }
        System.out.println("новую мапу, в которую войдут все покупатели, возраст которых находится в " +
                "диапазоне [from{" + ot + "}, to){" + doOo + "}: \n" + customerMapByYear);


        // TODO:: 4... Задания по тексту (text). На каждый пункт - минимум один метод:
        //  - СДЕЛАНО!!! 1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        ArrayList<String> textAL = new ArrayList<>();
        Collections.addAll(textAL, text.toLowerCase().split(" "));
     //   System.out.println("4... " + textAL);
        System.out.println("\n4... Задания по тексту (text). На каждый пункт - минимум один метод: " +
                "\n\n4-1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова " +
                "в тексте \n" + getQtyOdinakSlov(textAL));

        //  - СДЕЛАНО!!! 2. написать метод, который собирает все слова в группы по количеству букв: например, в одну группу попадут слова:
        //  3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...] и тд
        //  результат сохранить в Map<Integer, ArrayList>

        int maxLetters = Integer.MIN_VALUE;
        for (String al: textAL )
        {
            if (al.length() > maxLetters) maxLetters = al.length();
        }
        //System.out.println(maxLetters);
        HashMap<Integer, ArrayList> num42 = new HashMap<>();
        for (int i = 1; i <= maxLetters; i++)
        {
            num42.put( i , getValueMap42(textAL,i) );
        }
        System.out.println("\n4-2. написать метод, который собирает все слова в группы по количеству букв: ");
        for (Map.Entry<Integer, ArrayList> entry: num42.entrySet())
        {
            System.out.println("       " + entry.getKey()); // возвращает ключ
            System.out.println(entry.getValue()); // возвращает значение
        }

        // - СДЕЛАНО!!!  3. написать метод, который выводит в консоль топ 10 самых частых слов - ЧТО-ТО ПОКА НЕ РАБОТАЕТ(((
        System.out.println("\n4-3. написать метод, который выводит в консоль топ 10 самых частых слов:");
        HashMap<String, Integer> num43 = getQtyOdinakSlov(textAL);
        int sizeMap = num43.size();
        TreeMap<Integer,String> num43TreeMap = new TreeMap<>();
        for (int i = 1; i <= sizeMap; i++)
        {
            int j = 0;
        for (Map.Entry<String, Integer> entry1: num43.entrySet() )
            {
                if (entry1.getValue() == i)
                {
                 num43TreeMap.put( (entry1.getValue() * 100 + j ), num43TreeMap.getOrDefault(entry1.getValue()
                                , "") + entry1.getKey() ); // + ", ");
                    j++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, String> entry1: num43TreeMap.entrySet() )
        {
            if ( entry1.getKey() > max ) max = entry1.getKey();
        }
        int sizeMapTree = num43TreeMap.size();
        int qtySlov = 0;
        Integer max1 = max;
        for (int i = 0; i < max; i++)
        {
            if (qtySlov == 10) break;
            for (Map.Entry<Integer, String> entry1: num43TreeMap.entrySet() )
            {
                    if (entry1.getKey().compareTo(max1) == 0) //.equals(max1))
                    {
                        System.out.println( (qtySlov + 1) + ": \"" + entry1.getValue() + "\" (" + (entry1.getKey() / 100)
                                + " раз) ");
                        qtySlov++;
                    }
            }
            max1--;
        }

    // - СДЕЛАНО!!!  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы
        System.out.println("\n4-4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы: ");
        String text1 = text.toLowerCase().replaceAll(" ","");
        text1 = text1.replaceAll("-","");
        char[] alText = text1.toCharArray();
    //    System.out.println(Arrays.toString(alText));
        TreeMap<Character,Integer> num44TreeMap = new TreeMap<>();
        for (char ch: alText )
        {
            num44TreeMap.put( ch , num44TreeMap.getOrDefault(ch,0) +1 );
        }
        System.out.println(num44TreeMap);
        double totSum = 0, w = 0, s = 0;
        for (Map.Entry<Character,Integer> entry2: num44TreeMap.entrySet() )
        {
            totSum += entry2.getValue();
        }
        //System.out.println(totSum);
        for (Map.Entry<Character,Integer> entry2: num44TreeMap.entrySet() )
        {
            w = (entry2.getValue() * 100 / totSum);
            System.out.println("-частота встречаемости буквы '" + entry2.getKey() + "' составляет = " +
                    w + " процентов.");
            s += w;
        }
        System.out.println("Проверка процентов: " + s);

    }
    public static ArrayList<String> getValueMap42(ArrayList<String> al, int max)
    {
        ArrayList<String> valueMap42 = new ArrayList<>();
                    for (String a : al)
                    {
                        if (a.length() == max) valueMap42.add(a);
                    }
        return valueMap42;
    }

}