package streams.fileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by l1s on 14.04.17.
 */
public class CopyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/l1s/test/dir3/words.txt");
        copyFile(file, "/home/l1s/test/dir3/wordsCopy.txt");
    }

    public static void copyFile (File file, String path) throws IOException {
        try (FileInputStream fin = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(path)) {

            byte[] buffer = new byte[128];

            int len;
            while ((len = fin.read(buffer)) > 0)
                fos.write(buffer, 0, len);
        }
    }
}