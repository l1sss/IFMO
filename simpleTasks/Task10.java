package simpleTasks;

import java.util.Random;
/*
Создать программу, выводящую на экран случайно сгенерированное трёхзначное
натуральное число и его наибольшую цифру.Примеры работы программы:
В числе 208 наибольшая цифра 8В числе 774 наибольшая цифра 7В числе 613 наибольшая
цифра 6
 */
public class Task10 {
    public static void main(String[] args) {
        Random rn = new Random();
        int a = rn.nextInt(899) + 100;
        System.out.println("Наше число: " + a);
        int max = 0;

        while(a != 0) {
            if (a % 10 > max) max = a % 10;
            a /= 10;
        }
        System.out.println(max);
    }
}
