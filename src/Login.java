import java.util.*;

public class Login {

    public static void login() {

        int ruleUser;
        System.out.println("===================================================");
        System.out.println("||                                               ||");
        System.out.println("||                  WELLCOME TO                  ||");
        System.out.println("||               BALI UNITED CAFE                ||");
        System.out.println("||                                               ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||       'Connecting People Through Sport'       ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("|| > Senin - Minggu                              ||");
        System.out.println("|| > 10.00 s/d 22.00 WITA                        ||");
        System.out.println("|| > Stadion Kapten I Wayan Dipta, Gianyar, Bali ||");
        System.out.println("|| > 0888 01888888                               ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("|| Login sebagai:                                ||");
        System.out.println("|| [1] Admin                                     ||");
        System.out.println("|| [2] Costumer                                  ||");
        System.out.println("===================================================");
        System.out.println("Masukkan pilihan Anda : ");
        ruleUser = Validasi.validasiAngka(1, 2);

        if (ruleUser == 1) {
            verifikasiAdmin();
        } else if (ruleUser == 2) {
            loginCostumer();
        }
    }

    public static void verifikasiAdmin() {
        Scanner userInput = new Scanner(System.in);
        UserDatabase database = new UserDatabase();
        Main.header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                VERIFIKASI ADMIN               ||");
        System.out.println("===================================================");
        
        // Input username dan password
        System.out.print("Masukkan Username: ");
        String username = userInput.nextLine();
        System.out.print("Masukkan Password: ");
        String password = userInput.nextLine();
        
        // Memeriksa apakah input username dan password cocok dengan data admin atau customer pada database
        User user = database.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            if (user.getRole().equals("admin")) {
                System.out.println("Selamat datang, Admin!");
                ClearConsole.clearConsole();
                loginAdmin();
            } else {
                System.out.println("Selamat datang, Customer!");
                System.out.println("Alamat: " + user.getAlamat());
                ClearConsole.clearConsole();
                loginCostumer();
            }
        } else {
            System.out.println("Username atau password salah!");
            ClearConsole.clearConsole();
            login();
        }
    }

    public static void loginAdmin() {
        int menuAdmin;
        // Main.header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                   MENU ADMIN                  ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("|| Silahkan Pilih Menu Program:                  ||");
        System.out.println("|| [1] Lihat Restaurant                          ||");
        System.out.println("|| [2] Tambah Restaurant                         ||");
        System.out.println("|| [3] Hapus Restaurant                          ||");
        System.out.println("|| [4] Kembali ke Login                          ||");
        System.out.println("===================================================");
        System.out.println("Masukkan pilihan Anda : ");
        menuAdmin = Validasi.validasiAngka(1, 4);

        MenuAdmin.adminRestaurant(menuAdmin);
    }

    public static void loginCostumer() {

        int menuCostumer;
        Main.header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                  MENU COSTUMER                ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("|| Silahkan Pilih Menu Program:                  ||");
        System.out.println("|| [1] Lihat Restaurant                          ||");
        System.out.println("|| [2] Buat Pesanan                              ||");
        System.out.println("|| [3] Lihat Pesanan                             ||");
        System.out.println("|| [4] Kembali ke Login                          ||");
        System.out.println("===================================================");
        System.out.println("Masukkan pilihan Anda : ");
        menuCostumer = Validasi.validasiAngka(1, 4);

        if (menuCostumer == 1) {
            MenuCostumer.costumerLihatRestaurant();
        } else if (menuCostumer == 2) {
            MenuCostumer.costumerBuatPesanan();
        } else if (menuCostumer == 3) {
            MenuCostumer.costumerLihatPesanan();
        } else if (menuCostumer == 4) {
            login();
        }
    }
}
