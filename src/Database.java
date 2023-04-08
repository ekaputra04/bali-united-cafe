import java.util.*;

public class Database {
    
    private ArrayList<Menu> daftarMenu = new ArrayList<Menu>();
    private ArrayList<User> daftarPelanggan = new ArrayList<User>();
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
    private ArrayList<Pembayaran> daftarPembayaran = new ArrayList<Pembayaran>();

    public void tambahMenu(Menu menu) {
        daftarMenu.add(menu);
    }

    public ArrayList<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    public void tambahPelanggan(User pelanggan) {
        daftarPelanggan.add(pelanggan);
    }

    public ArrayList<User> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public void tambahPesanan(Pesanan pesanan) {
        daftarPesanan.add(pesanan);
    }

    public ArrayList<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public void tambahPembayaran(Pembayaran pembayaran) {
        daftarPembayaran.add(pembayaran);
    }

    public ArrayList<Pembayaran> getDaftarPembayaran() {
        return daftarPembayaran;
    }
}
