package simpleTasks;

/*
Создайте программу, выводящую на экран все четырёхзначные числа последовательности
1000 1003 1006 1009 1012 1015 ....
 */
public class Task13 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1000; i < 10_000; i += 3) {
            System.out.println(i);
            Thread.sleep(1000);//(-_-)Zzzz...
        }
    }
}
