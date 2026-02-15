package TantanganJava;

import java.util.HashMap;
import java.util.Map;


public class MultiUserAuth {

    private Map<String, String> dataUSer = new HashMap<>();

    public MultiUserAuth() {
        dataUSer.put("101", "111111");
        dataUSer.put("102", "222222");
    }

    public String verifikasiLogin(String noRek, String pinInput) {

        if (noRek == null || pinInput.isEmpty()) {
            return "Input tidak valid";
        }

        if (!dataUSer.containsKey(noRek)) {
            return "maaf dompet tidak di temukan";
        }

        if (!dataUSer.containsValue(pinInput)) {
            return "pin tidak valid";
        }

        return "pin berhasil lolos";
    }

    public static void main(String[] args) {

        MultiUserAuth app = new MultiUserAuth();

        System.out.println("Test 1 (Rekening Gak Ada): " + app.verifikasiLogin("999", "111111"));
        System.out.println("Test 2 (PIN Salah): " + app.verifikasiLogin("101", "999999"));
        System.out.println("Test 3 (Login Berhasil): " + app.verifikasiLogin("101", "111111"));
    }

}
