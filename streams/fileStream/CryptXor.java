package streams.fileStream;

import java.io.*;

/**
 * Created by l1s on 16.04.17.
 */
public class CryptXor {
    public static void main(String[] args) throws IOException {
        File file = new File("/home/l1s/Изображения/bander.png");
        encryptFile(file, "simpleCryptXor","/home/l1s/Изображения/cryptBander.png");

        File file2 = new File("/home/l1s/Изображения/cryptBander.png");
        encryptFile(file2, "simpleCryptXor", "/home/l1s/Изображения/decodeBander.png");
    }

    //шифруем/дешифруем файл XOR'ом
    public static void encryptFile (File file, String key, String path) throws IOException {
        try (FileInputStream fin = new FileInputStream(file);
            FileOutputStream fout = new FileOutputStream(path)) {

            byte[] bkey = key.getBytes();

            byte[] buffer = new byte[128];

            int len;
            while ((len = fin.read(buffer)) > 0)
                fout.write(crypt(buffer, bkey), 0, len);
        }
    }

    static byte[] crypt(byte[] txt, byte[] key) {
        for (int i = 0; i < txt.length; i++) {
            txt[i] ^= key[i % key.length];
        }
        return txt;
    }
}