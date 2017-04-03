package lesson7.Utils;

import lesson4.linkedList.LinkedList;
import lesson4.linkedList.List;
import lesson6.ArrayList.ArrayList;

/**
 * Created by l1s on 28.03.17.
 */

//УТИЛИТАРНЫЙ КЛАСС
public class Utils {

    //поиск элемента, соответствующего условию
    public static Object find(List list, Predicate pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.apply(list.get(i))) return list.get(i);
        }
        return null;
    }

    //отсев элементов по условию
    public static List filter(List list, Predicate pred) {
        List list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (pred.apply(list.get(i))) list2.add(list.get(i));
        }
        return list2;
    }

    //трансформация элементов
    public static List transform(List list, Transformer trans) {
        List list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            list2.add(trans.trans(list.get(i)));
        }
        return list2;
    }

    //из массива в лист
    public static List toList(Object[] arr) {
        List list = new LinkedList();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    //возврат пересечения двух листов
    public static List intersect(List list1, List list2, Predicate2 pred) {
        List rList = new ArrayList();

        if (pred != null) {
            for (Object o : list1) {
                for (int i = 0; i < list2.size(); i++) {
                    if (pred.apply(o, list2.get(i))) rList.add(o);
                }
            }
        }else {
            for (Object o : list1) {
                for (int i = 0; i < list2.size(); i++) {
                    if (o.equals(list2.get(i))) rList.add(o);
                }
            }
        }
        return rList;
    }

    //возврат списка, который содержит все элементы из list1, кроме тех, которые есть в list2
    public static List difference(List list1, List list2, Predicate2 pred) {
        List rList = new LinkedList();

        for(Object o : list1) {
            rList.add(o);
        }

        if (pred != null) {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    if (pred.apply(list1.get(i), list2.get(j))) rList.remove(list1.get(i));
                }
            }
        }else {
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list2.size(); j++) {
                    if (list1.get(i).equals(list2.get(j))) rList.remove(list1.get(i));
                }
            }
        }
        return rList;
    }
}