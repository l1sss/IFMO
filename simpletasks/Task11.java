package simpletasks;

import java.util.Arrays;
/*
В три переменные a, b и c явно записаны программистом три целых попарно неравных
между собой числа. Создать программу, которая переставит числа в переменных таким
образом, чтобы при выводе на экран последовательность a, b и c оказалась строго
возрастающей.
Числа в переменных a, b и c: 3, 9, -1
Возрастающая последовательность: -1, 3, 9
Числа в переменных a, b и c: 2, 4, 3
Возрастающая последовательность: 2, 3, 4
Числа в переменных a, b и c: 7, 0, -5
Возрастающая последовательность: -5, 0, 7
*/
public class Task11 {
    public static void main(String[] args) {
        int a = 7;
        int b = 0;
        int c = -5;

        int[] arr = {a, b, c};
        Arrays.sort(arr);

        a = arr[0];
        b = arr[1];
        c = arr[2];

        System.out.print(a + ", " + b + ", " + c);
    }
}
