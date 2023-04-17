import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Validasi {
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static int validasiAngka(int paramBawah, int paramAtas) {
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println(red + "Input harus berupa angka! Silakan coba lagi." + reset);
                System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < paramBawah || angka > paramAtas);
        
        return angka;
    }

    public static int validasiAngkaLebih0() {
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka : ");
            while (!scanner.hasNextInt()) {
                System.out.println(red + "Input harus berupa angka! Silakan coba lagi." + reset);
                System.out.print("Masukkan angka : ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < 0);

        return angka;
    }

    public static float validasiAngkaFloatLebih0() {
        Scanner scanner = new Scanner(System.in);
        float angka;

        do {
            System.out.print("Masukkan angka : ");
            while (!scanner.hasNextInt()) {
                System.out.println(red + "Input harus berupa angka! Silakan coba lagi." + reset);
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

    public static boolean validasiMenu(String idMenu, String namaMenu) {
        String fileName = "src/FileMenu.txt";
        boolean isMenu = false;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] restaurantData = line.split(",");
                if (restaurantData[0].equals(idMenu) || restaurantData[1].equals(namaMenu)) {
                    isMenu = true;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isMenu;
    }

    public static boolean validasiIdRestaurant(Database database, String idRestaurant) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ArrayList<String> idRestaurants = new ArrayList<String>();
        String idRest;
        restaurants = database.getDaftarRestaurant();
        for (int i = 0; i < restaurants.size(); i++) {
            idRest = restaurants.get(i).getIdRestaurant();
            idRestaurants.add(idRest);
        }
        if (idRestaurants.contains(idRestaurant)) {
            return true;
        } else {
            System.out.println(red + "Masukkan Id Restarant yang terdaftar!" + reset);
            return false;
        }
    }
}
