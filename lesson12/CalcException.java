package lesson12;

/**
 * Created by l1s on 14.04.17.
 */
public class CalcException extends Exception {
    public CalcException(String message) {
        super(message);
    }

    public CalcException(String message, Throwable cause) {
        super(message, cause);
    }
}
