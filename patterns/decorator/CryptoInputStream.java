/*
package patterns.decorator;

import java.io.*;

public class CryptoInputStream extends FilterInputStream {
    private InputStream in;
    private String key;

    public CryptoInputStream(InputStream in, String key) {
        super(in);
        this.in = in;
        this.key = key;
    }

    @Override
    public int read(byte[] buffer) throws IOException {
        int c = in.read();
        if (c == -1)

            return -1;

        byte[] bkey = key.getBytes();

        int i = 1;
        try {
            for (; i < buffer.length; i++) {
                c = read();
                if (c == -1)

                    break;


            }
        }
    }
}
*/
