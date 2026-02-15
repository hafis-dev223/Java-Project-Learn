package BelajarSocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws IOException {

        try {

            Socket socket = new Socket("localhost", 5000);

            OutputStream teks = socket.getOutputStream();

            String pesan = " hallo kontol";

            teks.write(pesan.getBytes());

            socket.shutdownOutput();

            System.out.println("berhasil nyambung");

            InputStream teks2 = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = teks2.read(buffer);

            String pesan3 = new String(buffer, 0, bytesRead);
            System.out.println(pesan3);

            socket.close();

        } catch (IOException e) {

            e.getStackTrace();

        }

    }

}
