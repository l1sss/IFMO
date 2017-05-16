package simpletasks;

import java.util.Random;

/*
Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите

массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов

каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо

сообщите, что их средние арифметические равны).
 */
public class Task32 {
    public static void main(String[] args) {
        Random r = new Random();

        int[] arr1 = new int[5];
        int sum1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = r.nextInt(6);
            sum1 += arr1[i];
            System.out.print(arr1[i] + " ");
        }
        double x1 = (double)(sum1) / arr1.length;

        System.out.println("\n");

        int[] arr2 = new int[5];
        int sum2 = 0;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = r.nextInt(6);
            sum2 += arr2[i];
            System.out.print(arr2[i] + " ");
        }
        double x2 = (double)(sum2) / arr2.length;

        System.out.println("\n");

        if (x1 > x2) System.out.println("Среднее арифметическое 1-го массива " + x1);
        else if (x1 < x2) System.out.println("Среднее арифметическое 2-го массива " + x2);
        else System.out.println(x1 + " == " + x2 + " Средние арифметические равны!");
    }
}
