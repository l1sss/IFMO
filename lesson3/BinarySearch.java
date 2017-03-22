package lesson3;

import java.util.Arrays;

/*
Бинарный поиск.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 10, 8, 35, 7};
        int x = 35; //искомое значение
        Arrays.sort(arr);
        if (bSearch(x, arr) == -1) System.out.println("Значение не найдено");
        else
            System.out.println("Элемент " + x + " находится в ячейке с индексом " + bSearch(x, arr));
    }

    public static int bSearch(int x, int[] array) {
        int l = 0; //левая граница массива
        int r = array.length - 1; //правая граница массива

        while (l <= r) {
        int m = (l + r) / 2;
        if (array[m] == x) return m; //бинго!
        else if (array[m] < x) l = m + 1; //если m меньше х, то мы сдвигаем левую границу
        else
            r = m - 1; //если больше, то сдвигаем правую
        }
        return -1; //если ничего не нашли
    }
}
