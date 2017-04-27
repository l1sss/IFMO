package reflection.example;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by l1s on 27.04.17.
 */

//пример того, как можно достучаться до приватно финального поля и модифицировать его значение
public class ReflectionExample {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Test t = new Test();

        System.out.println(Arrays.toString(t.getA()));

        Class cl = t.getClass();

        Field f = cl.getDeclaredField("a");

        f.setAccessible(true); //разрешаем себе доступ
        //Object o = new int[]{1, 2};
        f.set(t, new int[]{1, 2}); //меняем финалное поле, как ни странно...

        System.out.println(Arrays.toString(t.getA()));
    }
}

class Test {
    private final int[] a = {0, 0};

    public int[] getA() {
        return a;
    }
}