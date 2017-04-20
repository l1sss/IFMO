package streams.byteArrayStream;

import java.io.*;

/**
 * Created by l1s on 15.04.17.
 */
public class ReadBytes {
    public static void main(String[] args) {
        //Считываем массив байтов и выводим его на экран
        byte[] array1 = {9, 1, 1};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);

        int b;
        while ((b = byteStream1.read()) != -1)
            System.out.print(b);

        System.out.println("\n");

        String text = "Byte array read";
        byte[] array2 = text.getBytes();
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2);

        int c;
        while ((c = byteStream2.read()) != -1)
            System.out.print((char)c);

        System.out.println("\n\nСчитываем файл в строку, по 4 байта:");
        //Считываем файл в строку
        try (InputStream in = new FileInputStream("/home/l1s/test/words.txt");
        OutputStream fout = new FileOutputStream("/home/l1s/test/words1.txt");
        ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] buf = new byte[4];

            int len;
            while ((len = in.read(buf)) != -1)
                bout.write(buf, 0, len);

            System.out.println(bout.toString());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}