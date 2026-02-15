package SystemEsport.main;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TournamentService service = new TournamentService();
        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   WELCOME TO SYSTEM ESPORT MANAGEMENT SYSTEM     ");
        System.out.println("==================================================");

        while (running) {
            System.out.println("\n>>> MENU UTAMA SYSTEM ESPORT <<<");
            System.out.println("1. Tambah Tim Baru");
            System.out.println("2. Tambah Player ke Tim / Tim Sepuh");
            System.out.println("3. Tampilkan Daftar Tim");
            System.out.println("4. Catat Pertandingan (Adu Tim)");
            System.out.println("5. Tampilkan Klasemen Sementara (Auto Sort)");
            System.out.println("6. Keluar System");
            System.out.print("Pilih Menu (1-6): ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- [1] TAMBAH TIM ---");
                    service.TambahTim();
                    break;

                case 2:
                    System.out.println("\n--- [2] TAMBAH PLAYER ---");
                    System.out.print("Masukkan Total Match Poin Player: ");
                    int matchPoin = 0;
                    try {
                        matchPoin = Integer.parseInt(input.nextLine());
                    } catch (Exception e) {
                        System.out.println("❌ Match Poin harus angka!");
                        break;
                    }
                    service.TambahPLayer(matchPoin);
                    break;

                case 3:
                    System.out.println("\n--- [3] DAFTAR TIM ---");
                    service.tampilkanKlasemen();
                    break;

                case 4:
                    System.out.println("\n--- [4] CATAT PERTANDINGAN ---");
                    System.out.print("Masukkan ID Tim A: ");
                    String idA = input.nextLine();
                    System.out.print("Masukkan ID Tim B: ");
                    String idB = input.nextLine();
                    System.out.print("Masukkan ID Tim Pemenang: ");
                    String idPemenang = input.nextLine();
                    service.PemilihanPemenang(idA, idB, idPemenang);
                    break;

                case 5:
                    System.out.println("\n--- [5] KLASEMEN ESPORT ---");
                    service.tampilkanKlasemen();
                    break;

                case 6:
                    System.out.println("\n==================================================");
                    System.out.println("  SYSTEM SHUTDOWN. TERIMA KASIH SEPUH HAFIDH! 🔥  ");
                    System.out.println("==================================================");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Menu pilihan tidak ada!");
                    break;
            }
        }
        input.close();
    }
}