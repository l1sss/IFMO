package streams.serial.print;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * Created by xmitya on 28.08.16.
 */
public class PrintClient {

    private SocketAddress serverAddr;

    private String name;

    private Scanner scanner;

    public PrintClient(SocketAddress serverAddr, Scanner scanner) {
        this.serverAddr = serverAddr;
        this.scanner = scanner;
    }

    private void start() throws IOException, ClassNotFoundException {
        System.out.println("Enter your name: ");

        name = scanner.nextLine();

        while (true) {
            System.out.println("Enter message to send: ");

            String msg = scanner.nextLine();

            switch (msg) {

                case "/exit":

                    return;

                case "/nick":
                    System.out.println("Enter new name:");
                    name = scanner.nextLine();

                    continue;

                case "/myaddr":
                    printAddresses();

                    continue;

                case "/list_users":
                    sendPrintCommand(1);

                    continue;

                case "/server_time":
                    sendPrintCommand(2);

                    continue;

                case "/ping":
                    sendPrintCommand(3);

                    continue;
            }

            buildAndSendMessage(msg);
        }
    }

    private void printAddresses() throws SocketException {
        Enumeration e = NetworkInterface.getNetworkInterfaces();

        while(e.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface) e.nextElement();

            Enumeration ee = n.getInetAddresses();

            while (ee.hasMoreElements()) {
                InetAddress i = (InetAddress) ee.nextElement();

                System.out.println(i.getHostAddress());
            }
        }
    }

    private void buildAndSendMessage(String msg) throws IOException {
        Message message = new Message(System.currentTimeMillis(), name, msg);

        sendPrintMessage(message);

        System.out.println("Sent: " + message);
    }

    private void sendPrintMessage(Message msg) throws IOException {
        try (Socket sock = new Socket()) {
            sock.connect(serverAddr);

            try (OutputStream out = sock.getOutputStream()) {
                ObjectOutputStream objOut = new ObjectOutputStream(out);

                objOut.writeObject(msg);

                objOut.flush();
            }
        }
    }

    private void sendPrintCommand(int code) throws IOException, ClassNotFoundException {
        try (Socket sock = new Socket()) {
            sock.connect(serverAddr);

            try (OutputStream sout = sock.getOutputStream();
                 InputStream sin = sock.getInputStream()) {

                ObjectOutputStream objOut = new ObjectOutputStream(sout);

                switch (code) {
                    case 1:
                        Command command1 = new Command(code);
                        objOut.writeObject(command1);
                        objOut.flush();
                        Set set = (Set) new ObjectInputStream(sin).readObject();
                        System.out.println("Server users: " + set);

                        break;

                    case 2:
                        Command command2 = new Command(code);
                        objOut.writeObject(command2);
                        objOut.flush();
                        Date date = (Date) new ObjectInputStream(sin).readObject();
                        System.out.println("Server time: " + date);

                        break;

                    case 3:
                        Command command3 = new Command(code);
                        long start = System.nanoTime();
                        objOut.writeObject(command3);
                        objOut.flush();
                        Command command = (Command) new ObjectInputStream(sin).readObject();
                        long finish = System.nanoTime();
                        System.out.println("Respond time  = " + (finish - start));

                        break;

                    default:
                        throw new IOException("Invalid command!");

                }
            }
        }
    }

    private static SocketAddress parseAddress(String addr) {
        String[] split = addr.split(":");
        return new InetSocketAddress(split[0], Integer.parseInt(split[1]));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String addr = null;

        if (args != null && args.length > 0)
            addr = args[0];

        Scanner scanner = new Scanner(System.in);

        if (addr == null) {
            System.out.println("Enter server address");

            addr = scanner.nextLine();
        }

        PrintClient client = new PrintClient(parseAddress(addr), scanner);

        client.start();
    }
}
