package TantanganJava;

import java.util.ArrayList;

public class tantanganlevel4 {

    private String nama;
    private int harga;

    public tantanganlevel4(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public static ArrayList<tantanganreturn3> filterLaptopMurah(ArrayList<tantanganreturn3> datalaptop,  double batasHarga) {

        ArrayList<tantanganlevel4> dataPenyimpanan = new ArrayList<>();

        for( tantanganlevel4  laptopku : dataPenyimpanan){
            if(laptopku.getHarga() <= batasHarga){
                dataPenyimpanan.add(laptopku);
            }
        }

        return filterLaptopMurah(datalaptop, batasHarga);
    }

}