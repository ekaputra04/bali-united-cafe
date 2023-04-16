import java.util.*;

public class MenuCostumer {
    private static Scanner input = new Scanner(System.in);
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void customerLihatRestaurant(Database database) {
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Lihat Restaurant                    ||");
        System.out.println("=============================================================");
        Fitur.tampilkanRestaurant(database);
    }

    public static void customerLihatMenu(Database database) {
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     Lihat Restaurant                    ||");
        System.out.println("=============================================================");
        Fitur.tampilkanMenu(database);
    }

    public static void customerBuatPesanan(Database database) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        ArrayList<Menu> menus = new ArrayList<Menu>();
        ArrayList<Pesanan> pesanans = new ArrayList<Pesanan>();
        menus = database.getDaftarMenu();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                       Buat Pesanan                      ||");
        System.out.println("=============================================================");
        System.out.println("Daftar Restaurant : ");
        Fitur.tampilkanRestaurant(database);
        System.out.print("Pilih Id Restaurant yang akan dikunjungi : ");
        String idRestaurant = input.nextLine();
        System.out.print("Inputkan jarak restaurant dengan lokasi Anda (km) : ");
        float jarakLokasi = Validasi.validasiAngkaFloatLebih0();
        System.out.println("Daftar Menu :");

        if (menus.isEmpty()) {
            System.out.println(red + "Belum ada menu." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            Fitur.tampilkanMenu(database);

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
                System.out.println("-------------------------------------------------------------");
            }

            pesanans = database.getDaftarPesanan();
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%s.\t%-37s\t%s\t%s\n", "No", "Nama Pesanan", "Jumlah", "Sub Total Harga");

            for (int i = 0; i < pesanans.size(); i++) {
                Pesanan pesanan = pesanans.get(i);
                System.out.printf("%d.\t%-37s \t %d \t Rp. %d\n", i + 1, pesanan.getMenu().getNama(),
                        pesanan.getJumlah(), pesanan.getTotalHarga());
            }
            System.out.println("-------------------------------------------------------------");
            int totalHarga = 0;

            for (int i = 0; i < pesanans.size(); i++) {
                totalHarga += pesanans.get(i).getTotalHarga();
            }

            System.out.println("Total harga : " + totalHarga);
            System.out.println("-------------------------------------------------------------");
            int jumlahUang;

            do {
                System.out.print("Masukkan jumlah uang : ");
                jumlahUang = Validasi.validasiAngkaLebih0();
                if (jumlahUang < totalHarga) {
                    System.out.println(red + "Jumah uang Anda kurang!" + reset);
                    System.out.println("-------------------------------------------------------------");
                }
            } while (jumlahUang < totalHarga);
            System.out.println(red + "Kembalian : " + (jumlahUang - totalHarga) + reset);
            System.out.println("-------------------------------------------------------------");
            Pembayaran pembayaran = new Pembayaran(pesanans, totalHarga, jumlahUang);
            database.tambahPembayaran(pembayaran);
            System.out.println("Pembayaran telah diterima.");

            ArrayList<User> pelanggans = new ArrayList<User>();
            pelanggans = database.getDaftarPelanggan();
            System.out.println(red + "Terima kasih " + pelanggans.get(0).getNamaUser() + " telah berkunjung ke Bali United Cafe!" + reset);
            System.out.println("=============================================================");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                     Detail Pemesanan                    ||");
            System.out.println("=============================================================");
            System.out.println("Id Restaurant    : " + idRestaurant);
            System.out.println("Nama Pelanggan   : " + pelanggans.get(0).getNamaUser());
            System.out.println("Alamat Pelanggan : " + pelanggans.get(0).getAlamatUser());
            System.out.println("Jarak ke Restaurant : " + jarakLokasi + " km");
            System.out.println("-------------------------------------------------------------");
            System.out.printf("%s.\t%-37s\t%s\t%s\n", "No", "Nama Pesanan", "Jumlah", "Sub Total Harga");
            System.out.println("-------------------------------------------------------------");
            for (int i = 0; i < pesanans.size(); i++) {
                Pesanan pesanan = pesanans.get(i);
                System.out.printf("%d.\t%-37s \t %d \t Rp. %d\n", i + 1, pesanan.getMenu().getNama(),
                        pesanan.getJumlah(), pesanan.getTotalHarga());
            }
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total Harga : Rp. " + totalHarga);
            System.out.println("Jumlah Uang : Rp. " + jumlahUang);
            System.out.println("Kembalian   : Rp. " + (jumlahUang - totalHarga));
            System.out.println("-------------------------------------------------------------");
            database.hapusPesanan();
        }
    }

    public static void customerLihatTransaksi(Database database) {
        ArrayList<Pembayaran> pembayarans = new ArrayList<Pembayaran>();
        pembayarans = database.getDaftarPembayaran();
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU COSTUMER                      ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                 Lihat Riwayat Transaksi                 ||");
        System.out.println("=============================================================");
        System.out.println("Daftar Riwayat Transaksi :");
        if (pembayarans.isEmpty()) {
            System.out.println(red + "Belum ada transaksi." + reset);
            System.out.println("-------------------------------------------------------------");
        } else {
            Fitur.tampilkanDaftarPembayaran(database);
        }
    }
}