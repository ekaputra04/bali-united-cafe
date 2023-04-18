import java.io.*;

public class EditFileRestaurant {
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void bacaFileRestaurant(Database database) {
        // method ini digunakan untuk membaca data dari FileRestaurant.txt kemudian menambahkannya dalam ArrayList daftarRestaurant dalam objek database
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
            System.out.println(red + "Terjadi kesalahan saat membaca file FileRestaurant.txt" + reset);
            System.out.println("-------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    public static void isiFileRestaurant(String id, String nama, String alamat) {
        // method isi berguna untuk menyimpan data restoran baru ke dalam file FileREstaurant.txt
        try {
            FileWriter writer = new FileWriter("src/FileRestaurant.txt", true);
            writer.write(id + "," + nama + "," + alamat + "\n");
            writer.close();
            System.out.println(red + "Data restoran berhasil disimpan." + reset);
            System.out.println("-------------------------------------------------------------");
        } catch (IOException e) {
            System.out.println(red + "Terjadi kesalahan saat menyimpan data restoran." + reset);
            System.out.println("-------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    public static void hapusFileRestaurant(int indexToDelete) {
        // method ini digunakan untuk menghapus data salah satu restaurant dalam FileRestaurant.txt
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
                    System.out.println(red + "Data pada index " + indexToDelete + " berhasil dihapus" + reset);
                    System.out.println("-------------------------------------------------------------");
                } else {
                    System.out.println(red + "Gagal mengubah nama file" + reset);
                    System.out.println("-------------------------------------------------------------");
                }
            } else {
                System.out.println(red + "Gagal menghapus file" + reset);
                System.out.println("-------------------------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println(red + "Terjadi kesalahan: " + e.getMessage() + reset);
            System.out.println("-------------------------------------------------------------");
        }
    }
}
