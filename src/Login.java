import java.util.*;

public class Login {

    private static Scanner input = new Scanner(System.in);
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void login(Database database) {
        int ruleUser;
        System.out.println("=============================================================");
        System.out.println("||                                                         ||");
        System.out.println("||                       WELLCOME TO                       ||");
        System.out.println("||                    BALI UNITED CAFE                     ||");
        System.out.println("||              ~ Online Restaurant Version ~              ||");
        System.out.println("||                                                         ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||            'Connecting People Through Sport'            ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| > Senin - Minggu                                        ||");
        System.out.println("|| > 10.00 s/d 22.00 WITA                                  ||");
        System.out.println("|| > Stadion Kapten I Wayan Dipta, Gianyar, Bali           ||");
        System.out.println("|| > 0888 01888888                                         ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| Login sebagai:                                          ||");
        System.out.println("|| [1] Admin                                               ||");
        System.out.println("|| [2] Costumer                                            ||");
        System.out.println("=============================================================");
        System.out.println("Masukkan pilihan Anda : ");
        ruleUser = Validasi.validasiAngka(1, 2);

        if (ruleUser == 1) {
            verifikasiAdmin(database);
        } else if (ruleUser == 2) {
            verifikasiCostumer(database);
        }
    }

    public static void verifikasiAdmin(Database database) {
        VerifikasiAdmin verifikasiAdmin = new VerifikasiAdmin("src/FileAdmin.txt");
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     VERIFIKASI ADMIN                    ||");
        System.out.println("=============================================================");

        // Input username dan password
        System.out.print("Masukkan Username: ");
        String username = input.nextLine();
        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        // Memeriksa apakah input username dan password cocok dengan data admin
        if (verifikasiAdmin.verifyAdmin(username, password)) {
            System.out.println(red + "Verifikasi berhasil. Anda adalah admin." + reset);
            System.out.println("-------------------------------------------------------------");
            Login.loginAdmin(database);
        } else {
            System.out.println(red + "Username atau password salah. Anda bukan admin." + reset);
            System.out.println("-------------------------------------------------------------");
            input.nextLine();
            ClearConsole.clearConsole();
            Login.login(database);
        }
    }

    public static void loginAdmin(Database database) {
        while (true) {
            int menuAdmin;
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                         MENU ADMIN                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("|| Silahkan Pilih Menu Program:                            ||");
            System.out.println("|| [1] Lihat Daftar Restaurant                             ||");
            System.out.println("|| [2] Tambah Daftar Restaurant                            ||");
            System.out.println("|| [3] Hapus Daftar Restaurant                             ||");
            System.out.println("|| [4] Lihat Menu Restaurant                               ||");
            System.out.println("|| [5] Tambah Menu Restaurant                              ||");
            System.out.println("|| [6] Hapus Menu Restaurant                               ||");
            System.out.println("|| [7] Kembali ke Login                                    ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("|| [8] Keluar Program                                      ||");
            System.out.println("=============================================================");
            System.out.println("Masukkan pilihan Anda : ");
            menuAdmin = Validasi.validasiAngka(1, 8);

            if (menuAdmin == 1) {
                MenuAdmin.adminLihatRestaurant(database);
            } else if (menuAdmin == 2) {
                MenuAdmin.adminTambahRestaurant(database);
            } else if (menuAdmin == 3) {
                MenuAdmin.adminHapusRestaurant(database);
            } else if (menuAdmin == 4) {
                MenuAdmin.adminLihatMenuRestaurant(database);
            } else if (menuAdmin == 5) {
                MenuAdmin.adminTambahMenuRestaurant(database);
            } else if (menuAdmin == 6) {
                MenuAdmin.adminHapusMenuRestaurant(database);
            } else if (menuAdmin == 7) {
                ClearConsole.clearConsole();
                Login.login(database);
            } else {
                System.exit(0);
            }
        }
    }

    public static void verifikasiCostumer(Database database) {
        String nama;
        String alamat;
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                   VERIFIKASI COSTUMER                   ||");
        System.out.println("=============================================================");
        System.out.print("Masukkan Nama Anda : ");
        nama = input.nextLine();
        System.out.print("Masukkan Alamat Anda : ");
        alamat = input.nextLine();
        System.out.println(red + "Selamat datang " + nama + reset);
        System.out.println("-------------------------------------------------------------");
        User pelanggan = new User(nama, alamat);
        database.tambahPelanggan(pelanggan);
        Login.loginCostumer(database);
    }

    public static void loginCostumer(Database database) {
        int menuCostumer;
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                       MENU COSTUMER                     ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| Silahkan Pilih Menu Program:                            ||");
        System.out.println("|| [1] Lihat Restaurant                                    ||");
        System.out.println("|| [2] Lihat Menu Restaurant & Buat Pesanan                ||");
        System.out.println("|| [3] Lihat Pesanan                                       ||");
        System.out.println("|| [4] Kembali ke Login                                    ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| [5] Keluar Program                                      ||");
        System.out.println("=============================================================");
        System.out.println("Masukkan pilihan Anda : ");
        menuCostumer = Validasi.validasiAngka(1, 5);

        if (menuCostumer == 1) {
            MenuCostumer.customerLihatRestaurant(database);
        } else if (menuCostumer == 2) {
            MenuCostumer.customerBuatPesanan(database);
        } else if (menuCostumer == 3) {
            MenuCostumer.customerLihatPesanan(database);
        } else if (menuCostumer == 4) {
            ClearConsole.clearConsole();
            login(database);
        } else if (menuCostumer == 5) {
            System.exit(0);
        }
    }
}
