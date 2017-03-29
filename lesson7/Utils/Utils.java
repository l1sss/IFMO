package lesson7.Utils;


import lesson6.ArrayList.ArrayList;
import lesson6.ArrayList.List;

/**
 * Created by l1s on 28.03.17.
 */
public class Utils {
    public static Object find(List list, Predicate pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.apply(list.get(i))) return list.get(i);
        }
        return null;
    }

    public static List filter(List list, Predicate pred) {
        List list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (pred.apply(list.get(i))) list2.add(list.get(i));
        }
        return list2;
    }

    public static List transform(List list, Transformer trans) {
        List list2 = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            list2.add(trans.trans(list.get(i)));
        }
        return list2;
    }
}
