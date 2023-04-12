import java.util.*;

public class Main {

    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static Scanner scanner = new Scanner(System.in);

    public static void header() {
        ClearConsole.clearConsole();
        System.out.println("=============================================================");
        System.out.println("||                                                         ||");
        System.out.println("||                    BALI UNITED CAFE                     ||");
        System.out.println("||              ~ Online Restaurant Version ~              ||");
        System.out.println("||                                                         ||");
        System.out.println("||---------------------------------------------------------||");
    }

    public static void main(String[] args) {

        Database database = new Database();

        Login.login(database);

    //     while (true) {
    //         System.out.println("Menu:");
    //         System.out.println("1. Lihat restaurant");
    //         System.out.println("2. Tambah restaurant");
    //         System.out.println("3. Hapus restaurant");
    //         System.out.println("4. Keluar");
    //         System.out.print("Pilih menu: ");
    //         int choice = scanner.nextInt();
    //         System.out.println();

    //         switch (choice) {
    //             case 1:
    //                 showRestaurants();
    //                 break;
    //             case 2:
    //                 addRestaurant();
    //                 break;
    //             case 3:
    //                 deleteRestaurant();
    //                 break;
    //             case 4:
    //                 System.out.println("Terima kasih telah menggunakan program ini.");
    //                 System.exit(0);
    //                 break;
    //             default:
    //                 System.out.println("Menu tidak valid.");
    //                 break;
    //         }

    //         System.out.println();
    //     }
    // }

    // private static void showRestaurants() {
    //     if (restaurants.size() == 0) {
    //         System.out.println("Belum ada restaurant.");
    //     } else {
    //         for (int i = 0; i < restaurants.size(); i++) {
    //             System.out.println("Restaurant " + (i + 1) + ":");
    //             System.out.println("Nama: " + restaurants.get(i).getName());
    //             System.out.println("Alamat: " + restaurants.get(i).getAddress());
    //             System.out.println();
    //         }
    //     }
    // }

    // private static void addRestaurant() {
    //     String jeda = scanner.nextLine();
    //     System.out.println("Masukkan nama restaurant: ");
    //     String nama = scanner.nextLine();
    //     System.out.println("Masukkan alamat restaurant: ");
    //     String address = scanner.nextLine();
    //     restaurants.add(new Restaurant(nama, address));
    //     System.out.println("Restaurant berhasil ditambahkan.");

        
    // }

    // private static void deleteRestaurant() {

    //     showRestaurants();

    //     if (restaurants.size() == 0) {
    //         System.out.println("Belum ada restaurant.");
    //     } else {
    //         System.out.print("Masukkan nomor restaurant yang ingin dihapus: ");
    //         int index = scanner.nextInt();
    //         if (index < 1 || index > restaurants.size()) {
    //             System.out.println("Nomor restaurant tidak valid.");
    //         } else {
    //             restaurants.remove(index - 1);
    //             System.out.println("Restaurant berhasil dihapus.");
    //         }
    //     }
    // }



    ArrayList<Menu> daftarMenu = new ArrayList<>();

    // daftarMenu = database.getDaftarMenu();

    daftarMenu.add(new Menu("Nasi Goreng", 15000));
    daftarMenu.add(new Menu("Mie Goreng", 12000));
    daftarMenu.add(new Menu("Ayam Goreng", 10000));

    Scanner scanner = new Scanner(System.in);
    System.out.print("Masukkan nama Anda: ");
    String nama = scanner.nextLine();

    System.out.print("Masukkan alamat Anda: ");
    String alamat = scanner.nextLine();


    User pelanggan = new User(nama, alamat);
    ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

    while (true) {
        System.out.println("Daftar Menu:");
        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu menu = daftarMenu.get(i);
            System.out.println((i + 1) + ". " + menu.getNama() + " (" + menu.getHarga() + ")");
        }

        System.out.print("Pilih menu yang ingin dipesan (0 untuk selesai): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline character

        if (pilihan == 0) {
            break;
        }

        Menu menu = daftarMenu.get(pilihan - 1);
        System.out.print("Masukkan jumlah pesanan: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // membersihkan newline character

        Pesanan pesanan = new Pesanan(menu, jumlah);
        daftarPesanan.add(pesanan);
    }

    System.out.println("\nPesanan:");
    for (int i = 0; i < daftarPesanan.size(); i++) {
        Pesanan pesanan = daftarPesanan.get(i);
        System.out.println(pesanan.getMenu().getNama() + " (" + pesanan.getJumlah() + ") - " + pesanan.getTotalHarga());
    }

    int totalHarga = 0;
    for (int i = 0; i < daftarPesanan.size(); i++) {
        totalHarga += daftarPesanan.get(i).getTotalHarga();
    }
    System.out.println("Total harga: " + totalHarga);

    System.out.print("Masukkan jumlah uang: ");
    int jumlahUang = scanner.nextInt();

    Pembayaran pembayaran = new Pembayaran(daftarPesanan.get(0), jumlahUang);
    System.out.println("Kembalian: " + pembayaran.getKembalian());

    System.out.println("\nTerima kasih " + pelanggan.getUsername() + " telah berkunjung ke restoran kami!");
    }    





    // Membuat objek dari kelas Database
    // Database db = new Database();

    // // Menambahkan menu-menu makanan ke dalam database
    // db.tambahMenu(new Menu("Nasi Goreng", 15000));
    // db.tambahMenu(new Menu("Mie Goreng", 12000));
    // db.tambahMenu(new Menu("Ayam Bakar", 20000));

    // // Menambahkan pelanggan-pelanggan baru ke dalam database
    // db.tambahPelanggan(new User("Budi", "08123456789"));
    // db.tambahPelanggan(new User("Cici", "087654321"));

    // // Membuat pesanan baru
    // User pelanggan = db.getDaftarPelanggan().get(0); // Mengambil data pelanggan pertama
    // Menu menu = db.getDaftarMenu().get(0); // Mengambil data menu pertama
    // Pesanan pesanan = new Pesanan(menu, 2); // Membuat pesanan baru
    // db.tambahPesanan(pesanan); // Menambahkan pesanan ke dalam database

    // // Menampilkan daftar pesanan yang sudah dibuat
    // ArrayList<Pesanan> daftarPesanan = db.getDaftarPesanan();
    // for (Pesanan p : daftarPesanan) {
    //     System.out.println("Pelanggan: " + pelanggan.getUsername());
    //     System.out.println("Menu: " + p.getMenu().getNama());
    //     System.out.println("Jumlah: " + p.getJumlah());
    //     System.out.println();
    // }
}