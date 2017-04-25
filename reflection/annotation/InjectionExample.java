package reflection.annotation;

import reflection.annotation.injector.Dependency;
import reflection.annotation.injector.Injector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xmitya on 07.12.16.
 */
public class InjectionExample {

    public static void main(String[] args) {
        Target target = new Target();

        System.out.println(target);

        Injector.getInstance().inject(target);

        System.out.println(target);

        System.out.println(target.bean1 == target.bean2);
        System.out.println(target.bean1 == target.bean12);
        System.out.println(target.bean2 == target.bean12);
    }

    public static class Bean1 {
        private final int random;

        public Bean1() {
            random = new Random().nextInt();
        }

        @Override
        public String toString() {
            return "Bean1{" +
                    "random=" + random +
                    '}';
        }
    }

    public static class Target {
        @Dependency(Bean1.class)
        private Bean1 bean1;
        @Dependency(Bean1.class)
        private Bean1 bean2;
        @Dependency(value = Bean1.class, isNew = true)
        private Bean1 bean12;

        private Bean1 bean33;

        @Dependency(ArrayList.class)
        private List<?> list;

        @Override
        public String toString() {
            return "Target{" +
                    "bean1=" + bean1 +
                    ", bean2=" + bean2 +
                    ", bean12=" + bean12 +
                    ", bean33=" + bean33 +
                    ", list=" + list +
                    " " + (list == null ? null : list.getClass()) +
                    '}';
        }
    }
}
