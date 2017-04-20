package streams.serial.print;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xmitya on 28.08.16.
 */
public class PrintServer {

    private int port;

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

    private Set<String> users;

    public PrintServer(int port) {
        this.port = port;
        users = new TreeSet<>();
    }

    private void start() throws IOException {
        try (ServerSocket ssocket = new ServerSocket(port)) {
            System.out.println("Server started on " + ssocket);

            while (true) {
                Socket sock = ssocket.accept();

                try {
                    process(sock);
                }
                catch (ClassNotFoundException e) {
                    System.err.println("Wrong message was received");

                    e.printStackTrace();
                }
                finally {
                    sock.close();
                }
            }
        }
    }

    private void process(Socket sock) throws IOException, ClassNotFoundException {
        String host = sock.getInetAddress().getHostAddress();

        try (ObjectInputStream objIn = new ObjectInputStream(sock.getInputStream())) {

            Object obj = objIn.readObject();

            if (obj instanceof Message) {
                printMessage((Message) obj, host);
                users.add(((Message)obj).getSender());
            }

            if (obj instanceof Command) {
                try (OutputStream out = sock.getOutputStream();
                     ObjectOutputStream objOut = new ObjectOutputStream(out)) {
                    Command cm = (Command) obj;

                    int code = cm.getCode();

                    switch (code) {
                        case 1:
                            objOut.writeObject(users);
                            objOut.flush();

                            break;

                        case 2:
                            objOut.writeObject(new Date());
                            objOut.flush();

                            break;

                        case 3:
                            objOut.writeObject(obj);
                            objOut.flush();

                            break;

                        default:
                            throw new IOException("Invalid command code");
                    }
                }
            }
        }

        catch (IOException | ClassNotFoundException | RuntimeException e) {
            System.err.println("Failed process connection from: " + host);

            e.printStackTrace();

            throw e;
        }
    }

    private void printMessage(Message msg, String senderAddr) {
        System.out.printf("%s (%s) at %s wrote: %s\n", msg.getSender(), senderAddr, format.format(new Date(msg.getTimestamp())), msg.getText());
    }

    private void printUsers() {
        System.out.println(users);
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0)
            throw new IllegalArgumentException("Port must be specified");

        int port = Integer.parseInt(args[0]);

        PrintServer printServer = new PrintServer(port);

        printServer.start();
    }
}
