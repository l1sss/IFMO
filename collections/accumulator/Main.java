package collections.accumulator;

import java.util.Arrays;

/**
 * Created by l1s on 24.03.17.
 */
public class Main {
    public static void main(String[] args) {
        double[] val = new double[7];
        Arrays.fill(val, 4);
        Operation[] op = {new Plus(), new Minus(), new Mult(), new Divide(), new Mod(), new Pow(), new SquareRoot()};

        Accumulator acc = new Accumulator(val, op);
        acc.calculate(1);
        acc.calculate(5);
        System.out.println(Arrays.toString(acc.getValue()));
    }
}
