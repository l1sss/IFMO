package simpleTasks;

import java.util.Arrays;
import java.util.Random;

/*
Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
элемент является в этом массиве максимальным и сообщите индекс его последнего
вхождения в массив.
 */
public class Task35 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] arr = new int[12];
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(31) - 15;
            if (arr[i] >= max) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(Arrays.toString(arr) + "\n");
        System.out.println("Максимальный элемент в массиве = " + max + ", его последний индекс вхождения " + index);
    }
}
