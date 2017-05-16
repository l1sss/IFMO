package simpletasks;
/*
Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран

сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один

элемент от другого началом новой строки). Перед созданием массива подумайте, какого он

будет размера.2 4 6 ... 18 20246...20
 */
public class Task28 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += 2;
            arr[i] = n;
            System.out.print(arr[i] + " ");
        }

        System.out.println("\n");

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
