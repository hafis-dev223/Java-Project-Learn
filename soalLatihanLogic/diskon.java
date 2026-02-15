package soalLatihanLogic;

public class diskon {
    public static void main(String[] args) {

        int totalBelanja = 150000;
        double diskon = 0.20;
        if (totalBelanja >= 100000) {
            double total = diskon * (totalBelanja / 100000);
            System.out.println("selamat anda dapat diskon sebesar :" + total);
        } else if (totalBelanja < 50000) {
            System.out.println("maaf tidak mendapat diskon");
        } else {
            System.out.println("belanja masih 0");
        }

    }

}
