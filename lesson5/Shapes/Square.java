package lesson5.Shapes;

/**
 * Created by l1s on 22.03.17.
 */
public class Square extends Rectangle {

    public Square(int a, int b) {
        super(a, b);
        if(a != b) System.out.println("Это не квадрат!");
    }
}
