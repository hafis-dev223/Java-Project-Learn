package aplikasiecommerscli;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

    private String Namalaptop;
    private String Mrek;
    private int Ram;
    private int Storage;
    private double Harga;
    private long Stok;

    public app() {

    }

    public app(String Namalaptop, String Mrek, int Ram, int Storage, double Harga, long Stok) {
        this.Namalaptop = Namalaptop;
        this.Mrek = Mrek;
        this.Ram = Ram;
        this.Storage = Storage;
        this.Harga = Harga;
        this.Stok = Stok;
    }

    // getter ( untuk mengakses atribut di class lain ) setter (untuk mengubah
    // atribut atau properti )
    public String getNamalaptop() {
        return Namalaptop;
    }

    public void setNamalaptop(String Namalaptop) {
        this.Namalaptop = Namalaptop;
    }

    public String getMrek() {
        return Mrek;
    }

    public void setMrek(String Mrek) {
        this.Mrek = Mrek;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int Ram) {
        this.Ram = Ram;
    }

    public int getStorage() {
        return Storage;
    }

    public void setStorage(int Storage) {
        this.Storage = Storage;
    }

    public double getHarga() {
        return Harga;
    }

    public void setHarga(double Harga) {
        this.Harga = Harga;
    }

    public long getStok() {
        return Stok;
    }

    public void setStok(long Stok) {
        this.Stok = Stok;
    }

    // exception custom untuk melakukan membuat exception manual
    public class LaptopNotFoundException extends Exception {

        public LaptopNotFoundException(String pesan) {
            super(pesan);
        }

    }

    public class LaptopAlreadyExistsException extends Exception {

        public LaptopAlreadyExistsException(String pesan) {
            super(pesan);
        }

    }

    public class OutOfStockException extends Exception {

        public OutOfStockException(String pesan) {
            super(pesan);
        }
    }

    public class InvalidInputException extends Exception {

        public InvalidInputException(String pesan) {
            super(pesan);
        }
    }

    ArrayList<app> databaselaptop = new ArrayList<>();

    // fungsi menambah laptop
    public void TambahLaptop() {

        Scanner input = new Scanner(System.in);
        System.out.println("============= TAMBAH LAPTOP ==================");

        while (true) {
            System.out.print("Nama Laptop : ");
            String nama = input.nextLine();

            System.out.print("Merk : ");
            String merk = input.nextLine();

            System.out.print("RAM : ");
            int ram = input.nextInt();

            System.out.print("Storage : ");
            int storage = input.nextInt();

            System.out.print("Harga : ");
            double harga = input.nextDouble();

            try {
                System.out.print("Stok : ");
                long stok = input.nextLong();

                app tambah = new app(nama, merk, ram, storage, harga, stok);
                databaselaptop.add(tambah);
                break;

            } catch (Exception e) {
                System.out.println("input tidak boleh berlebihan" + e);
                System.out.print("masukan stok anda lagi :");

            }
        }

    }

    // fungsi menacari laptop
    public void CariLaptop() throws LaptopNotFoundException {
        System.out.println("============== Selamat datang di Fitur mencari laptop ==============================");
        Scanner input = new Scanner(System.in);
        boolean ditemukan = false;

        System.out.println("masukan nama laptop anda ");
        String Petugas1 = input.nextLine();

        if (databaselaptop.isEmpty()) {
            System.out.println("gawat laptop  masih kosong");

        }

        for (var bototomatis : databaselaptop) {

            if (bototomatis.getNamalaptop().equalsIgnoreCase(Petugas1)) {
                System.out.println("laptop di temukan " + bototomatis.getNamalaptop());
                ditemukan = true;
                return;
            }

            if (!ditemukan) {
                throw new LaptopNotFoundException("gawat laptop tidak ada di database");
            }
        }

    }

    // method untuk melihat laptop
    public void lihatSemualaptop() {
        System.out.println("=================  SELAMAT DATANG DI FITUR LIHAT SEMUA LAPTOP =======================");

        for (var lihatsemualaptop : this.databaselaptop) {
            System.out.println("Laptop: " + lihatsemualaptop.getMrek() + " " + lihatsemualaptop.getNamalaptop()
                    + " | RAM: " + lihatsemualaptop.getRam() + "GB | Storage: " + lihatsemualaptop.getStorage()
                    + "GB | Harga: Rp" + lihatsemualaptop.getHarga() + " | Stok: " + lihatsemualaptop.getStok());
        }

    }

    // method untuk hapus laptop
    public void hapusLaptop() {
        System.out.println("================= Selamat datang di fitur hapus laptop ===========================");
        Scanner input = new Scanner(System.in);
        boolean ditemukan = false;
        int indeks = -1;

        while (true) {
            System.out.println("masukan laptop yang anda ingin hapus :");
            String petugas2 = input.nextLine();

            for (int i = 0; i < databaselaptop.size(); i++) {
                if (databaselaptop.get(i).getNamalaptop().equalsIgnoreCase(petugas2)) {
                    System.out.println("di temukan kami akan menghapus");
                    ditemukan = true;
                    indeks = i;
                    continue;
                }
            }
            System.out.println("apakah anda yakin ingin menghapus Y/n ");
            String petugas3 = input.nextLine();

            if (ditemukan) {

                if (petugas3.equalsIgnoreCase("Y")) {
                    System.out.println("berhasil di hapus");
                    databaselaptop.remove(indeks);
                    break;

                } else {
                    System.out.println("menghapus di batalkan");
                }
            } else {
                System.out.println("laptop tidak di temukan");
            }
        }
    }

    // method untuk melakukan update stock laptop
    public void updateStockLaptop() {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "========================= SELAMAT DATANG DI FITUR UPDATE STOCK ============================= ");

        while (true) {
            System.out.println("masukan nama laptop anda jika anda ingin di update :");
            String petugas4 = input.nextLine();
            boolean ditemukan = false;
            int indeks = -1;

            if (databaselaptop.isEmpty()) {
                System.out.println("gawattt laptop tidak di temukan");
                continue;
            }
            for (int i = 0; i < databaselaptop.size(); i++) {
                if (databaselaptop.get(i).getNamalaptop().equalsIgnoreCase(petugas4)) {
                    System.out.println("laptop di temukan");
                    ditemukan = true;
                    indeks = i;
                    break;

                }
            }

            if (ditemukan) {
                System.out.println("Stok sekarang:"
                        + databaselaptop.get(indeks).getStok());

                System.out.print("Masukkan stok baru : ");
                int stokBaru = input.nextInt();
                input.nextLine();

                databaselaptop.get(indeks).setStok(stokBaru);
                System.out.println("berhasil di update " + databaselaptop.get(indeks).getStok());
                return;

            } else {
                System.out.println("gawat stok laptop tidak di temukan");
            }

        }
    }

    // menu
    public void Menu() {
        System.out.println(
                "=========================== SELAMAT DATANG DI APLIKASI PENULANAN KOMPUTER ==========================");

        Scanner input = new Scanner(System.in);
        LoginUser ksesAdmin = new LoginUser();
        int pilihan = 9;
        while (true) {

            while (true) {
                System.out.println("\n========== MENU ==========");
                System.out.println("1. Tambah Laptop");
                System.out.println("2. Lihat Semua Laptop");
                System.out.println("3. Cari Laptop");
                System.out.println("4. Update Stock");
                System.out.println("5. Hapus Laptop");
                System.out.println("6. Login");
                System.out.println("7. Logout");
                System.out.println("8. Register");
                System.out.println("9. Keluar");
                System.out.print("Pilih Menu : ");
                try {
                    pilihan = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("waduh maaf banget ni input harus angka bukan huruf" + e.getMessage());
                    input.nextLine();
                }

                switch (pilihan) {
                    case 1:
                        TambahLaptop();
                        break;

                    case 2:
                        lihatSemualaptop();
                        break;

                    case 3:
                        try {
                            this.CariLaptop();
                        } catch (LaptopNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 4:
                        updateStockLaptop();
                        break;

                    case 5:
                        hapusLaptop();
                        break;

                    case 6:
                        ksesAdmin.Login();
                        break;

                    case 7:
                        ksesAdmin.Logout();
                        break;

                    case 8:
                        ksesAdmin.Register();
                        break;

                    case 9:
                        System.out.println("terimkasih sudah di datang di toko kami ");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia!");
                }
            }

        }

    }

    public static void main(String[] args) {

        app h = new app();

        h.Menu();

    }
}
