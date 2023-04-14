import java.util.*;

public class Validasi {
    public static int validasiAngka (int paramBawah, int paramAtas){
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                System.out.print("Masukkan angka antara " + paramBawah + " dan " + paramAtas + ": ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < paramBawah || angka > paramAtas);

        return angka;
    }

    public static int validasiAngkaLebih0 (){
        Scanner scanner = new Scanner(System.in);
        int angka;

        do {
            System.out.print("Masukkan angka : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka! Silakan coba lagi.");
                System.out.print("Masukkan angka : ");
                scanner.next();
            }
            angka = scanner.nextInt();
        } while (angka < 0);

        return angka;
    }
}
