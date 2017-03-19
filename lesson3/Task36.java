package lesson3;

import java.util.Arrays;
import java.util.Random;

/*
Создайте два массива из 10 целых случайных чисел из отрезка [1;9] и третий массив из 10
действительных чисел. Каждый элемент с i-ым индексом третьего массива должен равняться
отношению элемента из первого массива с i-ым индексом к элементу из второго массива с i-
ым индексом. Вывести все три массива на экран (каждый на отдельной строке), затем
вывести количество целых элементов в третьем массиве.
 */
public class Task36 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextInt(9) + 1;
        }
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextInt(9) + 1;
        }
        System.out.println(Arrays.toString(arr2));

        double[] arr3 = new double[10];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (double)(arr1[i])/arr2[i];
        }
        System.out.println(Arrays.toString(arr3) + "\n");

        for (double d : arr3) {
            if (d % 1 == 0) System.out.print((int)d + " ");
        }
        System.out.println("- целые элементы 3-го массива");
    }
}
