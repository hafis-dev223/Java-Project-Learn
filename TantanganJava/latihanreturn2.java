package TantanganJava;

public class latihanreturn2 {

    public static String cekRoleUser(String username) {

        if (username.equalsIgnoreCase("admin")) {

            return "selamat anda boleh masuk";
        } else if (username.equalsIgnoreCase("kasir")) {
            return "selamat datang anda sebagai kasir";

        } else {
            return "selamat datang hafiidh";
        }

    }

    public static void main(String[] args) {
        String role1 = cekRoleUser("admin");
        String role2 = cekRoleUser("kasir");
        String role3 = cekRoleUser("hafid");
        System.out.println("Role 1: " + role1);
        System.out.println("Role 2: " + role2);
        System.out.println("Role 3: " + role3);
    }
}
