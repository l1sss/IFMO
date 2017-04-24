package test;

import patterns.decorator.CryptoOutputStream;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by l1s on 18.04.17.
 */

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int serverPort = 16666;
        String address = "10.150.0.188";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            OutputStream sout = socket.getOutputStream();

            CryptoOutputStream out = new CryptoOutputStream(sout, "111");

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            System.out.println("Напечатай сообщение для отправки:\n");

            line = keyboard.readLine();
            System.out.print("Отправляем сообщение на сервер...\n");

            out.write(line.getBytes());
            out.flush();

            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}