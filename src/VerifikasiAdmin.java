import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerifikasiAdmin {
    private String fileName;

    public VerifikasiAdmin(String fileName) {
        this.fileName = fileName;
    }

    public boolean verifyAdmin(String username, String password) {
        boolean isAdmin = false;
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] adminData = line.split(",");
                if (adminData[0].equals(username) && adminData[1].equals(password)) {
                    isAdmin = true;
                    break;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return isAdmin;
    }
}
