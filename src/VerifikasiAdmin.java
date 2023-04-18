import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerifikasiAdmin {
    // class dan method untuk melakukan perbandingan username dan password yang diinputkan user dengan data pada FileAdmin.txt
    // ketika username dan password ada yang sesuai dengan data pada FileAdmin.txt, maka akan mengembalikan nilai true
    // jika ingin menambahkan admin baru, bisa langsung menambahkannya pada FileAdmin.txt
    // format penambahkan admin baru : username,password
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
