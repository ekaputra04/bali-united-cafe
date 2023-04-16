import java.util.*;

public class Fitur {

    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void tampilkanRestaurant(Database database) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants = database.getDaftarRestaurant();
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

    public static void tampilkanMenu(Database database) {
        ArrayList<Menu> menus = database.getDaftarMenu();
        menus = database.getDaftarMenu();
        if (menus.isEmpty()) {
            System.out.println("Tidak ada menu yang terdaftar");
        } else {
            System.out.printf("%s.\t%-37s\t%s\n", "No", "Nama Menu", "Harga");
            System.out.println("-------------------------------------------------------------");
            for (int i = 0; i < menus.size(); i++) {
                Menu menu = menus.get(i);
                System.out.printf("%d.\t%-37s (Rp. %d)%n", i + 1, menu.getNama(), menu.getHarga());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void terimaPesanan(User pelanggan, Pesanan pesanan, Database database) {
        database.tambahPelanggan(pelanggan);
        database.tambahPesanan(pesanan);
        System.out.println("Pesanan telah diterima.");
    }

    public static void tampilkanDaftarPesanan(Database database) {
        ArrayList<Pesanan> daftarPesanan = database.getDaftarPesanan();
        System.out.println("Daftar Pesanan :");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            System.out.println((i + 1) + ". " + pesanan.getMenu().getNama() + " x" + pesanan.getJumlah() + " - Rp. "
                    + pesanan.getTotalHarga());
        }
    }

    public static void tampilkanDaftarPembayaran(Database database) {
        ArrayList<Pembayaran> pembayarans = new ArrayList<Pembayaran>();
        pembayarans = database.getDaftarPembayaran();
        for (int i = 0; i < pembayarans.size(); i++) {
            System.out.println("Pembayaran : " + i + 1);
            System.out.println("Total Harga : Rp. " + pembayarans.get(i).getTotalHarga());
            System.out.println("Total Bayar : Rp. " + pembayarans.get(i).getJumlahUang());
            System.out.println("Kembalian   : Rp. " + pembayarans.get(i).getKembalian());
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void tampilkanDaftarPelanggan(Database database) {
        ArrayList<User> daftarPelanggan = database.getDaftarPelanggan();
        System.out.println("Daftar Pelanggan:");
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            User pelanggan = daftarPelanggan.get(i);
            System.out.println((i + 1) + ". " + pelanggan.getNamaUser() + " - " + pelanggan.getAlamatUser());
        }
    }
}
