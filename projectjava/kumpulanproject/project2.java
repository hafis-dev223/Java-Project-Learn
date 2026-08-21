package projectjava.kumpulanproject;

import java.util.*;

import projectjava.exception.AuthException;
import projectjava.exception.duplicateException;
import projectjava.exception.duplicatepassword;
import projectjava.exception.isempetyexception;

import java.time.*;

public class project2 {

    private String nama;
    private String password;
    private String role;
    private String FullName;

    public project2(String nama, String password, String role, String FullName) {

        this.nama = nama;
        this.password = password;
        this.role = role;
        this.FullName = FullName;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    HashMap<String, String> datapasswHashMap = new HashMap<>();
    LinkedList<String> Username = new LinkedList<>();

    public void Validatename() throws AuthException, isempetyexception {
        LocalDateTime hariIni = LocalDateTime.now();

        Scanner input = new Scanner(System.in);
        System.out.print("masukan nama full anda :");
        String namaUser = input.nextLine();

        if (namaUser == null || namaUser.trim().isEmpty()) {
            throw new isempetyexception("nama tidak boleh kosong");

        }

        if (Username.contains(namaUser)) {
            throw new AuthException("username sudah ada");

        } else {
            Username.add(namaUser);
            System.out.println("%s berhasil di daftar kan " + namaUser + "waktu :" + hariIni);
        }

    }

    public void RegisterAuccound() throws duplicateException, duplicatepassword {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("masukan username anda :");
            String name = input.nextLine();

            if (!datapasswHashMap.containsKey(name)) {
                System.out.println("username belum ada ni");

                if (datapasswHashMap.containsValue(name)) {
                    System.out.println("data anda akan di tambah ");

                    datapasswHashMap.put(null, name);

                } else {

                    throw new duplicateException("nama anda tidak bisa di daftarkan duplicate");
                }

            } else {
                System.out.println("ketemu");
            }

            System.out.print("masukan password anda :");
            String passwordBaru = input.nextLine();

            if (datapasswHashMap.containsValue(passwordBaru)) {
                throw new duplicatepassword("tidak boleh duplicate passowrd");

            } else {
                System.out.println("password aman");
            }

            if (datapasswHashMap.equals(passwordBaru)) {

                System.out.println("ditemukan kami akan daftarkan");

                datapasswHashMap.put(passwordBaru, name);

            } else {
                System.out.println("data ghaib tidak di temukan");
            }
        }
    }

    public static void main(String[] args) {

        project2 run = new project2(null, null, null, null);

        try {
            run.Validatename();

        } catch (AuthException e) {

            System.out.println(e.getMessage());

        } catch (isempetyexception e) {

            System.out.println(e.getMessage());
        }

        try {
            run.RegisterAuccound();

        } catch (duplicateException e) {

            System.out.println(e.getMessage());

        } catch (duplicatepassword e) {

            System.out.println(e.getMessage());
        }

    }

}