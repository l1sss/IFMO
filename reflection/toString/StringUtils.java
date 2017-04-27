package reflection.toString;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by l1s on 24.04.17.
 */
public final class StringUtils {

    private static final Set<Class<?>> READY;

    static {
        Set<Class<?>> types = new HashSet<>();
        types.add(String.class);
        types.add(Integer.class);
        //... Можно запихать также др. классы обёртки

        READY = Collections.unmodifiableSet(types);
    }

    public static String myToString(Object obj) {
        StringBuilder sb = new StringBuilder();

        try {
            myToString(obj, sb);
        } catch (ReflectiveOperationException e) {
            System.out.println("Some error " + e.getMessage());
        }

        return sb.toString();
    }

    public static void myToString(Object obj, StringBuilder sb) throws ReflectiveOperationException {
        Class<?> cl = obj.getClass();//получаем класс объекта

        sb.append(cl.getSimpleName()).append("{");

        //пробегаемся по всем полям объекта
        for (Field f : cl.getDeclaredFields()) {
            Exclude exclude = f.getAnnotation(Exclude.class);

            if (exclude != null) continue;

            f.setAccessible(true);

            sb.append(f.getType().getSimpleName())
                    .append(":")
                    .append(f.getName())
                    .append("=");

            Object o = f.get(obj);

            if (o == null) {
                sb.append("null");
            } else {
                if (o.getClass().isArray()) {
                    arrayToString(o, sb);
                } else if (READY.contains(o.getClass())) {
                    sb.append(o.toString());
                } else
                    myToString(o, sb);
            }
            sb.append(", ");
        }
        if (sb.toString().contains(", "))
            sb.replace(sb.length() - 2, sb.length(), "}");
        else
            sb.append("}");
    }

    private static void arrayToString(Object o, StringBuilder sb) {
        if (o.getClass().getComponentType() == int.class) {
            int[]  ints = (int[]) o;

            sb.append(Arrays.toString(ints));
        }
    }
}
