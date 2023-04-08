import java.util.*;

public class MenuAdmin {

    public static void adminRestaurant(int menuAdmin) {
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        Scanner input = new Scanner(System.in);

        if (menuAdmin == 1) {
            Main.header();
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                   MENU ADMIN                  ||");
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                Lihat Restaurant               ||");
            System.out.println("===================================================");
            if (restaurants.size() == 0) {
                System.out.println("Belum ada restaurant.");
            } else {
                for (int i = 0; i < restaurants.size(); i++) {
                    System.out.println("Restaurant " + (i + 1) + ":");
                    System.out.println("Name: " + restaurants.get(i).getName());
                    System.out.println("Address: " + restaurants.get(i).getAddress());
                    System.out.println();
                }
            }
        } else if (menuAdmin == 2) {
            Main.header();
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                   MENU ADMIN                  ||");
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                Tambah Restaurant              ||");
            System.out.println("===================================================");
            System.out.print("Masukkan nama restaurant: ");
            String name = input.next();
            System.out.print("Masukkan alamat restaurant: ");
            String address = input.next();
            restaurants.add(new Restaurant(name, address));
            System.out.println("Restaurant berhasil ditambahkan.");
        } else if (menuAdmin == 3) {
            Main.header();
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                   MENU ADMIN                  ||");
            System.out.println("||-----------------------------------------------||");
            System.out.println("||                Hapus Restaurant               ||");
            System.out.println("===================================================");
            if (restaurants.size() == 0) {
                System.out.println("Belum ada restaurant.");
            } else {
                System.out.print("Masukkan nomor restaurant yang ingin dihapus: ");
                int index = input.nextInt();
                if (index < 1 || index > restaurants.size()) {
                    System.out.println("Nomor restaurant tidak valid.");
                } else {
                    restaurants.remove(index - 1);
                    System.out.println("Restaurant berhasil dihapus.");
                }
            }
        }
    }
}
