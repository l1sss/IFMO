package lesson2;

/*
Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что

первый и второй члены последовательности равны единицам, а каждый следующий — сумме

двух предыдущих.
 */
public class Task20 {
    public static void main(String[] args) {
        int n = 11;
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo(i));
        }
    }

    public static int fibo(int i) {
        if (i <= 0) return 0;
        else if (i == 1) return 1;
        else if (i == 2) return 1;
        else
            return fibo(i - 1) + fibo (i - 2);
    }
}
