package lesson13.ByteArrayStream;

import java.io.ByteArrayInputStream;
import java.util.Random;

/**
 * Created by l1s on 16.04.17.
 */
public class ByteGeneratorStream {
    public static void main(String[] args) {
        byte[] arr = new byte[100];

        Random r = new Random();
        r.nextBytes(arr);

        ByteArrayInputStream in = new ByteArrayInputStream(arr);

        int b;
        while ((b = in.read()) > 0)
            System.out.println((byte)b);
    }
}