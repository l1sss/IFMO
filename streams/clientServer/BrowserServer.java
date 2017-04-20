package streams.clientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l1s on 19.04.17.
 */
//сервер в который можно писать через telnet
public class BrowserServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(54321);
             Socket socket = ss.accept()) {

            Reader reader = new InputStreamReader(socket.getInputStream());

            char[] buf = new char[128];

            int len;

            while ((len = reader.read(buf)) != -1) {

                System.out.println(new String(buf, 0, len));
            }
        }
    }
}
