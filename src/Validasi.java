import java.util.*;

public class Validasi {
    public static int validasiAngka (int paramBawah, int paramAtas){
        Scanner inputAngka = new Scanner(System.in);

        System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
        while (!inputAngka.hasNextInt()) {
            System.out.println("Input yang dimasukkan bukan angka. Silakan coba lagi.");
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            inputAngka.nextLine();
        }
        int angka = inputAngka.nextInt();

        while (angka < paramBawah || angka > paramAtas) {
            System.out.println("Angka yang dimasukkan harus dalam rentang antara " + paramBawah + " dan " + paramAtas + ". Silakan coba lagi.");
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            angka = inputAngka.nextInt();
        }
        return angka;
    }
}