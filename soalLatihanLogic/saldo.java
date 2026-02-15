package soalLatihanLogic;

public class saldo {
    public static void main(String[] args) {

        int hargaBarang = 100_000;
        int saldo = 50000;

        if (saldo < hargaBarang) {
            System.out.println("saldo anda kurang");

        } else {
            System.out.println("saldo anda cukup");
        }
    }
}