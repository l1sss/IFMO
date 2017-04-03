package lesson7.Utils;

import lesson4.linkedList.LinkedList;
import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

import java.io.File;

/**
 * Created by l1s on 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*************************************FIND****************************************");

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(5);
        list.add(10);

        Predicate pred = new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return ((Integer) obj == 7);
            }
        };

        System.out.println(Utils.find(list, pred));

        System.out.println("*************************************FILTER****************************************");

        ArrayList list2 = new ArrayList();
        list2.add("Aa");
        list2.add("a");
        list2.add("d3");
        list2.add("1");

        Predicate pred2 = obj -> (obj.toString().length() == 1);

        for (Object o : Utils.filter(list2, pred2)) {
            System.out.println(o);
        }

        System.out.println("*************************************TRANSFORMER****************************************");

        ArrayList list3 = new ArrayList();
        list3.add(1);
        list3.add(1234);
        list3.add(3);

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
        listA.add("a");
        listA.add("b");
        listA.add("c");
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);

        List listB = new LinkedList();
        listB.add("D");
        listB.add("B");
        listB.add("E");
        listB.add(5);
        listB.add(6);
        listB.add(-1);
        listB.add(7);

        Predicate2 predA = new Predicate2() {
            @Override
            public boolean apply(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String)
                    return ((String) o1).equalsIgnoreCase((String) o2);
                else if (o1 instanceof Integer && o2 instanceof Integer)
                    return Math.abs((Integer)o1) == Math.abs((Integer)o2);
                else
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

        System.out.println("*************************************FILES****************************************");

        //находим файл болший 21 байта
        Predicate predF1 = new Predicate() {
            @Override
            public boolean apply(Object obj) {
                return ((File)obj).length() > 21;
            }
        };

        //сравниваем файлы по имени
        Predicate2 predF2 = new Predicate2() {
            @Override
            public boolean apply(Object o1, Object o2) {
                return ((File)o1).getName().equals(((File)o2).getName());
            }
        };

        File dir1 = new File("/home/l1s/dir1");
        File dir2 = new File("/home/l1s/dir2");

        List files1 = Utils.toList(dir1.listFiles()); //все файлы из директории 1
        List files2 = Utils.toList(dir2.listFiles()); //все файлы из директории 2

        System.out.println("find file > 21b " + Utils.find(files2, predF1));

        List dup = Utils.intersect(files1, files2, predF2);
        List dif = Utils.difference(files1, files2, predF2);

        for (Object o : dup) {
            System.out.println("intersect " + o);
        }

        for (Object o : dif) {
            System.out.println("difference " + o);
        }
    }
}