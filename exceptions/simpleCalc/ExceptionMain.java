package exceptions.simpleCalc;

/**
 * Created by xmitya on 21.10.16.
 */
public class ExceptionMain {
    public static void main(String[] args) {
        try {
            sum(1, null);
        }
        catch (RuntimeException e) {
            System.out.println("Exception is thrown, but we're OK: " + e.getClass());
        }

        System.out.println("All fine!");
    }

    private static int sum(Integer i1, Integer i2) {
        checkSumArgument(i1, "Wrong first argument: ");
        checkSumArgument(i2, "Wrong second argument: ");

        return i1 + i2;
    }

    private static void checkSumArgument(Integer i1, String msg) {
        if (i1 == null || i1 < 0)
            throw new IllegalArgumentException(msg + i1);
    }
}
