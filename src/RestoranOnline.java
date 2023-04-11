import java.util.*;

public class RestoranOnline {
    private Database database;

    public RestoranOnline(Database database) {
        this.database = database;
    }

    public void tampilkanMenu() {
        ArrayList<Menu> daftarMenu = database.getDaftarMenu();
        System.out.println("Daftar Menu:");
        for (int i = 0; i < daftarMenu.size(); i++) {
            Menu menu = daftarMenu.get(i);
            System.out.println((i+1) + ". " + menu.getNama() + " - Rp" + menu.getHarga());
        }
    }

    public void terimaPesanan(User pelanggan, Pesanan pesanan) {
        database.tambahPelanggan(pelanggan);
        database.tambahPesanan(pesanan);
        System.out.println("Pesanan telah diterima.");
    }

    public void terimaPembayaran(Pembayaran pembayaran) {
        database.tambahPembayaran(pembayaran);
        System.out.println("Pembayaran telah diterima.");
    }

    public void tampilkanDaftarPesanan() {
        ArrayList<Pesanan> daftarPesanan = database.getDaftarPesanan();
        System.out.println("Daftar Pesanan:");
        for (int i = 0; i < daftarPesanan.size(); i++) {
            Pesanan pesanan = daftarPesanan.get(i);
            System.out.println((i+1) + ". " + pesanan.getMenu().getNama() + " x" + pesanan.getJumlah() + " - Rp" + pesanan.getTotalHarga());
        }
    }

    public void tampilkanDaftarPelanggan() {
        ArrayList<User> daftarPelanggan = database.getDaftarPelanggan();
        System.out.println("Daftar Pelanggan:");
        for (int i = 0; i < daftarPelanggan.size(); i++) {
            User pelanggan = daftarPelanggan.get(i);
            System.out.println((i+1) + ". " + pelanggan.getUsername() + " - " + pelanggan.getAlamat());
        }
    }

    public void tampilkanDaftarPembayaran() {
        ArrayList<Pembayaran> daftarPembayaran = database.getDaftarPembayaran();
        System.out.println("Daftar Pembayaran:");
        for (int i = 0; i < daftarPembayaran.size(); i++) {
            Pembayaran pembayaran = daftarPembayaran.get(i);
            System.out.println((i+1) + ". " + pembayaran.getPesanan().getMenu().getNama() + " x" + pembayaran.getPesanan().getJumlah() + " - Rp" + pembayaran.getPesanan().getTotalHarga() + " - Bayar Rp" + pembayaran.getJumlahUang() + " - Kembalian Rp" + pembayaran.getKembalian());
        }
    }
}
