import java.util.*;

public class Main {
    Scanner userInput = new Scanner(System.in);

    public static void header() {
        ClearConsole.clearConsole();
        System.out.println("=============================================================");
        System.out.println("||                                                         ||");
        System.out.println("||                    BALI UNITED CAFE                     ||");
        System.out.println("||                                                         ||");
        System.out.println("||---------------------------------------------------------||");
    }

    public static void main(String[] args) {
        
        Login.login();
        
    }    
}