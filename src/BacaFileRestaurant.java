import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BacaFileRestaurant {

    public static void bacaFileRestaurant() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FileRestaurant.txt"));
    
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                String nama = data[0];
                String alamat = data[1];
    
                System.out.println("Nama restoran: " + nama);
                System.out.println("Alamat restoran: " + alamat);
                System.out.println("-------------------------------------------------------------");
    
                line = reader.readLine();
            }
    
            reader.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file daftar_restoran.txt");
            e.printStackTrace();
        }
    }
}
