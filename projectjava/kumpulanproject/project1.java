package projectjava.kumpulanproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class project1 {
    public static void main(String[] args) {

        Map<String, Integer> Crud = new HashMap<>();
        Crud.put("chiki", 10);
        Crud.put("tejus", 5);
        Crud.put("baju", 5);
        Crud.put("iphone", 3);

        Crud.forEach((nama, Stok) -> {
            System.out.println("nama: " + nama + ":" + "stok:" + Crud.size());

            if (Stok < 5) {
                System.out.printf("%s stok hampir habis!(sisah : %d)\n", nama, Stok);

            } else {
                System.out.printf("%s stok aman (sisa: %d)\n", nama, Stok);
            }
        });

        System.out.println("====== update barang =======\n");
        Scanner input = new Scanner(System.in);

        System.out.printf("masukan nama barang anda: ");
        String update = input.nextLine();

        if (Crud.containsKey(update)) {
            System.out.printf("%s barang di temukan akan di hapus: %n ", update);
            Crud.remove(update);

        } else {
            System.out.printf("%s maaf barang tidak bisa di hapus! %n", update);
        }
        System.out.println("=====================================================\n");
        Crud.forEach((stok, name) -> {

            System.out.printf(" nama : %-15s | stok : %d\n", stok, name);
        });

    }

}
