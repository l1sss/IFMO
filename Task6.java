import java.util.Scanner;
/*
Создать программу, проверяющую и сообщающую на экран, является ли целое число
записанное в переменную n, чётным либо нечётным.
*/
public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String s = n % 2 == 0 ? "even" : "odd";
        System.out.println(s);
    }
}
