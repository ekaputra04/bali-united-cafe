public class Menu {
    private String idMenu;
    private String nama;
    private int harga;

    public Menu(String idMenu, String nama, int harga) {
        this.idMenu = idMenu;
        this.nama = nama;
        this.harga = harga;
    }

    public String getIdMenu(){
        return idMenu;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}
