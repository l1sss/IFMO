package patterns.decorator;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by l1s on 21.04.17.
 */
public class CryptoOutputStream extends FilterOutputStream {
    private OutputStream out;
    private String key;

    public CryptoOutputStream(OutputStream out, String key) {
        super(out);
        this.out = out;
        this.key = key;
    }

    @Override
    public void write(byte[] b) throws IOException {
        if (b == null)
            throw new NullPointerException();

        byte[] key = this.key.getBytes();

        for (int i = 0; i < b.length; i++)
            b[i] ^= key[i % key.length];

        out.write(b);
    }
}