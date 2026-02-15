package SystemVoting;

import java.util.HashMap;
import java.util.Scanner;

import projectjava.kumpulanproject.project1;

import java.util.*;

public class ProjectJava {

    private String nameperserta;
    private int totalvote;
    private String Idperserta;

    public HashMap<String, ProjectJava> dataperserta = new HashMap<>();
    private HashMap<Integer, String> Pemenang = new HashMap<>();

    public ProjectJava(String nameperserta, int totalvote, String idperserta) {
        this.nameperserta = nameperserta;
        this.totalvote = totalvote;
        this.Idperserta = idperserta;

    }

    public String getNameperserta() {
        return nameperserta;
    }

    public void setNameperserta(String nameperserta) {
        this.nameperserta = nameperserta;
    }

    public int getTotalvote() {
        return totalvote;
    }

    public void setTotalvote(int totalvote) {
        this.totalvote = totalvote;
    }

    public String getIdperserta() {
        return Idperserta;
    }

    public void setIdperserta(String idperserta) {
        Idperserta = idperserta;
    }

    protected void MenambahkanData() {

        Scanner input1 = new Scanner(System.in);

        System.out.print("masukan nama anda :");
        String Nama = input1.nextLine();

        System.out.println("masukan id pendaftaran anda :");
        String Idperserta = input1.nextLine();

        ProjectJava datapersertaa = new ProjectJava(Nama, 0, Idperserta);

        dataperserta.put(Idperserta, datapersertaa);

        System.out.println("pendaftaran anda berhasil ");

    }

    public void MemulaiVote() {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.print("masukan id perserta yang anda ingin vote :");
            String idpersertaa = input.nextLine();

            dataperserta.forEach((id, nama) -> {
                String mintainput = input.nextLine();

                if (mintainput.equalsIgnoreCase("N")) {
                    System.out.println("keluar");
                    return;

                }

                if (idpersertaa.contains(idpersertaa)) {
                    System.out.println("id anda telah di temukan \n");

                    ProjectJava kandidat = dataperserta.get(Idperserta);

                    if (kandidat != null) {
                        kandidat.setTotalvote(kandidat.getTotalvote() + 1);

                        System.out.println("berhasil menambahkan vote" + "\n");

                    } else {
                        System.out.println("waduh gak bisa vote ni");
                    }

                    System.out.print("apakah anda ingin melanjutakan vote ketik Y/N jika ingin melanjutkan:");

                } else {
                    System.out.println("gagal menemukan id perserta");
                }

            });

        }

    }

    public void MencariPemenang() {
        System.out.println("============================");
        System.out.println("     Hasil Pemenang   ");
        System.out.println("============================");

        ProjectJava Pemenang = null;

        if (dataperserta == null) {
            System.out.println("tidak ada pendaftar di sini");

        }

        int totalvoteTertinggi = -1;

        for (ProjectJava pemenangLomba : dataperserta.values()) {
            if (pemenangLomba.getTotalvote() > totalvoteTertinggi) {
                totalvoteTertinggi = pemenangLomba.getTotalvote();
                pemenangLomba = Pemenang;

            }
        }

        System.out.println("Pemenang Voting  : " + Pemenang.getNameperserta());
        System.out.println("ID Pendaftaran   : " + Pemenang.getIdperserta());
        System.out.println("Total Perolehan  : " + Pemenang.getTotalvote() + " Vote!");

    }

    public static void main(String[] args) {

        ProjectJava run = new ProjectJava(null, 0, null);
        run.MenambahkanData();
        run.MemulaiVote();

    }
}