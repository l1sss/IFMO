package lesson2;

import java.util.Scanner;
/*
В три переменные a, b и c записаны три вещественных числа.  Создать программу, которая
будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
либо сообщать, что корней нет.
 */
public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double d = b * b - 4 * a * c;
        System.out.println("D = " +d);

        if (d > 0) {
            double x1, x2;
            x1 = b * -1 + Math.sqrt(d);
            x2 = b * -1 - Math.sqrt(d);
            System.out.println("x1 = " + x1 + "\nx2 = " + x2);
        }
        else if (d == 0) {
            double x = (b * -1)/2 * a;
            System.out.println("x = " + x);
        }
        else
            System.out.println("Уравнение не имеет действительных корней");
    }
}
