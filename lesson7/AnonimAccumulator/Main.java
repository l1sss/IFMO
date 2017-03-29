package lesson7.AnonimAccumulator;

/**
 * Created by l1s on 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        AnonimAccumulator acc = new AnonimAccumulator(1, new Operation() {
            @Override
            public double apply(double a, int b) {
                return a + b;
            }
        });

        acc.calculate(1);
        System.out.println(acc.getValue());

        AnonimAccumulator acc2 = new AnonimAccumulator(1, new Operation() {
            @Override
            public double apply(double a, int b) {
                int factorial = 1;
                for (int i = (int)a + b; i > 0; i--) {
                    factorial *= i;
                }
                return factorial;
            }
        });

        acc2.calculate(4);
        System.out.println(acc2.getValue());
    }
}
