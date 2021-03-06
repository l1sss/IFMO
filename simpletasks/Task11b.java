package simpletasks;

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
public class Task11b {
    public static void main(String[] args) {
        int a = 7;
        int b = 0;
        int c = -5;
        int tmp;

        if (a > b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        if (a > c) {
            tmp = a;
            a = c;
            c = tmp;
        }
        if (b > c) {
            tmp = b;
            b = c;
            c = tmp;
        }
        System.out.print(a + ", " + b + ", " + c);
    }
}
