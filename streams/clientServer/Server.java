package streams.clientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by l1s on 18.04.17.
 */
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

            /*DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);*/
            Object object = null;

            //String line = null;

            while (true) {
                //line = in.readUTF();
                object = new ObjectInputStream(sin).readObject();
                if (object instanceof Command) {
                    Command command = (Command) object;

                    System.out.println("Код команды: " + command.getCode() + "\n");

                    command.setCode(2);

                    ObjectOutputStream objOut = new ObjectOutputStream(sout);

                    objOut.writeObject(command);

                    System.out.println("Отправляем клиенту в ответ измененный код...");
                }

                //System.out.println("Мы получили это сообщение от клиента: " + line + "\n");

                //System.out.println("Отправляем клиенту эту строку обратно...\n");

                /*out.writeUTF(line);
                out.flush();
*/
                System.out.println("Ждём следующее сообщение...\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
