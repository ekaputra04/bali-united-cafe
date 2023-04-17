import java.util.ArrayList;

public class Database {

    private ArrayList<Restaurant> daftarRestaurant = new ArrayList<Restaurant>();
    private ArrayList<Menu> daftarMenu = new ArrayList<Menu>();
    private ArrayList<User> daftarPelanggan = new ArrayList<User>();
    private ArrayList<User> pelangganBeli = new ArrayList<User>();
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
    private ArrayList<Pesanan> daftarPesananTotal = new ArrayList<Pesanan>();
    private ArrayList<Pembayaran> daftarPembayaran = new ArrayList<Pembayaran>();

    public void tambahRestaurant(Restaurant restaurant) {
        daftarRestaurant.add(restaurant);
    }

    public void hapusRestaurant(){
        daftarRestaurant.clear();
    }

    public ArrayList<Restaurant> getDaftarRestaurant() {
        return daftarRestaurant;
    }

    public void tambahMenu(Menu menu) {
        daftarMenu.add(menu);
    }

    public void hapusMenu() {
        daftarMenu.clear();;
    }

    public ArrayList<Menu> getDaftarMenu() {
        return daftarMenu;
    }

    public void tambahPelanggan(User pelanggan) {
        daftarPelanggan.add(pelanggan);
    }

    public void hapusPelanggan() {
        daftarPelanggan.clear();
    }

    public ArrayList<User> getDaftarPelanggan() {
        return daftarPelanggan;
    }    

    public void tambahPelangganBeli(User pelanggan) {
        pelangganBeli.add(pelanggan);
    }

    public void hapusPelangganBeli() {
        pelangganBeli.clear();
    }

    public ArrayList<User> getDaftarPelangganBeli() {
        return pelangganBeli;
    } 

    public void tambahPesanan(Pesanan pesanan) {
        daftarPesanan.add(pesanan);
    }

    public void hapusPesanan() {
        daftarPesanan.clear();
    }

    public ArrayList<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public void tambahPesananTotal(Pesanan pesanan) {
        daftarPesananTotal.add(pesanan);
    }

    public void hapusPesananTotal() {
        daftarPesananTotal.clear();
    }

    public ArrayList<Pesanan> getDaftarPesananTotal() {
        return daftarPesananTotal;
    }

    public void tambahPembayaran(Pembayaran pembayaran) {
        daftarPembayaran.add(pembayaran);
    }

    public void hapusPembayaran() {
        daftarPembayaran.clear();
    }

    public ArrayList<Pembayaran> getDaftarPembayaran() {
        return daftarPembayaran;
    }
}
