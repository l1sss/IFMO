package reflection.toString;

import java.lang.reflect.Field;

/**
 * Created by l1s on 24.04.17.
 */
public class Utils {

    public static void main(String[] args) {
        B b = new B();

        System.out.println(toString(b));
    }

    public static String toString(Object o) {
        try {
            StringBuilder sb = new StringBuilder();

            Class<?> cl = o.getClass();//получаем класс объекта

            sb.append(cl.getSimpleName())
                    .append("{");

            Field[] fields = cl.getDeclaredFields(); //получаем поля класса

            for (Field f : fields) {
                    f.setAccessible(true);

                    sb.append(f.getType().getSimpleName())
                            .append(":")
                            .append(f.getName())
                            .append("=")
                            .append(f.get(o))
                            .append(", ");
            }

            sb.replace(sb.length() - 2, sb.length(), "}");

            return sb.toString();
        }
        catch (Exception ex) {

            return ex.getMessage();
        }
    }
}