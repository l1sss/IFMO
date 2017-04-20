package simpleTasks;

import java.util.ArrayList;
import java.util.Scanner;

/*
Пользователь вводит с клавиатуры натуральное число большее 3, которое сохраняется в
переменную n. Если пользователь ввёл не подходящее число, то программа должна просить
пользователя повторить ввод. Создать массив из n случайных целых чисел из отрезка [0;n] и
вывести его на экран. Создать второй массив только из чётных элементов первого массива,
если они там есть, и вывести его на экран.
 */
public class Task40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.println("Введите натуральное число > 3:");
            n = sc.nextInt();
            if (n > 3) break;
        }

        int[] arr1 = new int[n];
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int)(Math.random() * n + 1);
            System.out.print(arr1[i] + " ");
            if (arr1[i] % 2 == 0) arr2.add(arr1[i]);
        }

        System.out.println();
        for (Integer i : arr2) {
            System.out.print(i + " ");
        }
    }
}
