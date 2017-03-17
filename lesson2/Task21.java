package lesson2;

import java.util.Scanner;

/*
Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех
его цифр (заранее не известно сколько цифр будет в числе).
 */
public class Task21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int n = sc.nextInt();
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("Сумма цифр вашего числа = " + sum);
    }
}
