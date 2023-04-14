import java.util.*;

public class MenuAdmin {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static ArrayList<Menu> menus = new ArrayList<Menu>();
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

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
            System.out.println(red + "Belum ada restaurant." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < restaurants.size(); i++) {
                System.out.println("Restaurant " + (i + 1) + ":");
                System.out.println("Id Restaurant : " + restaurants.get(i).getIdRestaurant());
                System.out.println("Nama   : " + restaurants.get(i).getName());
                System.out.println("Alamat : " + restaurants.get(i).getAddress());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void adminTambahRestaurant(Database database) {
        restaurants.clear();
        EditFileRestaurant.bacaFileRestaurant(database);
        restaurants = database.getDaftarRestaurant();
        String name;
        String address;
        String id;
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Tambah Restaurant                   ||");
        System.out.println("=============================================================");
        do {
            System.out.println("Masukkan Data Restaurant: (0 untuk membatalkan)");
            System.out.print("Masukkan Id Restaurant : ");
            id = input.nextLine();
            System.out.print("Masukkan Nama Restaurant : ");
            name = input.nextLine();
            System.out.print("Masukkan Alamat Restaurant : ");
            address = input.nextLine();

            if (id.equals("0") || name.equals("0") || address.equals("0")) {
                System.out.println(red + "Batal menambah restaurant" + reset);
                System.out.println("-------------------------------------------------------------");
                break;
            } else if (Validasi.validasiRestaurant(id, name)) {
                System.out.println(red + "Id atau Nama Restaurant Telah Digunakan!" + reset);
                System.out.println("-------------------------------------------------------------");
            }
        } while (Validasi.validasiRestaurant(id, name));

        if ((id.equals("0") || name.equals("0") || address.equals("0")) != true) {
            EditFileRestaurant.isiFileRestaurant(id, name, address);
            Restaurant restaurantBaru = new Restaurant(id, name, address);
            database.tambahRestaurant(restaurantBaru);
        }
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
            System.out.println(red + "Belum ada restaurant." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < restaurants.size(); i++) {
                System.out.println("Restaurant " + (i + 1) + ":");
                System.out.println("Id Restaurant : " + restaurants.get(i).getIdRestaurant());
                System.out.println("Nama   : " + restaurants.get(i).getName());
                System.out.println("Alamat : " + restaurants.get(i).getAddress());
                System.out.println("-------------------------------------------------------------");
            }

            System.out.println("Masukkan nomor restaurant yang ingin dihapus: (0 untuk membatalkan)");
            int index = Validasi.validasiAngka(0, restaurants.size());
            if (index > 0) {
                restaurants.remove(index - 1);
                EditFileRestaurant.hapusFileRestaurant(index);
                System.out.println(red + "Restaurant berhasil dihapus." + reset);
                System.out.println("-------------------------------------------------------------");
            } else {
                System.out.println(red + "Batal menghapus restaurant" + reset);
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void adminLihatMenuRestaurant(Database database) {
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
            System.out.println(red + "Belum ada menu." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < menus.size(); i++) {
                System.out.println("Menu " + (i + 1) + ":");
                System.out.println("Id Menu   : " + menus.get(i).getIdMenu());
                System.out.println("Nama Menu : " + menus.get(i).getNama());
                System.out.println("Harga     : Rp. " + menus.get(i).getHarga());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void adminTambahMenuRestaurant(Database database) {
        String idMenu;
        String namaMenu;
        int hargaMenu;
        input.nextLine();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                        MENU ADMIN                       ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                  Tambah Menu Restaurant                 ||");
        System.out.println("=============================================================");
        do {
            System.out.println("Masukkan Data Menu: (0 untuk membatalkan)");
            System.out.print("Masukkan id menu : ");
            idMenu = input.nextLine();
            System.out.print("Masukkan nama menu : ");
            namaMenu = input.nextLine();
            System.out.print("Masukkan harga menu : ");
            hargaMenu = Validasi.validasiAngkaLebih0();

            if (idMenu.equals("0") || namaMenu.equals("0")) {
                System.out.println(red + "Batal menambah menu" + reset);
                System.out.println("-------------------------------------------------------------");
                break;
            } else if (Validasi.validasiMenu(idMenu, namaMenu)) {
                System.out.println("Id atau Nama Menu Telah Digunakan!");
                System.out.println("-------------------------------------------------------------");
            }
        } while (Validasi.validasiMenu(idMenu, namaMenu));

        if ((idMenu.equals("0") || namaMenu.equals("0")) != true) {
            EditFileMenu.isiFileMenu(idMenu, namaMenu, hargaMenu);
            Menu menuBaru = new Menu(idMenu, namaMenu, hargaMenu);
            database.tambahMenu(menuBaru);
        }
    }

    public static void adminHapusMenuRestaurant(Database database) {
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
            System.out.println(red + "Belum ada menu." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < menus.size(); i++) {
                System.out.println("Menu " + (i + 1) + ":");
                System.out.println("Nama Menu : " + menus.get(i).getNama());
                System.out.println("Harga     : Rp. " + menus.get(i).getHarga());
                System.out.println("-------------------------------------------------------------");
            }
            System.out.println("Masukkan nomor menu yang ingin dihapus: (0 untuk membatalkan)");
            int index = Validasi.validasiAngka(0, menus.size());
            if (index > 0) {
                menus.remove(index - 1);
                EditFileMenu.hapusFileMenu(index);
                System.out.println(red + "Menu berhasil dihapus." + reset);
                System.out.println("-------------------------------------------------------------");
            } else {
                System.out.println(red + "Batal menghapus menu" + reset);
                System.out.println("-------------------------------------------------------------");
            }
        }
    }
}
