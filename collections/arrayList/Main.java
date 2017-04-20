package collections.arrayList;

import collections.linkedList.List;
import java.util.Iterator;

/**
 * Created by l1s on 27.03.17.
 */
public class Main {
    public static void main(String[] args) {
        /*List list = new arrayList();
        String s = "test";
        for (int i = 0; i < 12; i++) {
            list.add(s + i);
        }

        list.remove(0);
        list.remove(3);
        list.remove("test1");

        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object val = iterator.next();
            System.out.println(val);
        }*/

        List<String> list = new ArrayList<>();
        list.add("Всё");
        list.add("работает");

        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
