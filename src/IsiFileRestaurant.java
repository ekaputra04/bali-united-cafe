import java.io.FileWriter;
import java.io.IOException;

public class IsiFileRestaurant {
    public static void isiFileRestaurant(String nama, String alamat) {

        // Menyimpan data restoran ke dalam file teks
        try {
            FileWriter writer = new FileWriter("src/FileRestaurant.txt", true);
            writer.write(nama + "," + alamat + "\n");
            writer.close();
            System.out.println("Data restoran berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data restoran.");
            e.printStackTrace();
        }
    }
}
