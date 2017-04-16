package lesson13.FileStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by l1s on 15.04.17.
 */
public class ReadFile {
    public static void main(String[] args) {
        System.out.println("Старый метод чтения файла: ");
        //Старый метод чтения текстового файла активно использует конструкции try-catch
        FileInputStream in = null;

        try {
            in = new FileInputStream("/home/l1s/test/dir1/test1");

            int i;
            while ((i = in.read()) != -1)
                System.out.print((char) i);

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (in != null)
                    in.close();
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("\nИспользование конструкции try-with-resourses: ");
        //С версии JAVA 7 возможен более лаконичный вариант с использованием конструкции try-with-resourses
        try (FileInputStream in2 = new FileInputStream("/home/l1s/test/dir1/test2"))
        {
            System.out.println("Размер файла : " + in2.available() + " байт(а)");

            int i;
            while ((i = in2.read()) != -1)
                System.out.print((char) i);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\nСчитываем данные в массив байтов: ");
        //Считываем данные в массив байтов
        try (FileInputStream in5 = new FileInputStream("/home/l1s/test/bufTest"))
        {
            byte[] buffer = new byte[in5.available()];
            //считываем файл в буфер
            in5.read(buffer, 0, in5.available());

            System.out.println("Содержимое файла: ");
            for (int i = 0; i < buffer.length; i++) {
                System.out.print((char) buffer[i]);
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("\n");
    }
}