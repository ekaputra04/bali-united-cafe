import java.io.*;

public class EditFileRestaurant {

    public static void bacaFileRestaurant(Database database) {
        database.hapusRestaurant();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/FileRestaurant.txt"));
    
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                String id = data[0];
                String nama = data[1];
                String alamat = data[2];

                Restaurant restaurants = new Restaurant(id, nama, alamat);
                database.tambahRestaurant(restaurants);

                line = reader.readLine();
            }
    
            reader.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file FileRestaurant.txt");
            e.printStackTrace();
        }
    }

    public static void isiFileRestaurant(String id, String nama, String alamat) {

        // Menyimpan data restoran ke dalam file FileREstaurant.txt
        try {
            FileWriter writer = new FileWriter("src/FileRestaurant.txt", true);
            writer.write(id + "," + nama + "," + alamat + "\n");
            writer.close();
            System.out.println("Data restoran berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data restoran.");
            e.printStackTrace();
        }
    }

    public static void hapusFileRestaurant(int indexToDelete) {
        String fileName = "src/FileRestaurant.txt";

        try {
            // membaca file
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // menulis file sementara
            File tempFile = new File("temp.txt");
            FileWriter writer = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String line;
            int currentIndex = 1;

            // membaca setiap baris pada file
            while ((line = bufferedReader.readLine()) != null) {
                // jika index baris tidak sama dengan index yang akan dihapus, maka tulis pada file sementara
                if (currentIndex != indexToDelete) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
                currentIndex++;
            }

            // menutup bufferedReader dan bufferedWriter
            bufferedReader.close();
            bufferedWriter.close();

            // menghapus file asli
            if (inputFile.delete()) {
                // mengubah nama file sementara menjadi nama file asli
                if (tempFile.renameTo(inputFile)) {
                    System.out.println("Data pada index " + indexToDelete + " berhasil dihapus");
                } else {
                    System.out.println("Gagal mengubah nama file");
                }
            } else {
                System.out.println("Gagal menghapus file");
            }

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
