package lesson13.FileStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by l1s on 15.04.17.
 */
public class WriteFile {
    public static void main(String[] args) {
        //Запись строки в файл
        String text = "Testestestestest";

        try (FileOutputStream out = new FileOutputStream("/home/l1s/test/write.txt"))
        {
            //перевод строки в байты
            byte[] bufer = text.getBytes();

            out.write(bufer, 0, bufer.length);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}