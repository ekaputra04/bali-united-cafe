import java.io.*;
import java.util.Scanner;

public class EditFileMenu {
    // ANSI escape code untuk tulisan merah
    private static String red = "\033[31m";
    // ANSI escape code untuk mereset warna
    private static String reset = "\033[0m";

    public static void bacaFileMenu(Database database) {
        database.hapusMenu();
        try {
            File file = new File("src/FileMenu.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String idMenu = data[0];
                String namaMenu = data[1];
                int hargaMenu = Integer.parseInt(data[2]);

                Menu menu = new Menu(idMenu, namaMenu, hargaMenu);
                database.tambahMenu(menu);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(red + "File tidak ditemukan." + reset);
            System.out.println("-------------------------------------------------------------");
        }
    }

    public static void isiFileMenu(String idMenu, String namaMenu, int hargaMenu) {
        // Menyimpan data restoran ke dalam file FileMenu.txt
        try {
            FileWriter writer = new FileWriter("src/FileMenu.txt", true);
            writer.write(idMenu + "," + namaMenu + "," + hargaMenu + "\n");
            writer.close();
            System.out.println(red + "Data menu berhasil disimpan." + reset);
            System.out.println("-------------------------------------------------------------");
        } catch (IOException e) {
            System.out.println(red + "Terjadi kesalahan saat menyimpan data menu." + reset);
            System.out.println("-------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    public static void hapusFileMenu(int indexToDelete) {
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
                    System.out.println(red + "Data menu pada index " + indexToDelete + " berhasil dihapus" + reset);
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
