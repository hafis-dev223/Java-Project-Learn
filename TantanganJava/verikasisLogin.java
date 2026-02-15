package TantanganJava;



public class verikasisLogin {

    private String pinDatabase = "123456";

    public String verifikasiPin(String pinInput) {

        if (pinInput == null || pinInput.isEmpty()) {
            return "waduh pin anda kosong ni";
        }

        if (pinInput.length() != 6) {
            return "minimal password anda 6";

        }

        if (pinInput.equals(pinDatabase)) {
            return "berhasil masuk";
        }

        return "pin anda salah ";

    }

    public static void main(String[] args) {

        verikasisLogin auth = new verikasisLogin();

        System.out.println("Test 1 (Null): " + auth.verifikasiPin(null));
        System.out.println("Test 2 (Kosong): " + auth.verifikasiPin(""));
        System.out.println("Test 3 (Salah Panjang): " + auth.verifikasiPin("123"));
        System.out.println("Test 4 (PIN Salah): " + auth.verifikasiPin("999999"));
        System.out.println("Test 5 (PIN Benar): " + auth.verifikasiPin("123456"));
    }

}
