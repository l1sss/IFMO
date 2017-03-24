package lesson5.Shapes;

/**
 * Created by l1s on 22.03.17.
 */
public class Rectangle extends Shape {
    protected int a;
    protected int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getPerimetr() {
        return (a + b) * 2;
    }

    public int gatArea() {
        return a * b;
    }
}
