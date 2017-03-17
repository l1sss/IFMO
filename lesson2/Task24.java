package lesson2;

/*
Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько 
раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация 
для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51).
 */
public class Task24 {
    public static void main(String[] args) {
        int count = 0;
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 59; m++) {
                if (h / 10 % 10 == m % 10 & h % 10 == m / 10 % 10)
                {
                    count ++;
//                    System.out.println(count + "    " + h + ":" + m);
                    System.out.printf("%02d -> %02d:%02d\n", count, h, m);
                }
            }
        }
        System.out.println("Число симметричных комбинаций = " + count);
    }
}
