package aplikasiecommerscli;
import java.util.Scanner;
import java.util.ArrayList;

public class LoginUser implements fungsi {

    ArrayList<String> UsernameUser = new ArrayList<>();
    ArrayList<String> PasswordUser = new ArrayList<>();

    @Override
    public void Register() {
        System.out.println("============= AYO BUAT AKUN ABRU ANDA ================");
        Scanner input = new Scanner(System.in);
        boolean usernameuser = false;

        while (true) {
            System.out.println("masukan username baru anda :");
            String User = input.nextLine();

            if (User.isBlank()) {
                System.out.println("waduh isi dulu input nya ");
                continue;
            }

            if (UsernameUser.contains(User)) {
                System.out.println("waduh username ada yang pakai ni" + User);
                continue;

            } else {
                System.out.println("nama aman tidak ada yang pakai");
                usernameuser = true;
                UsernameUser.add(User);

            }

            System.out.println("masukan password baru anda :");
            String user2 = input.nextLine();

            if (user2.isBlank()) {
                System.out.println("waduh isi dulu password nya");
                continue;
            }

            if (user2.length() < 8) {
                System.out.println(" waduh password kemah minimal panjang huruf harus 8 huruf ni ");
                
                if(PasswordUser.contains(user2)){
                    System.out.println("waduh password ada yang pake ini ");
                    continue;
                
                } else {
                    System.out.println("passowrd aman tidak ada yang pakai");
                }

            } else {
                System.out.println("password aman passoword berhasil di buat");
                PasswordUser.add(user2);
                break;
            }

        }

    }

    @Override
    public void Login() {
        System.out.println("=========== SELAMAT DATANG DI FITUR LOGIN ================");
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("masukan nama anda :");
            String LoginUsername = input.nextLine();

            if (LoginUsername.isBlank()) {
                System.out.println("waduh isi dulu username nya ");
                continue;
            }

            if (UsernameUser.contains(LoginUsername)) {
                System.out.println("mantap username ketemu! ");

                int index = UsernameUser.indexOf(LoginUsername);

                System.out.println("masukan password anda :");
                String LoginPassword = input.nextLine();

                if (LoginPassword.isBlank()) {
                    System.out.println("password isi dulu ");
                    continue;
                }

                if (PasswordUser.get(index).equals(LoginPassword)) {
                    System.out.println("Bener Login Berhasil, Selamat datang.");
                    break;
                } else {
                    System.out.println("waduh password salah! Silakan coba lagi.");
                }
            } else {
                System.out.println("Waduh, username tidak terdaftar di database!");
            }
        }
    }

    @Override
    public void Logout() {
        System.out.println("logout berhasil");

    }

}
