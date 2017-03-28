package lesson7.Utils;

import lesson6.ArrayList.ArrayList;

/**
 * Created by l1s on 28.03.17.
 */
public class Utils {
    public static Object find(ArrayList list, Predicate pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.apply(list.get(i))) return list.get(i);
        }
        return null;
    }
}
