package streams.fileStream;

import java.io.*;

/**
 * Created by l1s on 16.04.17.
 */
public class FileAssemble {
    public static void main(String[] args) throws IOException {
        assemble("/home/l1s/test/dir3/words", "/home/l1s/test/dir3/newWords", 3);
    }

    //метод склеивает части в один файл
    public static void assemble(String pathToFirstPart, String pathToResult, int parts) throws IOException {
        try (OutputStream fout = new FileOutputStream(pathToResult)) {

            byte[] buffer = new byte[1024];

            int len;

            for (int i = 1; i <= parts; i++) {
                try (InputStream fin = new FileInputStream(pathToFirstPart + i)) {
                    while ((len = fin.read(buffer)) > 0) {
                        fout.write(buffer, 0, len);
                    }
                }
            }
        }
    }
}