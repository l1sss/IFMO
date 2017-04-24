package test;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l1s on 18.04.17.
 */
//простой код сервера, который получает сообщение от клиента и возвращает его обратно
public class Server {
    public static void main(String[] args) {
        int port = 16666;

        try {
            ServerSocket ss = new ServerSocket(port);

            System.out.println("Ждём клиента...\n");

            Socket socket = ss.accept();

            System.out.println("Есть контакт!\n");

            InputStream sin = socket.getInputStream();

            DataInputStream in = new DataInputStream(sin);

            String key = "111";
            byte[] bkey = key.getBytes();

            int len;
            int i = 0;

            while((len = in.read()) > 0) {
                System.out.print((char) (len ^ bkey[i]));
                if (i < bkey.length - 1) i++;
                else i = 0;
            }

            in.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
