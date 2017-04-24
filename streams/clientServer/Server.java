package streams.clientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;

            while (true) {
                line = in.readUTF();

                System.out.println("Мы получили это сообщение от клиента: " + line + "\n");

                System.out.println("Отправляем клиенту эту строку обратно...\n");

                out.writeUTF(line);
                out.flush();

                System.out.println("Ждём следующее сообщение...\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
