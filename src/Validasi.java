import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Validasi {
    public static int validasiAngka (int paramBawah, int paramAtas){
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < paramBawah || angka > paramAtas);

        return angka;
    }

    public static int validasiAngkaLebih0 (){
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                System.out.print("Masukkan angka : ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < 0);

        return angka;
    }

    public static boolean validasiRestaurant(String idRestaurant, String namaRestaurant) {
        String fileName = "src/FileRestaurant.txt";
        boolean isRestaurant = false;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] restaurantData = line.split(",");
                if (restaurantData[0].equals(idRestaurant) || restaurantData[1].equals(namaRestaurant)) {
                    isRestaurant = true;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isRestaurant;
    }
}
