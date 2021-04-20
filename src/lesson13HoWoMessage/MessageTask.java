package lesson13HoWoMessage;

import java.util.*;

public class MessageTask
{
    public static void main(String[] args)
    {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages); // вызов методов

        countEachPriority(messages);
        countEachCode(messages);
        uniqueMessageCount(messages);
        System.out.println("\nвернуть только неповторяющиеся сообщения и в том порядке," +
                " в котором они встретились в первоначальном списке:");
        System.out.println(uniqueMessagesInOriginalOrder(messages));

        Random random = new Random();
        int typesCount1 = Message.MessagePriority.values().length;
        System.out.println( "\nсоздать коллекцию и передать в неё ссылки на каждое сообщение с заданным " +
                "приоритетом " + copyEach(messages,Message.MessagePriority.getPriority(random.nextInt(typesCount1))) );

        System.out.println( "\nсоздать коллекцию и передать в неё ссылки на все сообщения, кроме тех, которые имеют " +
                "заданный приоритет " + copyOther(messages,Message.MessagePriority
                .getPriority(random.nextInt(typesCount1))) );

    }

    public static void countEachPriority(List<Message> messageList)
    {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль = СДЕЛАНО!!!
        // LOW, MEDIUM, HIGH, URGENT;
        // [ 0, 0     , 0   , 0    ]
        int[] counts = new int[Message.MessagePriority.values().length];
        for (Message message : messageList) {
            counts[message.getPriority().ordinal()]++;
        }
        System.out.println("\nколичество сообщений для каждого приоритета: ");
        for (int i = 0; i < counts.length; i++)
        {
            System.out.print(Message.MessagePriority.getPriority(i) + " = " + counts[i] + ", ");
        }
    }

    public static void countEachCode(List<Message> messageList)
    {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль - СДЕЛАНО!!!
        // HashMap<код сообщения, количество сообщений>
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Message message : messageList)
        {
            int CODE = message.getCode();
            countMap.put(CODE, countMap.getOrDefault(CODE, 0) + 1);
            /* или так if (countMap.containsKey(CODE))
            {
                countMap.put(CODE, countMap.get(CODE) + 1);
            } else
            {
                countMap.put(CODE, 1);
            }*/
         }
        System.out.println("\n\nколичество сообщений для каждого кода сообщения: ");
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet())
        {
            System.out.println("У кода: " + entry.getKey() + ", всего " + entry.getValue() + " сообщений. ");
        }
    }

    public static void uniqueMessageCount(List<Message> messageList)
    {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль - СДЕЛАНО!!!
        System.out.print("\nколичество уникальных сообщений (оно же размер Set) = ");
        System.out.println(new HashSet<>(messageList).size());
        //System.out.println(new HashSet<>(messageList));
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList)
    {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}] - СДЕЛАНО!!!
        return new ArrayList<>(new LinkedHashSet<>(messageList));
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority)
    {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию - СДЕЛАНО!!!
        List<Message> copyEachArrLi = new ArrayList<>();
        for (Message ml: messageList )
        {
            if (ml.getPriority().equals(priority))
            {
                copyEachArrLi.add(ml);
            }
        }
        return copyEachArrLi;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority)
    {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию - СДЕЛАНО!!!
        List<Message> copyOtherArrLi = new ArrayList<>();
        for (Message ml: messageList )
        {
            if (!(ml.getPriority().equals(priority)))
            {
                copyOtherArrLi.add(ml);
            }
        }
        return copyOtherArrLi;
    }


}