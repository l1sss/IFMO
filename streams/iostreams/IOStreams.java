package streams.iostreams;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by xmitya on 28.08.16.
 */
public class IOStreams {

    private final static File FILE = new File("test_file.txt");

    private static final Charset CHARSET = Charset.forName("UTF-8");

    public static final int NUM = 3;

    private void writeBinary(File file, boolean append) throws IOException {
        OutputStream out = null;

        try {
            out = new FileOutputStream(file, append);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < NUM; i++)
                sb.append("line ").append(i).append('\n');

            byte[] bytes = sb.toString().getBytes(CHARSET);

            out.write(bytes);

//            for (int i = 0; i < bytes.length; i++)
//                out.write(((int) bytes[i]) & 0xFF);

        }
        finally {
            if (out != null)
                out.close();
        }
    }

    private String readBinary(File file) throws IOException {
        InputStream in = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {
            in = new FileInputStream(file);

            byte[] buf = new byte[1024];

            int len;

            while ((len = in.read(buf)) > 0)
                bout.write(buf, 0, len);

            return new String(bout.toByteArray(), CHARSET);
        }
        finally {
            bout.close();

            if (in != null)
                in.close();
        }
    }

    private void writeText(OutputStream out) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(out, CHARSET);

        try {
            writer = new OutputStreamWriter(out, CHARSET);

            for (int i = 0; i < NUM; i++)
                writer.write("line " + i + "\n");
        }
        finally {
            writer.flush();
        }
    }

    private void writeText(File file, boolean append) throws IOException {
        try (OutputStream out = new FileOutputStream(file, append)) {
            writeText(out);
        }
    }

    private String readText(InputStream in) throws IOException {
        InputStreamReader reader = new InputStreamReader(in, CHARSET);

        StringBuilder sb = new StringBuilder();

        char[] buf = new char[16];

        int len;

        while ((len = reader.read(buf)) > 0)
            sb.append(buf, 0, len);

        return sb.toString();
    }

    private String readText(File file) throws IOException {
        try (InputStream in = new FileInputStream(file)) {
            return readText(in);
        }
    }

    private void testBytes() throws IOException {
        System.out.println("== Bytes ==");

        writeBinary(FILE, false);

        System.out.printf("Write: \n%s\n", readBinary(FILE));

        writeBinary(FILE, true);

        System.out.printf("Append: \n%s\n", readBinary(FILE));
    }

    private void testText() throws IOException {
        System.out.println("== Text ==");

        writeText(FILE, false);

        System.out.printf("Write: \n%s\n", readText(FILE));

        writeText(FILE, true);

        System.out.printf("Append: \n%s\n", readText(FILE));
    }

    private String readUrl(String url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestProperty("Accept-Charset", CHARSET.name());

        try (InputStream in = con.getInputStream()) {
            return readText(in);
        }
    }

    public static void main(String[] args) throws IOException {
        IOStreams streams = new IOStreams();

//        streams.testBytes();

//        streams.testText();

        System.out.println(streams.readUrl("https://habrahabr.ru/"));
    }
}
