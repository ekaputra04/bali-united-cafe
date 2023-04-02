public class Pembayaran {
    private Pesanan pesanan;
    private int jumlahUang;

    public Pembayaran(Pesanan pesanan, int jumlahUang) {
        this.pesanan = pesanan;
        this.jumlahUang = jumlahUang;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public int getJumlahUang() {
        return jumlahUang;
    }

    public int getKembalian() {
        return jumlahUang - pesanan.getTotalHarga();
    }
}
