package lesson3;

import java.util.Random;

/*
Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
отдельной строке.
 */
public class Task30 {
    public static void main(String[] args) {
        Random r = new Random();
        int count = 0;
        int[] arr = new int[15];
        for (int i = 0; i < 15; i++) {
            arr[i] = r.nextInt(10);
            System.out.print(arr[i] + " ");
            if (arr[i] != 0 && arr[i] % 2 == 0) count++;
        }

        System.out.println("\nЧётных элементов в массиве " + count);
    }
}
