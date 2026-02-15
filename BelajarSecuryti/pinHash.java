package BelajarSecuryti;

import java.util.Arrays;
import java.security.MessageDigest;

public class pinHash extends Exception {
    public static void main(String[] args) {
        String pinpolos = "1245667";
        System.out.println("pin polos:" + pinpolos);

        byte[] ubahkekodeacak = pinpolos.getBytes();

        System.out.println("kode acak nya adalah" + Arrays.toString(ubahkekodeacak));

        try {
            MessageDigest kodeacak = MessageDigest.getInstance("SHA-512");
            byte[] hashByte = kodeacak.digest(ubahkekodeacak);

            System.out.println("hasil nya :" + "" + Arrays.toString(hashByte));

            StringBuilder hallo = new StringBuilder();
            for (byte h : hashByte) {
                hallo.append(String.format("%02x", h));

            }

            System.out.println("hasil akhir masuk" + hallo.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
