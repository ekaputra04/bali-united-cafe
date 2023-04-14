public class Restaurant {
    private String idRestaurant;
    private String name;
    private String address;
    
    public Restaurant(String idRestaurant, String name, String address) {
        this.idRestaurant = idRestaurant;
        this.name = name;
        this.address = address;
    }

    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdRestaurant() {
        return idRestaurant;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
}
