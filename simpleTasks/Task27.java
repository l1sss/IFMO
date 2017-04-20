package simpleTasks;
/*
Сортировка пузырьком
 */
import java.util.Arrays;

public class Task27 {
    public static void main(String[] args) {
        int[] array = {8, 10, 5, 0, -4, 33, 8};

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
