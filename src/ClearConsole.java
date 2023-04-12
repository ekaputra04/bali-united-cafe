import java.util.*;

public class ClearConsole {
    public static void clearConsole(){
        Scanner input = new Scanner(System.in);
        input.nextLine();
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat membersihkan konsol.");
        }
        // input.close();
    }
}
