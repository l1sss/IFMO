package lesson7.Utils;

/**
 * Created by l1s on 28.03.17.
 */
public class Returner implements Predicate{
    @Override
    public boolean apply(Object obj) {
        return ((Integer)obj > 1 && (Integer)obj < 10);
    }
}
