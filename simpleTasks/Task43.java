package simpleTasks;
/*
Cоздать двумерный массив из 7 строк по 4 столбца в каждой из случайных целых чисел из
отрезка [-5;5]. Вывести массив на экран. Определить и вывести на экран индекс строки с
наибольшим по модулю произведением элементов. Если таких строк несколько, то вывести
индекс первой встретившейся из них.
 */
public class Task43 {
    public static void main(String[] args) {
        int[][] arr2d = new int[7][4];
        int maxComposition = 1;
        int index = 0;

        for (int i = 0; i < arr2d.length; i++) {
            int composition = 1;
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = (int)(Math.random() * 11) -5;
                System.out.print(arr2d[i][j] + " ");

                composition *= Math.abs(arr2d[i][j]);
                if (composition > maxComposition) {
                    maxComposition = composition;
                    index = i;
                }
            }
            System.out.println();
        }
        System.out.println("Максимальное произведение модулей = " + maxComposition + ", обнаружено в строке " + index);
    }
}
