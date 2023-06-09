import java.util.ArrayList;

public class Pembayaran {
    private ArrayList<Pesanan> pesanans = new ArrayList<Pesanan>();
    private int totalHarga;
    private int jumlahUang;

    public Pembayaran(ArrayList<Pesanan> pesanans, int totalHarga, int jumlahUang) {
        this.pesanans = pesanans;
        this.totalHarga = totalHarga;
        this.jumlahUang = jumlahUang;
    }

    public ArrayList<Pesanan> getPesanans() {
        return pesanans;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public int getJumlahUang() {
        return jumlahUang;
    }

    public int getKembalian() {
        return jumlahUang - totalHarga;
    }
}
