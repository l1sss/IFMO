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

        Predicate pred = new Returner();
        System.out.println(Utils.find(list, pred));
    }
}

