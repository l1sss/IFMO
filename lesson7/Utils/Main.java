package lesson7.Utils;

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
        list3.add(12);
        list3.add(3);

        Predicate pred = new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return ((Integer) obj > 1 && (Integer) obj < 10);
            }
        };

        System.out.println(Utils.find(list, pred) + "\n");

        Predicate pred2 = new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return (obj.toString().length() == 1);
            }
        };

        for (Object o : Utils.filter(list2, pred2)) {
            System.out.println(o);
        }

        System.out.println();

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
    }
}