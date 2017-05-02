package collections.multiThreadsWarAndPeace.collections;

import collections.multiThreadsWarAndPeace.collections.inner.Message;
import collections.multiThreadsWarAndPeace.collections.inner.MessageGenerator;
import collections.multiThreadsWarAndPeace.collections.inner.MessagePriority;

import java.util.*;

import static collections.multiThreadsWarAndPeace.collections.inner.MessagePriority.LOW;

/**
 * Created by xmitya on 17.10.16.
 */
public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        genuineMessagesInOriginalOrder(messages);

        System.out.println("\nGenuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages) + "\n");

        removeEach(generator.generate(100), LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    // Сосчитайте количество сообщений для каждого приоритета.
    // Ответ необходимо вывести в консоль.
    private static void countEachPriority(List<Message> messages) {
        int lowCnt = 0;
        int mediumCnt = 0;
        int highCnt = 0;
        int urgentCnt = 0;

        for (Message m : messages) {
            switch (m.getPriority()) {
                case LOW:
                    lowCnt++;
                    break;
                case MEDIUM:
                    mediumCnt++;
                    break;
                case HIGH:
                    highCnt++;
                    break;
                case URGENT:
                    urgentCnt++;
                    break;
            }
        }
        System.out.println
                (" MESSAGE PRIORITY:" +
                "\nLOW= " + lowCnt +
                "\nMEDIUM= " + mediumCnt +
                "\nHIGH= " + highCnt +
                "\nURGENT= " + urgentCnt);
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Message m : messages) {
            Integer key = m.getCode();
            Integer count = map.get(key);
            if (count == null) count = 0;

            map.put(key, count + 1);
        }

        System.out.println("\n CODE COUNT:");
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.

        Set<Message> set = new HashSet<>();

        for (Message m : messages) {
            set.add(m);
        }

        System.out.println("\n UNIQUE MESSAGEES:\n" + set.size());
    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.

        //Set<Message> set = new LinkedHashSet<>();

        List<Message> result = new ArrayList<>();

        for (Message m : messages) {
            if (result.contains(m)) continue;
            else
                result.add(m);
        }

        return result;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);

        messages.removeIf(m -> m.getPriority() == priority);

        System.out.printf("After remove each: %s, %s\n", priority, messages + "\n");
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);

        Iterator<Message> iterator = messages.iterator();

        while (iterator.hasNext()) {
            Message m = iterator.next();
            if (m.getPriority() != priority) iterator.remove();
        }

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
