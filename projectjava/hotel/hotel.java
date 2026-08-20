package projectjava.hotel;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.net.URI;
import java.awt.Desktop;

public class hotel {

    private int noKamar;
    private String typeKamar;
    private double harga;
    private String pelanggan;

    public hotel(int noKamar, String typeKamar, double harga, String pelanggan) {

        this.harga = harga;
        this.noKamar = noKamar;
        this.typeKamar = typeKamar;
        this.pelanggan = pelanggan;

    }

    public int getNoKamar() {
        return noKamar;
    }

    public void setNoKamar(int noKamar) {
        this.noKamar = noKamar;
    }

    public String getTypeKamar() {
        return typeKamar;
    }

    public void setTypeKamar(String typeKamar) {
        this.typeKamar = typeKamar;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    HashMap<Integer, String> data = new HashMap<>();
    LinkedList<String> Pelanggan = new LinkedList<>();

    public void DataKamar() {

        data.put(1233, typeKamar);
        data.put(1566, typeKamar);
        data.put(1677, typeKamar);
        data.put(1377, typeKamar);

    }

    public void LihatSemuaKamar() {

        data.forEach((no, typekamar) -> {
            System.out.println("no kamar :" + no + "|" + "type kamar" + typekamar);

        });
    }

    public void pesanKamar() throws duplicateException {

        Scanner input = new Scanner(System.in);
        LocalDateTime hariini = LocalDateTime.now();
        DateTimeFormatter formatwaktu = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tanggalpendaftaran = hariini.format(formatwaktu);

        while (true) {
            try {
                System.out.print("masukan no kamar anda :");
                int No = input.nextInt();

                if (!data.containsKey(No)) {
                    throw new duplicateException("maaf no kamar sudah ada yang pesan!\n" + "di waktu :" + "" + hariini);
                }

                System.out.println(" pesanan anda berhasil di pesan silahkan di tunggu\n" + "di waktu dan jam : "
                        + tanggalpendaftaran);

                data.remove(No);
                break;

            } catch (InputMismatchException e) {
                System.out.println("input harus berupa angka ");
            }
        }
    }

    public void cancelpesanan() throws duplicateException {

        Scanner input = new Scanner(System.in);
        boolean nokamarr = false;

        System.out.print("masukan no kamar anda yang ingin di batalkan:");
        int no = input.nextInt();

        if (!data.containsKey(no)) {
            System.out.println("di temukan no kamar anda akan di batalkan");
            nokamarr = true;

            data.put(no, typeKamar);

        }

        if (nokamarr) {
            System.out.println("no kamar tidak di temukan");
        }

    }

    public static void PrankmukaJoker() {
        try {
            URI hallo = new URI("https://prank-joker.vercel.app");
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(hallo);

            }
        } catch (Exception e) {
            System.out.println("gagal buka browsher");
        }
    }

    public static void main(String[] args) {

        hotel h = new hotel(101, "VIP", 500000.0, "Hafis");

        h.DataKamar();

        Scanner input = new Scanner(System.in);
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n=== MENU HOTEL ===");
            System.out.println("1. Lihat Semua Kamar");
            System.out.println("2. Pesan Kamar");
            System.out.println("3. Batalkan Pesanan");
            System.out.println("4. dapat thadiah");
            System.out.println("5. keluar");
            System.out.print("Pilih menu (1-4): ");
            int pilih = input.nextInt();

            switch (pilih) {
                case 1 -> h.LihatSemuaKamar();
                case 2 -> {
                    try {
                        h.pesanKamar();
                    } catch (duplicateException e) {
                        System.out.println("Kesalahan Tertangkap: " + e.getMessage());
                    }
                }
                case 3 -> {
                    try {
                        h.cancelpesanan();
                    } catch (duplicateException e) {
                        System.out.println("Keselahan Tertangkap: " + e.getMessage());
                    }
                }
                case 4 -> {
                    PrankmukaJoker();
                }

                case 5 -> {
                    System.out.println("berhasil keluar");
                    jalan = false;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
