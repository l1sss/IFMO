package simpleTasks;

import java.util.Scanner;
/*
Напишите программу, которая выводит true, если число четное и false, если нет.
Попробуйте сделать при помощи битовых операций.
*/
public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int n = sc.nextInt();
        System.out.println("Число чётное и это - " + ((n&1) == 0));
    }
}
