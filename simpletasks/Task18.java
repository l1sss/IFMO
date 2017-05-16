package simpletasks;

import java.util.Scanner;

/*
Выведите на экран все положительные делители натурального числа, введённого
пользователем с клавиатуры.
 */
public class Task18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int n = sc.nextInt();
        System.out.println("Все положительные делители вашего числа: ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.println(i);
        }
    }
}
