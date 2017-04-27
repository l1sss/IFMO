package reflection.toString;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by xmitya on 26.04.17.
 */
public final class mityaStringUtils {

    private static final Set<Class<?>> READY;

    static {
        Set<Class<?>> types = new HashSet<>();

        types.add(String.class);
        types.add(Integer.class);
        types.add(int.class);

        READY = Collections.unmodifiableSet(types);
    }

    private mityaStringUtils() {}

    public static String toString(Object obj) {
        StringBuilder sb = new StringBuilder();

        try {
            toString(obj, sb);
        } catch (ReflectiveOperationException e) {
            System.err.println("Some error: " + e.getMessage());
        }

        return sb.toString();
    }

    public static void toString(Object obj, StringBuilder sb) throws ReflectiveOperationException {
        Class<?> cls = obj.getClass();

        sb.append("{").append(cls.getSimpleName()).append(": ");

        // Лучше использовать массив =)
        for (Iterator<Field> iterator = Arrays.asList(cls.getDeclaredFields()).iterator(); iterator.hasNext(); ) {
            Field field = iterator.next();
            field.setAccessible(true);
            sb.append(field.getName()).append('=');

            Object o = field.get(obj);

            if (o == null)
                sb.append("null");
            else {
                if (o.getClass().isArray()) {
                    sb.append('"');
                    arrayToString(o, sb);
                    sb.append('"');
                } else if (READY.contains(o.getClass()))
                    sb.append('"').append(o.toString()).append('"');
                else
                    toString(o, sb);
            }

            if (iterator.hasNext())
                sb.append(", ");
        }

        sb.append("}");
    }

    private static void arrayToString(Object o, StringBuilder sb) {
        if (o.getClass().getComponentType() == int.class) {
            int[] ints = (int[]) o;

            sb.append(Arrays.toString(ints));
        }
    }
}
