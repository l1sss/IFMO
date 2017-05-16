package simpletasks;

import java.util.Arrays;

/*
 Программа должна создать массив из 12 случайных целых чисел из отрезка [-10;10]
таким образом, чтобы отрицательных и положительных элементов там было поровну и не
было нулей. При этом порядок следования элементов должен быть случаен (т.
е. не подходит
вариант, когда в массиве постоянно выпадает сначала 6 положительных, а потом 6
отрицательных чисел или же когда элементы постоянно чередуются через один и пр.).
Вывести полученный массив на экран.
 */
public class Task39 {
    public static void main(String[] args) {
        int[] arr = new int[12];
        int negative = 0;
        int positive = 0;

        while (true) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int)(Math.random() * 21) -10;

                if (arr[i] == 0) --i;
                else if (arr[i] < 0) negative++;
                else if (arr[i] > 0) positive++;
            }
            if (negative == positive) break;
            else {
                negative = 0;
                positive = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("negative numbers = " + negative);
        System.out.println("positive numbers = " + positive);
    }
}
