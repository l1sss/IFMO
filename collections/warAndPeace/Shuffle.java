package collections.warAndPeace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by l1s on 07.04.17.
 */
//ПЕРЕМЕШИВАЕМ ЛИСТ ВРУЧНУЮ
public class Shuffle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        System.out.println(shuffle(list));
    }

    public static List<Integer> shuffle(List<Integer> list) {
        Random r = new Random();

        for (int i = 0; i < list.size(); i++) {
            int index = r.nextInt(list.size());

            int tmp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, tmp);
        }
        return list;
    }
}
