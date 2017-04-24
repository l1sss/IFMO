package streams.clientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by l1s on 18.04.17.
 */
//простой код для клиента, который отправляет сообщение на сервер и получает его в ответ
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int serverPort = 16666;
        String address = "192.168.0.101";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            System.out.println("Напечатай сообщение для отправки:\n");

            while (true) {
                line = keyboard.readLine();
                System.out.println("Отправляем сообщение на сервер...\n");

                out.writeUTF(line);
                out.flush();

                line = in.readUTF();

                System.out.println("Сервер вернул нам сообщение: " + line + "\n");

                System.out.println("Наверно стоит написать ещё что-нибудь: \n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
