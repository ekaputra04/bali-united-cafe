public class Main {
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
        EditFileMenu.bacaFileMenu(database);
        EditFileRestaurant.bacaFileRestaurant(database);
        Login.login(database);
    }
}