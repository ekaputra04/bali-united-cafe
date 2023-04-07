import java.util.*;

public class Login {

    public static void header() {
        ClearConsole.clearConsole();
        System.out.println("===================================================");
        System.out.println("||                                               ||");
        System.out.println("||               BALI UNITED CAFE                ||");
        System.out.println("||                                               ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void login() {
        Scanner userInput = new Scanner(System.in);
        int ruleUser;
        ClearConsole.clearConsole();
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
            loginAdmin();
        } else if (ruleUser == 2) {
            loginCostumer();
        }
    }

    public static void verifikasiAdmin() {
        Scanner userInput = new Scanner(System.in);
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                VERIFIKASI ADMIN               ||");
        System.out.println("||-----------------------------------------------||");
        System.out.print("Masukkan username: ");
        String username = userInput.nextLine();
        System.out.print("Masukkan password: ");
        String password = userInput.nextLine();
        // String namaAdmin = Admin.getNamaAdmin();
        // int passwordAdmin = Admin.getPasswordAdmin();

        if (username.equals("eka") && password.equals("123")) {
            System.out.println("Anda berhasil masuk sebagai admin.");
        } else {
            System.out.println("Username atau password salah. Silakan coba lagi.");
        }
        userInput.nextLine();
    }

    public static void loginAdmin() {
        verifikasiAdmin();
        Scanner userInput = new Scanner(System.in);
        int menuAdmin;
        header();
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

        if (menuAdmin == 1) {
            adminLihatRestaurant();
        } else if (menuAdmin == 2) {
            adminTambahRestaurant();
        } else if (menuAdmin == 3) {
            adminHapusRestaurant();
        } else if (menuAdmin == 4) {
            login();
        }
    }

    public static void loginCostumer() {
        Scanner userInput = new Scanner(System.in);
        int menuCostumer;
        header();
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
            costumerLihatRestaurant();
        } else if (menuCostumer == 2) {
            costumerBuatPesanan();
        } else if (menuCostumer == 3) {
            costumerLihatPesanan();
        } else if (menuCostumer == 4) {
            login();
        }
    }

    public static void adminLihatRestaurant() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                   MENU ADMIN                  ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                Lihat Restaurant               ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void adminTambahRestaurant() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                   MENU ADMIN                  ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                Tambah Restaurant              ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void adminHapusRestaurant() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                   MENU ADMIN                  ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                Hapus Restaurant               ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void costumerLihatRestaurant() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                 MENU COSTUMER                 ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                Lihat Restaurant               ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void costumerBuatPesanan() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                 MENU COSTUMER                 ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                  Buat Pesanan                 ||");
        System.out.println("||-----------------------------------------------||");
    }

    public static void costumerLihatPesanan() {
        header();
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                 MENU COSTUMER                 ||");
        System.out.println("||-----------------------------------------------||");
        System.out.println("||                 Lihat Pesanan                 ||");
        System.out.println("||-----------------------------------------------||");
    }
}
