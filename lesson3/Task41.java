package lesson3;
/*
Создать двумерный массив из 8 строк по 5 столбцов в каждой из случайных целых чисел
из отрезка [10;99]. Вывести массив на экран.
 */
public class Task41 {
    public static void main(String[] args) {
        int[][] arr2d = new int[8][5];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                arr2d[i][j] = (int)(Math.random() * 90) + 10;
            }
        }

        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
