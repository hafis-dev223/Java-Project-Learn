package projectjava.kumpulanproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testpostgre {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/belajar_db";
        String user = "postgres";
        String password = "hafis123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("SELAMAT DATANG DI DATA POSTGRE");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        " | Nama: " + rs.getString("nama") +
                        " | Email: " + rs.getString("email") +
                        " | Umur: " + rs.getInt("umur"));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Gagal Konek  Error: " + e.getMessage());
        }
    }
}
