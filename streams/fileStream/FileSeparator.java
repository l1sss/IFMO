package streams.fileStream;

import java.io.*;

/**
 * Created by l1s on 15.04.17.
 */
public class FileSeparator {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/l1s/test/dir3/words"); //файл, который мы разделяем
        separate(file, "/home/l1s/test/dir3/words", 512);
    }

    //метод разделяет файл на части
    public static int separate(File file, String pathToResult, int size) throws IOException {
        try (InputStream fin = new FileInputStream(file)) {

            byte[] buffer = new byte[size]; //размер одной части

            int len;
            int i = 1;
            while ((len = fin.read(buffer)) > 0) {
                try (OutputStream fout = new FileOutputStream(pathToResult + i)) {
                    fout.write(buffer, 0, len);
                }
                i++;
            }
            return i;
        }
    }
}