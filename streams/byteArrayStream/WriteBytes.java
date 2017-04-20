package streams.byteArrayStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by l1s on 15.04.17.
 */
public class WriteBytes {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "ByteArrayOutputStream testing";
        byte[] buffer = text.getBytes();

        try {
            baos.write(buffer);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        //превращаем массив байтов в строку
        System.out.println(baos.toString());

        //получаем массив байтов
        byte[] array = baos.toByteArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print((char)array[i]);
        }
    }
}
