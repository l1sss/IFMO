package lesson3;
/*
Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 ... 7 5 3 1)
 */
public class Task29 {
    public static void main(String[] args) {
        int[] arr = new int[50];
        int n = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
            n += 2;
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        for (int i = arr.length - 1; i >= 0; i--){
            System.out.print(arr[i] + " ");
        }
    }
}
