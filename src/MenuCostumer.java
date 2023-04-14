import java.util.*;

public class MenuCostumer {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static ArrayList<Menu> menus = new ArrayList<Menu>();
    private static ArrayList<Pesanan> pesanans = new ArrayList<Pesanan>();

    public static void customerLihatRestaurant(Database database) {
        restaurants.clear();
        EditFileRestaurant.bacaFileRestaurant(database);
        restaurants = database.getDaftarRestaurant();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
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
        Login.loginCostumer(database);
    }

    public static void customerBuatPesanan(Database database) {
        menus.clear();
        menus = database.getDaftarMenu();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                       Buat Pesanan                      ||");
        System.out.println("=============================================================");
        System.out.println("Daftar Menu :");

        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            // System.out.println((i + 1) + ". " + menu.getNama() + " (" + menu.getHarga() + ")");
            System.out.printf("%d. %-37s (%d)%n", i + 1, menu.getNama(), menu.getHarga());
        }

        while (true) {
            System.out.print("Pilih menu yang ingin dipesan (0 untuk selesai): ");
            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan newline character

            if (pilihan == 0) {
                break;
            }

            Menu menu = menus.get(pilihan - 1);
            System.out.print("Masukkan jumlah pesanan: ");
            int jumlah = input.nextInt();
            System.out.println("-------------------------------------------------------------");
            input.nextLine(); // membersihkan newline character

            Pesanan pesanan = new Pesanan(menu, jumlah);
            database.tambahPesanan(pesanan);
        }
    }

    public static void customerLihatPesanan(Database database) {

        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      Lihat Pesanan                      ||");
        System.out.println("=============================================================");
        System.out.println("\nPesanan:");
        for (int i = 0; i < pesanans.size(); i++) {
            Pesanan pesanan = pesanans.get(i);
            System.out.println(
                pesanan.getMenu().getNama() + " (" + pesanan.getJumlah() + ") - " + pesanan.getTotalHarga());
        }

        int totalHarga = 0;
        for (int i = 0; i < pesanans.size(); i++) {
            totalHarga += pesanans.get(i).getTotalHarga();
        }
        System.out.println("Total harga: " + totalHarga);

        System.out.print("Masukkan jumlah uang: ");
        int jumlahUang = input.nextInt();

        Pembayaran pembayaran = new Pembayaran(pesanans.get(0), jumlahUang);
        System.out.println("Kembalian: " + pembayaran.getKembalian());

        database.tambahPembayaran(pembayaran);

        ArrayList<User> pelanggan = new ArrayList<User>();
        pelanggan = database.getDaftarPelanggan();

        System.out.println("\nTerima kasih " + pelanggan.get(0).getUsername() + " telah berkunjung keBali United Cafe!");
    }
}