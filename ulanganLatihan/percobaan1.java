package ulanganLatihan;

import java.util.*;

public class percobaan1 {
    public static void main(String[] args) {

        int jumlahData = 5;

        String[] namaPaket = new String[jumlahData];
        long[] hargaPaket = new long[jumlahData];
        long[] jumlahHarga = new long[jumlahData];
        long[] discount = new long[jumlahData];
        long[] totalHarga = new long[jumlahData];
        int[] jumlahBeli = new int[jumlahData];

        long totalSeluruhHarga = 0;
        double totalSeluruhHargaDiscound = 0;

        for (int i = 0; i < jumlahData; i++) {
            System.out.println("data peket ke " + (i + 1));

            Scanner input = new Scanner(System.in);

            System.out.print("masukan kode paket :");
            int Data = input.nextInt();

            System.out.print("masukan jumlah beli anda : ");
            jumlahBeli[i] = input.nextInt();

            if (Data == 1) {
                namaPaket[i] = "paket1";
                hargaPaket[i] = 500000;
                discount[i] = (long) (0.10 * (hargaPaket[i] * jumlahBeli[i]));

            } else if (Data == 2) {
                namaPaket[i] = "paket2";
                hargaPaket[i] = 400000;
                discount[i] = (long) (0.08 * (hargaPaket[i] * jumlahBeli[i]));

            } else if (Data == 3) {
                namaPaket[i] = "paket3";
                hargaPaket[i] = 300000;
                discount[i] = (long) (0.07 * (hargaPaket[i] * jumlahBeli[i]));

            } else if (Data == 4) {
                namaPaket[i] = "paket4";
                hargaPaket[i] = 150000;
                discount[i] = (long) (0.05 * (hargaPaket[i] * jumlahBeli[i]));
            } else if (Data == 5) {
                namaPaket[i] = "paket5";
                hargaPaket[i] = 100000;
                discount[i] = (long) (0.02 * (hargaPaket[i] * jumlahBeli[i]));
            } else {
                System.out.println("maaf data tidak di temukan");
            }

            jumlahHarga[i] = hargaPaket[i] * jumlahBeli[i];
            totalHarga[i] = jumlahHarga[i] - discount[i];

            totalSeluruhHarga += jumlahHarga[i];
            totalSeluruhHargaDiscound += discount[i];
        }

        System.out.println("NO\tNAMA PAKET\tHARGA\tJUMLAH\tJUMLAH HARGA\tDISCOUNT\tTOTAL");
        System.out.println("----------------------------------------------------------------------------------");

        for (int j = 0; j < jumlahData; j++) {

            System.out.println((j + 1) + "\t" + namaPaket[j] + "\t\t" + hargaPaket[j] + "\t" + jumlahBeli[j] + "\t"
                    + jumlahHarga[j] + "\t\t" + discount[j] + "\t\t" + totalHarga[j]);
        }
        System.out.println("----------------------------------------------------------------------------------");

        double totalHargaBersih = totalSeluruhHarga - totalSeluruhHargaDiscound;

        System.out.println("Total Seluruh Harga    : Rp " + totalSeluruhHarga);
        System.out.println("Total Seluruh Discount : Rp " + totalSeluruhHargaDiscound);
        System.out.println("Total Bayar Bersih     : Rp " + totalHargaBersih);

    }

}
