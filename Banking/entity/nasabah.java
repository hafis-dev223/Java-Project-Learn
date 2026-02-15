package Banking.entity;

import java.util.*;
import java.security.MessageDigest;
import Banking.entity.Exception.*;
import java.time.*;

public class nasabah extends Person implements transaksiBankingInterface {

    private String norekening;
    private double saldo;
    private String alamat;
    private String phonenumber;
    public boolean kesalahanpenangkapan = false;
    int kesalahanuser = 0;

    final HashSet<String> hallo = new HashSet<>();

    public nasabah(String nama, int id, String email, String norekening, double saldo, String alamat,
            String phonenumber, String pinAwal) {
        super(nama, id, email);
        this.norekening = norekening;
        this.saldo = saldo;
        this.alamat = alamat;
        this.phonenumber = phonenumber;

        registrasiPIN(pinAwal);
    }

    public void registrasiPIN(String pin) {
        try {
            MessageDigest acakpin = MessageDigest.getInstance("SHA-256");
            byte[] acak = acakpin.digest(pin.getBytes());
            StringBuilder ini = new StringBuilder();
            for (byte h : acak) {
                ini.append(String.format("%02x", h));
            }
            hallo.add(ini.toString());
        } catch (Exception e) {
            System.err.println("Gagal registrasi PIN: " + e.getMessage());
        }
    }

    public String getNorekening() {
        return norekening;
    }

    public void setNorekening(String norekening) {
        this.norekening = norekening;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void PengumpulanData(nasabah datanasabahbaru) {

    }

    @Override
    public void Setortunai() throws Positiveangka {
        Scanner input = new Scanner(System.in);
        LocalDateTime hariini = LocalDateTime.now();

        try {
            System.out.print("masukan pin anda :");
            String inputpin = input.nextLine();
            char[] kumpulan = inputpin.toCharArray();
            boolean angkaaneh = false;

            for (char cangkaaneh : kumpulan) {
                if (!Character.isLetterOrDigit(cangkaaneh)) {
                    angkaaneh = true;
                }

                if (angkaaneh) {
                    throw new AngkaAneh("maaf tidak bisa menginput angka aneh");
                }
            }

            String hashInput = getHash(inputpin);

            if (hallo.contains(hashInput)) {
                System.out.println("di temukan pin anda");
                System.out.print("masukan uang anda minimal uang ('50.000') : ");
                int uanganda = input.nextInt();

                if (uanganda < 50000) {
                    throw new Positiveangka("maaf angka harus positive bukan negative");
                }

                this.saldo += uanganda;
                System.out.println("Uang berhasil disetorkan sebesar Rp " + uanganda + " pada waktu: " + hariini);
                System.out.println("Sisa saldo anda sekarang: Rp " + this.saldo);
                kesalahanuser = 0;

            } else {
                System.out.println("maaf pin anda tidak di temukan");
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("maaf input harus berupa angka bukan huruf, keselahan tertangkap: |" + kesalahanuser);

        } catch (Positiveangka e) {
            System.out.println("KESALAHAN tertangkap :" + e.getMessage() + "|" + kesalahanuser);
            kesalahanuser++;

        } catch (AngkaAneh e) {
            System.out.println("KESALAHAN tertangkap :" + e.getMessage() + "|" + kesalahanuser);
        }

        if (kesalahanuser == 10) {
            kesalahanpenangkapan = true;
            System.out.println("kesalahan sudah mencapai " + kesalahanuser + "X");
            System.exit(0);
        }

        if (!kesalahanpenangkapan) {
            System.out.println("tidak ada kesalahan");
        }
    }

    @Override
    public void transfer() throws transferlimit {
        LocalDateTime hariini = LocalDateTime.now();
        Scanner input = new Scanner(System.in);

        System.out.println("masukan no rekening tujuan anda :");
        String norekeningg = input.nextLine();

        if (!norekening.equals(norekeningg)) {
            System.out.println("no rekening tidak di temukan");
            return;
        }

        if (norekeningg.contains(norekening)) {
            System.out.println("no rekening di temukan");
            try {
                System.out.print("masukan uang anda yang anda ingin transfer: ");
                int uang = input.nextInt();

                if (uang < 100000) {
                    throw new transferlimit("transfer harus minimal 100000 lebih");
                }

                if (uang >= 100000) {
                    System.out.println("berhasil di transfer sebesar " + uang + "|waktu" + hariini);
                    this.saldo -= uang;
                } else {
                    System.out.println("uang anda kurang");
                }

            } catch (java.util.InputMismatchException e) {
                System.err.println("input harus berupa angka bukan huruf");
            }
        }
    }

    @Override
    public void Tariktunai(String pin) {
        Scanner input = new Scanner(System.in);
        LocalDateTime hariIni = LocalDateTime.now();
        try {
            System.out.println("masukan pin anda :");
            pin = input.nextLine();

            String kodeanda = getHash(pin);

            try {
                if (!hallo.contains(kodeanda)) {
                    System.err.println("pin anda ghoib");
                    return;
                }

                System.out.println("pin di temukan !!!!\n");
                System.out.println("pin hash anda: " + kodeanda);

                System.out.println("masukan uang anda yang anda ingin tarik :");
                int Jumlahuang = input.nextInt();

                if (Jumlahuang <= saldo) {
                    System.out.println("berhasil di tarik sebesar " + Jumlahuang + "|di waktu:" + hariIni);
                    saldo -= Jumlahuang;
                } else {
                    System.out.println("uang anda tidak cukup");
                }

            } catch (InputMismatchException e) {
                System.out.println("input harus berupa angka bukan huruf");
            }

        } catch (Exception e) {
            System.err.println("Kesalahan tertangkap: " + e.getMessage());
        }
    }

    @Override
    public void lihatsaldo() {
        Scanner input = new Scanner(System.in);

        System.out.print("masukan pin anda terlebih dahlu:");
        String pinAndaa = input.nextLine();
        String hashInput = getHash(pinAndaa);

        if (hallo.contains(hashInput)) {
            System.out.println("pin di temukan sisa saldo anda " + saldo);
        } else {
            System.out.println("maaf pin anda tidak temukan");
        }
    }

    private String getHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            return "";
        }
    }

}