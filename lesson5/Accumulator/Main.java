package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public class Main {
    public static void main(String[] args) {
        Accumulator acc2 = new Accumulator(new Pow(), 4);
        acc2.calculate(3);
        System.out.println(acc2.getValue());
    }
}
