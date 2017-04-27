package reflection.toString;

import collections.arrayList.ArrayList;

/**
 * Created by l1s on 24.04.17.
 */
public class B extends A {
    private int i;
    private int[] n = {1, 2};
    private ArrayList arr;
    private final String str2 = "final";
    @Exclude
    private String exclude = "Exclude";
    private A a = new A();
}

