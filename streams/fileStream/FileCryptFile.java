package streams.fileStream;

import java.io.*;

/**
 * Created by l1s on 16.04.17.
 */
public class FileCryptFile {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/home/l1s/Загрузки/Naruto.mp4");
        File file2 = new File("/home/l1s/Изображения/bander");

        fileCryptFile(file1, file2, "/home/l1s/Изображения/cryptNaruto");

        File file3 = new File("/home/l1s/Изображения/cryptNaruto");

        fileCryptFile(file3, file2, "/home/l1s/Изображения/decodeNaruto.mp4");
    }

    public static void fileCryptFile(File file, File key, String path) throws IOException {
        try (InputStream fin1 = new FileInputStream(file);
             InputStream fin2 = new FileInputStream(key);
             OutputStream fout = new FileOutputStream(path)) {

            byte[] buffer = new byte[1024];
            byte[] bkey = new byte[32];

            fin2.read(bkey);

            int len;
            while ((len = fin1.read(buffer)) > 0) {
                fout.write(crypt(buffer, bkey));
            }
        }
    }

    static byte[] crypt(byte[] bfile, byte[] bkey) {
        for (int i = 0; i < bfile.length; i++) {
            bfile[i] ^= bkey[i % bkey.length];
        }
        return bfile;
    }
}