package lesson3;
/*
Создать двумерный массив из 5 строк по 8 столбцов в каждой из случайных целых чисел
из отрезка [-99;99]. Вывести массив на экран. После на отдельной строке вывести на экран
значение максимального элемента этого массива (его индекс не имеет значения).
 */
public class Task42 {
    public static void main(String[] args) {
        int[][] arr2d = new int[5][8];
        int max = arr2d[0][0];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = (int)(Math.random() * 199) -99;
                if (arr2d[i][j] > max) max = arr2d[i][j];
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nМаксимальное значение в массиве = " + max);
    }
}
