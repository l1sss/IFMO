package simpleTasks;

import java.util.Random;

/*
Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
экран на отдельной строке.
 */
public class Task31 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10) + 1;
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) arr[i] = 0;
            System.out.print(arr[i] + " ");
        }
    }
}
