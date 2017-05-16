package simpletasks;

import java.util.Scanner;
/*
В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую на экран результат деления q на w с остатком.
Пример вывода программы (для случая, когда в q хранится 21, а в w хранится 8):
21 / 8 = 2 и 5 в остатке
*/
public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое делимое:");
        int q = sc.nextInt();
        System.out.println("Введите целый делитель:");
        int w = sc.nextInt();

        division(q, w);
    }

    public static void division(int a, int b) {
        System.out.println(a + "/" + b + " = " + a/b + " и " + a%b + " в остатке");
    }
}
