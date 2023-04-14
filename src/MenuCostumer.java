import java.util.*;

public class MenuCostumer {

    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static ArrayList<Menu> menus = new ArrayList<Menu>();
    private static ArrayList<Pesanan> pesanans = new ArrayList<Pesanan>();
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void customerLihatRestaurant(Database database) {
        EditFileRestaurant.bacaFileRestaurant(database);
        restaurants = database.getDaftarRestaurant();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Lihat Restaurant                    ||");
        System.out.println("=============================================================");
        if (restaurants.isEmpty()) {
            System.out.println(red + "Belum ada restaurant." + reset);
            System.out.println("-------------------------------------------------------------");
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
        EditFileMenu.bacaFileMenu(database);
        menus = database.getDaftarMenu();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                       Buat Pesanan                      ||");
        System.out.println("=============================================================");
        System.out.println("Daftar Menu :");

        if (menus.isEmpty()) {
            System.out.println(red + "Belum ada menu." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.printf("%s.\t%-37s\t%s\n", "No", "Nama Menu", "Harga");
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                System.out.printf("%d.\t%-37s (%d)%n", i + 1, menu.getNama(), menu.getHarga());
            }

            while (true) {
                System.out.println("Pilih menu yang ingin dipesan (0 untuk selesai): ");
                int pilihan;
                pilihan = Validasi.validasiAngka(0, menus.size());
    
                if (pilihan == 0) {
                    break;
                }
    
                Menu menu = menus.get(pilihan - 1);
                System.out.println("Masukkan jumlah pesanan: ");
                int jumlah;
                jumlah = Validasi.validasiAngkaLebih0();
    
                Pesanan pesanan = new Pesanan(menu, jumlah);
                database.tambahPesanan(pesanan);
            }

            System.out.println("-------------------------------------------------------------");
            System.out.printf("%s.\t%-37s\t%s\t%s\n", "No", "Nama Pesanan", "Jumlah", "Sub Total Harga");
            for (int i = 0; i < pesanans.size(); i++) {
                Pesanan pesanan = pesanans.get(i);
                System.out.printf("%d.\t%-37s \t %d \t Rp. %d\n", i+1, pesanan.getMenu().getNama(), pesanan.getJumlah(), pesanan.getTotalHarga());
            }
            System.out.println("-------------------------------------------------------------");
        }

        Login.loginCostumer(database);
    }

    public static void customerLihatPesanan(Database database) {
        // pesanans.clear();
        pesanans = database.getDaftarPesanan();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      Lihat Pesanan                      ||");
        System.out.println("=============================================================");
        System.out.println("Pesanan:");
        if (pesanans.isEmpty()) {
            System.out.println(red + "Belum ada pesanan." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.printf("%s.\t%-37s\t%s\t%s\n", "No", "Nama Pesanan", "Jumlah", "Sub Total Harga");
            for (int i = 0; i < pesanans.size(); i++) {
                Pesanan pesanan = pesanans.get(i);
                System.out.printf("%d.\t%-37s \t %d \t Rp. %d\n", i+1, pesanan.getMenu().getNama(), pesanan.getJumlah(), pesanan.getTotalHarga());
            }

            int totalHarga = 0;
            for (int i = 0; i < pesanans.size(); i++) {
                totalHarga += pesanans.get(i).getTotalHarga();
            }
            
            System.out.println("Total harga : " + totalHarga);
            System.out.println("-------------------------------------------------------------");

            int jumlahUang;

            do{
                System.out.print("Masukkan jumlah uang : ");
                jumlahUang = Validasi.validasiAngkaLebih0();
                if (jumlahUang < totalHarga){
                    System.out.println(red + "Jumah uang Anda kurang!" + reset);
                    System.out.println("-------------------------------------------------------------");
                }
            } while (jumlahUang < totalHarga);
            
            Pembayaran pembayaran = new Pembayaran(pesanans.get(0), jumlahUang);
            System.out.println(red + "Kembalian : " + pembayaran.getKembalian() + reset);
            System.out.println("-------------------------------------------------------------");

            database.tambahPembayaran(pembayaran);

            ArrayList<User> pelanggan = new ArrayList<User>();
            pelanggan = database.getDaftarPelanggan();

            System.out.println(red + "Terima kasih " + pelanggan.get(0).getNamaUser() + " telah berkunjung ke Bali United Cafe!" + reset);
            System.out.println("-------------------------------------------------------------");
        }

        Login.loginCostumer(database);
    }
}