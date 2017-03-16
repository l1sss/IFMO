import java.util.Scanner;
/*
В переменной n хранится натуральное трёхзначное число.
Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
*/
public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int n = sc.nextInt();
        sum(n);
    }

    public static void sum(int a) {
        int sum = 0;

        while (a != 0) {
            sum = sum + (a % 10);
            a /= 10;
        }
        System.out.println("Сумма цифр вашего числа = " + sum);
    }
}
