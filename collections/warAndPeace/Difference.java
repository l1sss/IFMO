package collections.multiThreadsWarAndPeace;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by l1s on 08.04.17.
 */
//РАЗНИЦА
public class Difference {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("Мама");
        set.add("мыла");
        set.add("раму");

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("Папа");
        set2.add("мыл");
        set2.add("раму");

        set2.removeAll(set);//удаляем из второго множества все пересечения с первым множеством, оставляем разницу

        System.out.println(set2);
    }
}
