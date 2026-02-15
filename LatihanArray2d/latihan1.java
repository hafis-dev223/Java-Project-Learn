package LatihanArray2d;

public class latihan1 {

    public static void main(String[] args) {
        int[][] nilai = {
                { 80, 75, 90, 85 },
                { 70, 60, 88, 92 },
                { 95, 78, 85, 90 }
        };

        for (int i = 0; i < nilai.length; i++) {
          for (int j = 0; j < nilai.length; j++)
            System.out.println(nilai[i][j] + "");


        }
    }

}
