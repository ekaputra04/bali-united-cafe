import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Login {

    public static void login(Database database) {
        int ruleUser;
        System.out.println("=============================================================");
        System.out.println("||                                                         ||");
        System.out.println("||                       WELLCOME TO                       ||");
        System.out.println("||                    BALI UNITED CAFE                     ||");
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
            loginCostumer(database);
        }
    }

    public static void verifikasiAdmin(Database database) {
        Scanner userInput = new Scanner(System.in);
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                     VERIFIKASI ADMIN                    ||");
        System.out.println("=============================================================");

        // Input username dan password
        System.out.print("Masukkan Username: ");
        String username = userInput.nextLine();
        System.out.print("Masukkan Password: ");
        String password = userInput.nextLine();

        // Memeriksa apakah input username dan password cocok dengan data admin

        if (username.equals("admin") && password.equals("admin123")){
            System.out.println("Login Berhasil, Silahkan Lanjutkan Program");
            loginAdmin(database);
        } else {
            System.out.println("Login Gagal, Silahkan Kembali Ke Menu Utama");
            login(database);
        }
    }

    public static void loginAdmin(Database database) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

        while(true){
            int menuAdmin;
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                         MENU ADMIN                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("|| Silahkan Pilih Menu Program:                            ||");
            System.out.println("|| [1] Lihat Restaurant                                    ||");
            System.out.println("|| [2] Tambah Restaurant                                   ||");
            System.out.println("|| [3] Hapus Restaurant                                    ||");
            System.out.println("|| [4] Kembali ke Login                                    ||");
            System.out.println("=============================================================");
            System.out.println("Masukkan pilihan Anda : ");
            menuAdmin = Validasi.validasiAngka(1, 4);

            if (menuAdmin == 1){
                MenuAdmin.adminLihatRestaurant(database);
            } else if (menuAdmin == 2) {
                MenuAdmin.adminTambahRestaurant(database);
            } else if (menuAdmin == 3) {
                MenuAdmin.adminHapusRestaurant(database);
            } else {
                Login.login(database);
            }

            // else if (menuAdmin == 4) {
            //     login(database);
            // } else if (menuAdmin == )
            // else {
            //     MenuAdmin.adminRestaurant(menuAdmin, database);
            // }
        }
    }

    public static void loginCostumer(Database database) {
        int menuCostumer;
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                       MENU COSTUMER                     ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| Silahkan Pilih Menu Program:                            ||");
        System.out.println("|| [1] Lihat Restaurant                                    ||");
        System.out.println("|| [2] Buat Pesanan                                        ||");
        System.out.println("|| [3] Lihat Pesanan                                       ||");
        System.out.println("|| [4] Kembali ke Login                                    ||");
        System.out.println("=============================================================");
        System.out.println("Masukkan pilihan Anda : ");
        menuCostumer = Validasi.validasiAngka(1, 4);

        if (menuCostumer == 4) {
            login(database);
        } else {
            MenuCostumer.costumerRestaurant(menuCostumer, database);
        }
    }
}
