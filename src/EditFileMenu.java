import java.io.*;
import java.util.Scanner;

public class EditFileMenu {
    public void bacaFileMenu(Database database) {
        try {
            File file = new File("src/FileMenu.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String namaMenu = data[0];
                int hargaMenu = Integer.parseInt(data[1]);

                Menu menu = new Menu(namaMenu, hargaMenu);
                database.tambahMenu(menu);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan.");
        }
    }

    public void isiFileMenu(String namaMenu, int hargaMenu) {
        // Menyimpan data restoran ke dalam file FileMenu.txt
        try {
            FileWriter writer = new FileWriter("src/FileMenu.txt", true);
            writer.write(namaMenu + "," + hargaMenu + "\n");
            writer.close();
            System.out.println("Data menu berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data menu.");
            e.printStackTrace();
        }
    }

    public void hapusFileMenu(int indexToDelete) {
        String fileName = "src/FileMenu.txt";

        try {
            // membaca file
            File inputFile = new File(fileName);
            FileReader reader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // menulis file sementara
            File tempFile = new File("temp2.txt");
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
