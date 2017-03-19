package lesson3;

import java.util.Arrays;

/*
Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,

что первый и второй члены последовательности равны единицам, а каждый следующий —

сумме двух предыдущих.
 */
public class Task34 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] = f(i);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int f(int n) {
        if (n <= 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 1;
        else
            return f(n - 1) + f(n - 2);
    }
}
