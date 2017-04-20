package simpleTasks;

import java.util.Scanner;

/*
Создайте программу, вычисляющую факториал натурального числа n, которое 
пользователь введёт с клавиатуры.
 */
public class Task17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int n = sc.nextInt();
        System.out.println("Факториал вашего числа - " + factorial(n));
    }

    public static int factorial(int n) {
        if (n <= 0) return 1;
        else
            return (n * factorial(n - 1));
    }
}
