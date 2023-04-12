import java.util.*;

public class MenuCostumer {
    public static void costumerRestaurant(int menuCostumer, Database database) {
        Scanner input = new Scanner(System.in);

        String nama;
        System.out.print("Masukkan Nama Anda : ");
        nama = input.nextLine();
        User pelanggan = new User(nama, null);
        
        database.tambahPelanggan(pelanggan);

        if (menuCostumer == 1){
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                     Lihat Restaurant                    ||");
            System.out.println("=============================================================");

        } else if (menuCostumer == 2) {
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                       Buat Pesanan                      ||");
            System.out.println("=============================================================");

        } else if (menuCostumer == 3){
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      Lihat Pesanan                      ||");
            System.out.println("=============================================================");

        }
    }
}
