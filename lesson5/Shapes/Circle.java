package lesson5.Shapes.Shapes;


/**
 * Created by l1s on 22.03.17.
 */
public class Circle extends Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    public int getPerimetr() {
        return (int)(2 * Math.PI * r);
    }

    public int getAreal() {
        return (int)(Math.PI * (r * r));
    }
}
