package TantanganJava;

public class tantanganLogin {

    public static boolean cekPasswordAman(String password) {

        if (password.length() >= 8) {
            return true;

        }

        if (password.length() <= 8) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String passUser1 = "kopi123";
        String passUser2 = "kodingjava2026";
        boolean status1 = cekPasswordAman(passUser1);
        boolean status2 = cekPasswordAman(passUser2);
        System.out.println("Password 1 Aman? : " + status1); // Ekspektasi: false
        System.out.println("Password 2 Aman? : " + status2); // Ekspektasi: true
    }
}
