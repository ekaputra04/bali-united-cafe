import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fitur {

    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void tampilkanRestaurant(Database database) {
        // method ini berguna untuk menampilkan data restaurant yang tersimpan dalam ArrayList daftarResturant dalam objek database
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
        // method ini berguna untuk menampilkan data menu yang tersimpan dalam ArrayList daftarMenu dalam objek database
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

    public static void tampilkanTanggalDanWaktu() {
        // method ini digunakan untuk menampilkan tanggal dan waktu saat customer melakukan pemesanan
        // Mengambil tanggal dan waktu saat ini
        LocalDateTime waktuSekarang = LocalDateTime.now();

        // Mengubah format tanggal dan waktu
        DateTimeFormatter formatTanggalWaktu = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Menampilkan tanggal dan waktu saat ini
        String tanggalWaktu = waktuSekarang.format(formatTanggalWaktu);
        System.out.println("Waktu Pemesanan  : " + tanggalWaktu);
    }

    public static void tampilkanDaftarPesanan(Database database) {
        // method ini berguna untuk menampilkan data pesanan sementara yang tersimpan dalam ArrayList daftarPesanan dalam objek database
        ArrayList<Pesanan> daftarPesanan = database.getDaftarPesanan();
        System.out.println("Daftar Pesanan :");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            System.out.println((i + 1) + ". " + pesanan.getMenu().getNama() + " x" + pesanan.getJumlah() + " - Rp. "
                    + pesanan.getTotalHarga());
        }
    }

    public static void tampilkanDaftarPesananTotal(Database database) {
        // method ini berguna untuk menampilkan data pesanan total yang tersimpan dalam ArrayList daftarPesananTotal dalam objek database
        ArrayList<Pesanan> daftarPesananTotal = database.getDaftarPesananTotal();
        System.out.println("Daftar Pesanan :");
        if (daftarPesananTotal.isEmpty()) {
            System.out.println(red + "Belum ada pesanan." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < daftarPesananTotal.size(); i++) {
                Pesanan pesanan = daftarPesananTotal.get(i);
                System.out.printf("%d.\t%-37s \t x %d \t Rp. %d\n", (i+1), pesanan.getMenu().getNama(), pesanan.getJumlah(), pesanan.getTotalHarga());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void tampilkanDaftarPembayaran(Database database) {
        // method ini berguna untuk menampilkan data pembayaran yang tersimpan dalam ArrayList daftarPembayaran dalam objek database
        ArrayList<Pembayaran> pembayarans = new ArrayList<Pembayaran>();
        pembayarans = database.getDaftarPembayaran();
        if (pembayarans.isEmpty()) {
            System.out.println(red + "Belum ada transaksi." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < pembayarans.size(); i++) {
                System.out.println("Pembayaran  : " + (i + 1));
                System.out.println("Total Harga : Rp. " + pembayarans.get(i).getTotalHarga());
                System.out.println("Total Bayar : Rp. " + pembayarans.get(i).getJumlahUang());
                System.out.println("Kembalian   : Rp. " + pembayarans.get(i).getKembalian());
                System.out.println("-------------------------------------------------------------");
            }
        }
    }

    public static void tampilkanDaftarPelanggan(Database database) {
        // method ini berguna untuk menampilkan data pelanggan yang tersimpan dalam ArrayList daftarPelanggan dalam objek database
        ArrayList<User> daftarPelanggan = database.getDaftarPelanggan();
        System.out.println("Daftar Pelanggan :");
        if (daftarPelanggan.isEmpty()) {
            System.out.println(red + "Belum ada pelanggan." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            for (int i = 0; i < daftarPelanggan.size(); i++) {
                User pelanggan = daftarPelanggan.get(i);
                System.out.println((i + 1) + ". " + pelanggan.getNamaUser() + " - " + pelanggan.getAlamatUser());
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
}
