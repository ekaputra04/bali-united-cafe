public class User {
    private String namaUser;
    private String AlamatUser;

    public User(String namaUser, String alamatUser) {
        this.namaUser = namaUser;
        this.AlamatUser = alamatUser;
    }

    public String getNamaUser() {
        return namaUser;
    }
    
    public String getAlamatUser() {
        return AlamatUser;
    }
}
