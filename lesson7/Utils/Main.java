package lesson7.Utils;

import lesson4.linkedList.LinkedList;
import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

/**
 * Created by l1s on 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(10);

        ArrayList list2 = new ArrayList();
        list2.add("Aa");
        list2.add("a");
        list2.add("d3");
        list2.add("1");

        ArrayList list3 = new ArrayList();
        list3.add(1);
        list3.add(1234);
        list3.add(3);

        Predicate pred = new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return ((Integer) obj > 1 && (Integer) obj < 10);
            }
        };

        System.out.println("*************************************FIND****************************************");

        System.out.println(Utils.find(list, pred));

        System.out.println("*************************************FILTER****************************************");

        Predicate pred2 = obj -> (obj.toString().length() == 1);

        for (Object o : Utils.filter(list2, pred2)) {
            System.out.println(o);
        }

        System.out.println("*************************************TRANSFORMER****************************************");

        Transformer trans = new Transformer() {
            @Override
            public Object trans(Object obj) {
                obj = obj.toString() + obj.toString();
                return obj;
            }
        };

        for (Object o : Utils.transform(list3, trans)) {
            System.out.println(o);
        }

        System.out.println("*************************************INTERSECT****************************************");

        List listA = new LinkedList();
        listA.add("A");
        listA.add("B");
        listA.add("C");
        listA.add(34);

        List listB = new LinkedList();
        listB.add("A");
        listB.add("Z");
        listB.add(34);
        listB.add("a");
        listA.add(34);

        Predicate2 predA = new Predicate2() {
            @Override
            public boolean apply(Object o1, Object o2) {
                return (o1.equals(o2));
            }
        };

        for (Object o : Utils.intersect(listA, listB, predA)) {
            System.out.println(o);
        }

        System.out.println("*************************************DIFFERENCE****************************************");

        for (Object o : Utils.difference(listA, listB, predA)) {
            System.out.println(o);
        }
    }
}