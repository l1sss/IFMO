package collections.shapes;

/**
 * Created by l1s on 22.03.17.
 */
public class Triangle implements Shape {
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        if (a + b > c && a + c > b && b + c > a) {
            this.a = a;
            this.b = b;
            this.c = c;
        } else System.out.println("Такой треугольник не возможен!!!");
    }

    public int getPerimetr() {
        return a + b + c;
    }

    public int getArea() {
        return (int)(Math.sqrt(3) / 4 * (a * a));
    }

}
