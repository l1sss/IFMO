package simpletasks;

/*
Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив на
экран в строку. Определите какой элемент встречается в массиве чаще всего и выведите об
этом сообщение на экран. Если два каких-то элемента встречаются одинаковое количество
раз, то не выводите ничего.
 */
public class Task37 {
    public static void main(String[] args) {
        int[] arr = new int[11];
        int am = 0, a0 = 0, a1 = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 3) - 1;
            System.out.print(arr[i] + " ");

            if (arr[i] < 0) am++;
            else if (arr[i] == 0) a0++;
            else a1++;

            if (i == arr.length - 1) {
                if (am > a0 && am > a1) System.out.println("\nКоличество вхождений элемента [-1] в массив = " + am);
                else if (a0 > am && a0 > a1) System.out.println("\nКоличество вхождений элемента [0] в массив = " + a0);
                else if (a1 > am && a1 > a0) System.out.println("\nКоличество вхождений элемента [1] в массив = " + a1);
            }
        }
    }
}
