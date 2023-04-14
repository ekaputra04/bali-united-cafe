import java.util.*;

public class MenuAdmin {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static ArrayList<Menu> menus = new ArrayList<Menu>();

    public static void adminLihatRestaurant(Database database) {
        restaurants.clear();
        EditFileRestaurant.bacaFileRestaurant(database);
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
                System.out.println("Nama   : " + restaurants.get(i).getName());
                System.out.println("Alamat : " + restaurants.get(i).getAddress());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void adminTambahRestaurant(Database database) {
        String name;
        String address;
        // input.nextLine(); // Untuk menghilangkan Buffer
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

        EditFileRestaurant.isiFileRestaurant(name, address);
        Restaurant restaurantBaru = new Restaurant(name, address);
        database.tambahRestaurant(restaurantBaru);
    }

    public static void adminHapusRestaurant(Database database) {
        restaurants.clear();
        EditFileRestaurant.bacaFileRestaurant(database);
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
                EditFileRestaurant.hapusFileRestaurant(index);
                System.out.println("Restaurant berhasil dihapus.");
            }
        }
    }

    public static void adminLihatMenuRestaurant(Database database){
        menus.clear();
        EditFileMenu.bacaFileMenu(database);
        menus = database.getDaftarMenu();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                   Lihat Menu Restaurant                 ||");
        System.out.println("=============================================================");
        if (menus.isEmpty()) {
            System.out.println("Belum ada menu.");
        } else {
            for (int i = 0; i < menus.size(); i++) {
                System.out.println("Menu " + (i + 1) + ":");
                System.out.println("Nama Menu : " + menus.get(i).getNama());
                System.out.println("Harga     : Rp. " + menus.get(i).getHarga());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void adminTambahMenuRestaurant(Database database){
        String namaMenu;
        int hargaMenu;
        input.nextLine();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                  Tambah Menu Restaurant                 ||");
        System.out.println("=============================================================");
        System.out.print("Masukkan nama menu : ");
        namaMenu = input.nextLine();
        System.out.print("Masukkan harga menu : ");
        hargaMenu = input.nextInt();
        EditFileMenu.isiFileMenu(namaMenu, hargaMenu);
        Menu menuBaru = new Menu(namaMenu, hargaMenu);
        database.tambahMenu(menuBaru);
    }

    public static void adminHapusMenuRestaurant(Database database){
        menus.clear();
        EditFileMenu.bacaFileMenu(database);
        menus = database.getDaftarMenu();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                   Hapus Menu Restaurant                 ||");
        System.out.println("=============================================================");
        if (menus.isEmpty()) {
            System.out.println("Belum ada menu.");
        } else {
            for (int i = 0; i < menus.size(); i++) {
                System.out.println("Menu " + (i + 1) + ":");
                System.out.println("Nama Menu : " + menus.get(i).getNama());
                System.out.println("Harga     : Rp. " + menus.get(i).getHarga());
                System.out.println("-------------------------------------------------------------");
            }
            System.out.print("Masukkan nomor menu yang ingin dihapus: ");
            int index = input.nextInt();
            if (index < 1 || index > menus.size()) {
                System.out.println("Nomor menu tidak valid.");
            } else {
                menus.remove(index - 1);
                EditFileMenu.hapusFileMenu(index);
                System.out.println("Menu berhasil dihapus.");
            }
        }
    }
}
