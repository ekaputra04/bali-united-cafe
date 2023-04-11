public class Pesanan {
    private Menu menu;
    private int jumlah;

    public Pesanan(Menu menu, int jumlah) {
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getTotalHarga(int index_harga) {
        return menu.getHarga(index_harga) * jumlah;
    }
}
