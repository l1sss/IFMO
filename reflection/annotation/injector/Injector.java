package reflection.annotation.injector;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xmitya on 07.12.16.
 */
public class Injector {
    private Map<Class, Object> singletons = new HashMap<>();

    private static final Injector INSTANCE = new Injector();

    public static Injector getInstance() {
        return INSTANCE;
    }

    public void inject(Object obj) {
        if (obj == null)
            return;

        Class<?> cls = obj.getClass();

        for (Field field : cls.getDeclaredFields()) {
            Dependency an = field.getAnnotation(Dependency.class);
            if (an != null) {
                Class<?> type = an.value();
                boolean isNew = an.isNew();

                Object dep = getDependency(type, isNew);

                setDependency(field, obj, dep);
            }
        }
    }

    private Object getDependency(Class<?> type, boolean isNew) {
        Object res = singletons.get(type);

        if (!isNew && res != null)
            return res;

        try {
            res = type.newInstance();

            singletons.putIfAbsent(type, res);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return res;
    }

    private void setDependency(Field fld, Object target, Object dependency) {
        try {
            fld.setAccessible(true);

            fld.set(target, dependency);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
