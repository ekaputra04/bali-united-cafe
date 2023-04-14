import java.util.*;

public class Validasi {
    public static int validasiAngka (int paramBawah, int paramAtas){
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka!");
                System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
                scanner.next();
            }
            System.out.println("Angka yang dimasukkan harus dalam rentang antara " + paramBawah + " dan " + paramAtas + ". Silakan coba lagi.");
            angka = scanner.nextInt();
        } while (angka < paramBawah || angka > paramAtas);

        return angka;
    }
}
