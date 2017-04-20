package simpleTasks;

/*
 Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
16 32 64 128 ....
 */
public class Task16 {
    public static void main(String[] args) {
        int n = 1;
        for (int i = 0; i < 20 ; i++) {
            n *= 2;
            System.out.println(n);
        }
    }
}
