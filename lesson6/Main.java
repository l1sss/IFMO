package lesson6;

import java.util.Iterator;

/**
 * Created by xmitya on 20.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Stack list = new LinkedList();

        for (int i = 0; i < 10; i++) {
            list.push(String.valueOf(i));
        }

        for (Object s : list) {
            System.out.println(s);
        }

        System.out.println();

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object val = iterator.next();
            System.out.println(val);
        }
    }
}
