package collections.multiThreadsWarAndPeace.collections;

import collections.multiThreadsWarAndPeace.collections.inner.Message;
import collections.multiThreadsWarAndPeace.collections.inner.MessageGenerator;
import collections.multiThreadsWarAndPeace.collections.inner.MessagePriority;
import collections.multiThreadsWarAndPeace.collections.inner.User;

import java.util.*;

import static collections.multiThreadsWarAndPeace.collections.inner.MessagePriority.MEDIUM;
import static collections.multiThreadsWarAndPeace.collections.inner.UserGenerator.generate;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {
    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();
        List<Message> list = generator.generate(10);

        System.out.println("НЕОТСОРТИРОВАННЫЙ СПИСОК СООБЩЕНИЙ\n" + list);
        System.out.println("\nСОРТИРОВКА СООБЩЕНИЙ ПО ЗАДАННОЙ ВАЖНОСТИ:");
        sortByPriority(list, MEDIUM);

        List<User> list2 = generate(10);
        System.out.println("\nНЕОТСОРТИРОВАННЫЙ СПИСОК ЮЗЕРОВ:\n" + list2);
        System.out.println("\nСОРТИРОВКА ЮЗЕРОВ ПО КОМПАНИИ И ИМЕНИ:\n" + sortedByCompanyAndName(list2));
        System.out.println("\nСОРТИРОВКА ЮЗЕРОВ ПО ЗАРПЛАТЕ И ИМЕНИ:\n" + sortedBySalaryAndName(list2));
        System.out.println("\nСОРТИРОВКА ЮЗЕРОВ ПО ЗАРПЛАТЕ, ВОЗРАСТУ, КОМПАНИИ И ИМЕНИ:\n"
                +sortedBySalaryAgeCompanyAndName(list2));

        List<User> list3 = generate(3);
        List<User> list4 = generate(2);

        Iterator<User> iterator = viewIterator(list3, list4);

        System.out.println("\nПРОВЕРКА ИТЕРАТОРА:");
        while (iterator.hasNext()) {
            User u = iterator.next();
            System.out.println(u);
        }
    }

    private static void sortByPriority(List<Message> messages, MessagePriority priority) {
        messages.sort((o1, o2) -> {
            if (o1.getPriority() == priority && o2.getPriority() == priority)
                return 0;
            else if (o1.getPriority() == priority)
                return -1;
            else if (o2.getPriority() == priority)
                return 1;
            else
                return o1.getPriority().compareTo(o2.getPriority());
        });
        System.out.println(messages);
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.companyAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.salaryAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {
        NavigableSet<User> ns = new TreeSet<>(User.salaryAgeCompanyAndNameComparator);
        ns.addAll(users);
        return ns;
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {
        Iterator<T> comboIterator = new Iterator<T>() {
            Iterator<T> i1 = it1.iterator();
            Iterator<T> i2 = it2.iterator();

            @Override
            public boolean hasNext() {
                if (i1.hasNext()) return true;

                else if (i2.hasNext()) return true;

                return false;
            }

            @Override
            public T next() {
                if (i1.hasNext())
                    return i1.next();

                else if (i2.hasNext())
                    return i2.next();

                return null;
            }
        };
        return comboIterator;
    }
}