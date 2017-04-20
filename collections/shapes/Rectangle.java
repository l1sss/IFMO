package collections.shapes;

/**
 * Created by l1s on 22.03.17.
 */
public class Rectangle implements Shape {
    protected int a;
    protected int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getPerimetr() {
        return (a + b) * 2;
    }

    public int getArea() {
        return a * b;
    }
}
