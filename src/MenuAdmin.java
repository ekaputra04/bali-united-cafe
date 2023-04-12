import java.util.*;

public class MenuAdmin {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    public static void adminLihatRestaurant(Database database) {
        restaurants = database.getDaftarRestaurant();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Lihat Restaurant                    ||");
        System.out.println("=============================================================");

        if (restaurants.isEmpty()) {
            System.out.println("Belum ada restaurant.");
        } else {
            for (int i = 0; i < restaurants.size(); i++) {
                System.out.println("Restaurant " + (i + 1) + ":");
                System.out.println("Nama: " + restaurants.get(i).getName());
                System.out.println("Alamat: " + restaurants.get(i).getAddress());
                System.out.println();
            }
        }
    }

    public static void adminTambahRestaurant(Database database) {
        String name;
        String address;
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Tambah Restaurant                   ||");
        System.out.println("=============================================================");
        System.out.print("Masukkan Nama Restaurant: ");
        name = input.nextLine();
        System.out.print("Masukkan Alamat Restaurant: ");
        address = input.nextLine();

        Restaurant restaurantBaru = new Restaurant(name, address);
        database.tambahRestaurant(restaurantBaru);
    }

    public static void adminHapusRestaurant(Database database) {
        restaurants = database.getDaftarRestaurant();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Hapus Restaurant                    ||");
        System.out.println("=============================================================");
        if (restaurants.isEmpty()) {
            System.out.println("Belum ada restaurant.");
        } else {
            for (int i = 0; i < restaurants.size(); i++) {
                System.out.println("Restaurant " + (i + 1) + ":");
                System.out.println("Name: " + restaurants.get(i).getName());
                System.out.println("Address: " + restaurants.get(i).getAddress());
                System.out.println();
            }
            System.out.print("Masukkan nomor restaurant yang ingin dihapus: ");
            int index = input.nextInt();
            if (index < 1 || index > restaurants.size()) {
                System.out.println("Nomor restaurant tidak valid.");
            } else {
                restaurants.remove(index - 1);
                System.out.println("Restaurant berhasil dihapus.");
            }
        }
    }
}
