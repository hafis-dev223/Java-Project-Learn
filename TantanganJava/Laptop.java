package TantanganJava;

import java.util.ArrayList;

public class Laptop {

    private String Nama;
    private int Harga;

    public Laptop(String nama, int harga) {
        Nama = nama;
        Harga = harga;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int harga) {
        Harga = harga;
    }

    public static ArrayList<Laptop> filterLaptopMurah(ArrayList<Laptop> daftarSemua, double batasHarga) {

        ArrayList<Laptop> DaftarIsidatabase = new ArrayList<>();

        for (Laptop p : DaftarIsidatabase) {
            if (p.getHarga() <= batasHarga) {

                DaftarIsidatabase.add(p);
                System.out.println("berhasil dimasukan ke database sementara");
            }
        }

        return DaftarIsidatabase;

    }

    public static void main(String[] args) {

        ArrayList<Laptop> database = new ArrayList<>();
        database.add(new Laptop("Asus ROG", 15_000_000));
        database.add(new Laptop("Lenovo Ideapad", 6_000_000));
        database.add(new Laptop("Acer Aspire", 5_500_000));
        database.add(new Laptop("Macbook Pro", 25_000_000));

        ArrayList<Laptop> rekomendasi = filterLaptopMurah(database, 7_000_000);

        System.out.println("=== LAPTOP BUDGET 7 JUTA ===");
        for (Laptop L : rekomendasi) {
            System.out.println("- " + L.getNama() + " (Rp " + L.getHarga() + ")");
        }
    }

}