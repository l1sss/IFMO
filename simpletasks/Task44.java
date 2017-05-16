package simpletasks;
/*
Создать двумерный массив из 6 строк по 7 столбцов в каждой из случайных целых чисел
из отрезка [0;9]. Вывести массив на экран. Преобразовать массив таким образом, чтобы на
первом месте в каждой строке стоял её наибольший элемент. При этом изменять состав
массива нельзя, а можно только переставлять элементы в рамках одной строки. Порядок
остальных элементов строки не важен (т.е. можно соврешить только одну перестановку, а
можно отсортировать по убыванию каждую строку). Вывести преобразованный массив на
экран.
 */
public class Task44 {
    public static void main(String[] args) {
        int[][] arr2d = new int[6][7];
        for (int i = 0; i < arr2d.length; i++) {
            for (int j = 0; j < arr2d[i].length; j++) {
                arr2d[i][j] = (int)(Math.random() * 10);
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < arr2d.length; i++) {
            for (int j = arr2d[i].length - 1; j > 0; j--) {
                for (int k = 0; k < j; k++) {                   //3 for'a - зло...
                    if (arr2d[i][k] < arr2d[i][k + 1]) {
                        int tmp = arr2d[i][k];
                        arr2d[i][k] = arr2d[i][k + 1];
                        arr2d[i][k + 1] = tmp;
                    }
                }
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
