import java.util.*;

public class MenuCostumer {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    private static ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    


    // public static void customerLihatRestaurant(Database database) {
    //     restaurants = database.getDaftarRestaurant();
    //     Main.header();
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                      MENU COSTUMER                      ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                     Lihat Restaurant                    ||");
    //     System.out.println("=============================================================");

    // }

    // public static void customerBuatPesanan(Database database) {
        
    // }

    // public static void customerLihatPesanan(Database database) {
        
    // }

    public static void costumerRestaurant(int menuCostumer, Database database) {
        String nama;
        System.out.print("Masukkan Nama Anda : ");
        nama = input.nextLine();
        input.nextLine();
        System.out.println("Selamat datang " + nama);
        User pelanggan = new User(nama, null);
        
        database.tambahPelanggan(pelanggan);

        if (menuCostumer == 1){
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                     Lihat Restaurant                    ||");
            System.out.println("=============================================================");
            restaurants = database.getDaftarRestaurant();
            if (restaurants.isEmpty()) {
                System.out.println("Belum ada restaurant.");
            } else {
                for (int i = 0; i < restaurants.size(); i++) {
                    System.out.println("Restaurant " + (i + 1) + ":");
                    System.out.println("Nama: " + restaurants.get(i).getName());
                    System.out.println("Alamat: " + restaurants.get(i).getAddress());
                    System.out.println();
                }
            }
            Login.loginCostumer(database);
        } else if (menuCostumer == 2) {
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                       Buat Pesanan                      ||");
            System.out.println("=============================================================");
            
            ArrayList<Menu> daftarMenu = new ArrayList<>();

            // daftarMenu = database.getDaftarMenu();
            
            daftarMenu.add(new Menu("Nasi Goreng", 15000));
            daftarMenu.add(new Menu("Mie Goreng", 12000));
            daftarMenu.add(new Menu("Ayam Goreng", 10000));


            
            while (true) {
                System.out.println("Daftar Menu:");
                for (int i = 0; i < daftarMenu.size(); i++) {
                    Menu menu = daftarMenu.get(i);
                    System.out.println((i + 1) + ". " + menu.getNama() + " (" + menu.getHarga() + ")");
                }

                System.out.print("Pilih menu yang ingin dipesan (0 untuk selesai): ");
                int pilihan = input.nextInt();
                input.nextLine(); // membersihkan newline character

                if (pilihan == 0) {
                    break;
                }

                Menu menu = daftarMenu.get(pilihan - 1);
                System.out.print("Masukkan jumlah pesanan: ");
                int jumlah = input.nextInt();
                input.nextLine(); // membersihkan newline character

                Pesanan pesanan = new Pesanan(menu, jumlah);
                daftarPesanan.add(pesanan);
            }

        } else if (menuCostumer == 3){
            Main.header();
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      MENU COSTUMER                      ||");
            System.out.println("||---------------------------------------------------------||");
            System.out.println("||                      Lihat Pesanan                      ||");
            System.out.println("=============================================================");
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
            int jumlahUang = input.nextInt();
        
            Pembayaran pembayaran = new Pembayaran(daftarPesanan.get(0), jumlahUang);
            System.out.println("Kembalian: " + pembayaran.getKembalian());
        
            System.out.println("\nTerima kasih " + pelanggan.getUsername() + " telah berkunjung ke restoran kami!");
        }       
    }
}