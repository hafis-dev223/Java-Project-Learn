package BelajarSocket;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    public static void main(String[] args) throws IOException {

        try {

            System.out.println("mencoba menymabungkan ");

            ServerSocket jaringan1 = new ServerSocket(5000);

            Socket socket = jaringan1.accept();

            InputStream pesannerima = socket.getInputStream();

            byte[] buffer = new byte[1024];
            int bytesRead = pesannerima.read(buffer);

            String pesan = new String(buffer, 0, bytesRead);

            System.out.println(pesan);

            System.out.println("selamat anda terhubung");

            OutputStream ini3 = socket.getOutputStream();

            String pesan3 = "hallo juga";

            ini3.write(pesan3.getBytes());

            socket.close();
            jaringan1.close();

        } catch (IOException e) {

            e.getStackTrace();

        }

    }

}
