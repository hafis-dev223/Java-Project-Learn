package SystemEsport.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import SystemEsport.entity.Tim;
import SystemEsport.entity.player;
import SystemEsport.main.match;

public class TournamentService {

    public Map<String, Tim> daftarTim = new HashMap<>();

    private Set<player> mapPlayerGlobal = new HashSet<>();

    private List<match> riwayatMatch = new ArrayList<>();

    public void TambahTim() {

        LocalDateTime hariini = LocalDateTime.now();
        Scanner input = new Scanner(System.in);

        System.out.println("masukan id tim anda :");
        String NamaTIm = input.nextLine();

        if (!daftarTim.containsKey(NamaTIm)) {
            System.out.println("tim aman tidak duplicate");

        } else {
            System.out.println("waduh tim anda udah ada ni");
        }

        System.out.println("masukan nama anda tim anda ");
        String IdTeam = input.nextLine();

        Tim ObjekTim = new Tim(IdTeam, NamaTIm, 0, 0);

        daftarTim.put(IdTeam, ObjekTim);

        System.out.println("Selamat nama tim anda terdaftar semoga menang di pertandingan ");

    }

    public void TambahPLayer(int mactchPemain) {
        Scanner input = new Scanner(System.in);

        System.out.print("masukan nama anda :");
        String namaplayer = input.nextLine();

        if (mapPlayerGlobal.contains(namaplayer)) {
            System.out.println("maaf nama anda sudah ada yang pakai");
        } else {
            System.out.println("nama anda aman tidak ada yan gunakan");
        }

        System.out.print("masukan role anda apa :");
        String role = input.nextLine();

        if (mactchPemain > 100) {
            System.out.println("anda akan di berikan ke tim yang sangat sepuhh");

            player playerBaru = new player("12345", namaplayer, role);

            Tim timsepuh = daftarTim.get(namaplayer);

            if (timsepuh != null) {

                timsepuh.daftarTim.add(playerBaru);

                mapPlayerGlobal.add(playerBaru);

                System.out.println(" Player " + namaplayer + " berhasil di-put ke Map Tim yang mematikan di takuti !");

            } else {
                System.out.println("waduh tim anda belum anda yang buat ni");
            }

        } else {
            System.out.println("pendek macth poin nya dikit amat");
        }

    }

    public void PemilihanPemenang(String idTimA, String idTimB, String idPemenang) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n==============================================");
        System.out.println("          DAFTAR TIM TURNAMEN ESPORT          ");
        System.out.println("==============================================");

        System.out.printf("%-10s | %-20s\n", "ID TIM", "NAMA TIM");
        System.out.println("----------------------------------------------");

        daftarTim.forEach((idteam, tim) -> {
            System.out.printf("%-10s | %-20s\n", idteam, tim.getNamaTim());

            System.out.println("==============================================\n");

        });

        System.out.print("anda memilih tim apa :");
        String idTIM = input.nextLine();

        System.out.print("menang siapa dan kalah siapa:");
        String pemenangSiapa = input.nextLine();

        Tim timA = daftarTim.get(idTimA);
        Tim timB = daftarTim.get(idTimB);

        if (idPemenang.equalsIgnoreCase(idTimA)) {

            timA.setPoinMenang(timA.getPoinMenang() + 1);
            timB.setPoinKalah(timB.getPoinKalah() + 1);

            System.out.printf(" PEMENANG: %s (ID: %s)\n", timA.getNamaTim(), idTimA);

        } else if (idPemenang.equalsIgnoreCase(idTimB)) {

            timB.setPoinMenang(timB.getPoinMenang() + 1);
            timA.setPoinKalah(timA.getPoinKalah() + 1);

            System.out.printf(" PEMENANG: %s (ID: %s)\n", timB.getNamaTim(), idTimB);

        } else {
            System.out.println("tidak pemenang skor seri");
        }

    }

    public void tampilkanKlasemen() {

        List<Tim> listKlasemen = new ArrayList<>(daftarTim.values());

        listKlasemen.sort((tim1, tim2) -> Integer.compare(tim2.getPoin(), tim1.getPoin()));

        System.out.println("\n========================================================");
        System.out.println("                 KLASEMEN SEMENTARA ESPORT              ");
        System.out.println("========================================================");
        System.out.printf("%-7s | %-15s | %-8s | %-8s | %-6s\n", "Posisi", "Nama Tim", "Menang", "Kalah", "Poin");
        System.out.println("--------------------------------------------------------");

        int posisi = 1;
        for (Tim tim : listKlasemen) {
            System.out.printf("%-7d | %-15s | %-8d | %-8d | %-6d\n",
                    posisi,
                    tim.getNamaTim(),
                    tim.getPoinMenang(),
                    tim.getPoinKalah(),
                    tim.getPoin());
            posisi++;
        }
        System.out.println("========================================================\n");
    }
}
