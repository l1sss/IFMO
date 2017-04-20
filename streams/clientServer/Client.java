package streams.clientServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by l1s on 18.04.17.
 */
public class Client {
    public static void main(String[] args) {
        int serverPort = 16666;
        String address = "10.150.0.188";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            Command command = new Command();
            command.setCode(1);

            /*DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);*/

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            System.out.println("Напечатай что-нибудь для инициализации отправки:\n");

            while (true) {
                line = keyboard.readLine();
                System.out.println("Отправляем код на сервер...\n");

                ObjectOutputStream objOut =  new ObjectOutputStream(sout);

                objOut.writeObject(command);

                Object object = new ObjectInputStream(sin).readObject();

                if (object instanceof Command) {
                    Command cm = (Command) object;

                    System.out.println("Измененный код, который пришёл от сервера: " + cm.getCode());
                }

                /*out.writeUTF(line);
                out.flush();

                System.out.println("Сервер вернул нам сообщение: " + line + "\n");

                System.out.println("Наверно стоит написать ещё что-нибудь: \n");*/
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
