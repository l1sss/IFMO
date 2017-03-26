package lesson5.Accumulator;

/**
 * Created by l1s on 24.03.17.
 */
public interface Operation {
    public double apply(double a, int b);

    public double apply(double a, long b);

    public double apply(double a, double b);
}
