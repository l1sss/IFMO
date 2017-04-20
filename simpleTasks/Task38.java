package simpleTasks;

import java.util.Scanner;

/*
Пользователь должен указать с клавиатуры чётное положительное число, а программа
должна создать массив указанного размера из случайных целых чисел из [-5;5] и вывести его
на экран в строку. После этого программа должна определить и сообщить пользователю о
том, сумма модулей какой половины массива больше: левой или правой, либо сообщить, что
эти суммы модулей равны. Если пользователь введёт неподходящее число, то программа
должна требовать повторного ввода до тех пор, пока не будет указано корректное значение.
 */
public class Task38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {
            System.out.println("Введите чётное положительное число: ");
            n = sc.nextInt();
            if (n > 0 && n % 2 == 0) break;
        }

        int[] arr = new int[n];
        int lsum = 0;
        int rsum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 11) - 5;
            System.out.print(arr[i] + " ");
            if (i <= arr.length / 2 - 1) lsum += Math.abs(arr[i]);
            else if (i > arr.length / 2 - 1) rsum += Math.abs(arr[i]);
        }

        if (lsum > rsum) System.out.println("\nСумма модулей левой половины массива больше");
        else if (rsum > lsum) System.out.println("\nCумма модулей правой половины массива больше");
        else System.out.println("\nCумма модулей левой половины массива = сумме модулей правой половины массива");
    }
}
