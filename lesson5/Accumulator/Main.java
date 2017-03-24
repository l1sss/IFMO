package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Accumulator acc2 = new Accumulator(new Mult());
        System.out.println(acc2.getValue());
        acc2.setValue(3);
        System.out.println(acc2.getValue());
        acc2.calculate(2);
        System.out.println(acc2.getValue());
    }
}
