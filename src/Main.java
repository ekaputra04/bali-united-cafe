public class Main {
    public static void header() {
        // method ini berguna sebagai header dari setiap method yang memanggilnya
        // jika method ini dipanggil, maka otomatis tampilan terminal sebelumnya akan dibersihkan oleh method clear console
        ClearConsole.clearConsole();
        System.out.println("=============================================================");
        System.out.println("||                                                         ||");
        System.out.println("||                    BALI UNITED CAFE                     ||");
        System.out.println("||              ~ Online Restaurant Version ~              ||");
        System.out.println("||                                                         ||");
        System.out.println("||---------------------------------------------------------||");
    }

    public static void main(String[] args) {
        // method utama program
        // program akan membuat objek database, objek inilah yang akan dijadikan parameter dalam setiap method yang dilaluinya
        Database database = new Database();
        // program akan mengambil data dari FileMenu.txt
        EditFileMenu.bacaFileMenu(database);
        // program akan mengambil data dari FileResaurant.txt
        EditFileRestaurant.bacaFileRestaurant(database);
        // program berlanjut ke sistem login user
        Login.login(database);
    }
}