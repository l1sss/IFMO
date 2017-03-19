package lesson3;

import java.util.Arrays;
import java.util.Random;

/*
Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в

строку. Определить и вывести на экран сообщение о том, является ли массив строго

возрастающей последовательностью.
 */
public class Task33 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(90) + 10;
        }

        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                System.out.println("Массив не является строго возрастающим");
                break;
            } else if (i == arr.length - 1)
                System.out.println("Массив является строго возрастающим!");
        }
    }
}
