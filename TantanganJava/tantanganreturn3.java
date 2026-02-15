package TantanganJava;

import java.util.ArrayList;



public class tantanganreturn3 {

    private String nama;
    private double harga;

    public tantanganreturn3(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public static tantanganreturn3 CariLaptop(ArrayList<tantanganreturn3> datalaptop, String DIcari) {

        for (tantanganreturn3 P : datalaptop) {

            if (P.getNama().equalsIgnoreCase(DIcari)) {
                return P;
            }
        }
        return null;

    }

    public static void main(String[] args) {

        ArrayList<tantanganreturn3> kardusLaptop = new ArrayList<>();

        tantanganreturn3 ini = new tantanganreturn3("victus", 20_000_000);

        kardusLaptop.add(ini);

        tantanganreturn3 mesinPencari = new tantanganreturn3("", 0);

        tantanganreturn3 hasilKetemu = mesinPencari.CariLaptop(kardusLaptop, "victus");

        if (hasilKetemu != null) {
            System.out.println("ketemu ni" + "" + hasilKetemu.getNama());
        } else {
            System.out.println("maaf laptop tidak di temukan");
        }

    }
}
