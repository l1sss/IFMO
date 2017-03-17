import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/*
Проверьте, является ли введённое пользователем с клавиатуры натуральное число —

простым. Постарайтесь не выполнять лишних действий (например, после того, как вы нашли

хотя бы один нетривиальный делитель уже ясно, что число составное и проверку продолжать

не нужно). Также учтите, что наименьший делитель натурального числа n, если он вообще

имеется, обязательно располагается в отрезке [2; √n].
 */
public class Task19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите натуральное число:");
        int n = sc.nextInt();
        System.out.println(simpleOrNot(n));
    }

    public static String simpleOrNot(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return "Число составное";
        }
        return "Число простое!";
    }
}

