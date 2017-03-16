import java.util.InputMismatchException;
import java.util.Scanner;
/*
В переменной n хранится вещественное число с ненулевой дробной частью.
Создайте программу, округляющую число n до ближайшего целого и выводящую результат на экран.
*/
public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите дробное число:");

        try {
            double n = sc.nextDouble();
            System.out.println("Округляем до " + Math.round(n));
        }
        catch (InputMismatchException e) {
            System.out.println("Пожалуйста введите число через запятую!");
        }
    }
}
