public class Menu {
    private String nama;
    private int harga;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    // private String namaMenu[] = {
    //     // Signature Ricebowl
    //     "Nasi Ayam Sambal Geprek", "Nasi Ayam Sambal Matah", "Nasi Ayam Sambal Konslet",
    //     "Nasi Kulit Ayam Sambal Geprek", "Nasi Kulit Ayam Sambal Matah", "Nasi Kulit Ayam Sambal Konslet",
    //     // Rice Menu
    //     "Nasi Ayam Goreng + Plecing Kangkung", "Nasi Ayam Bakar + Plecing Kangkung", "Nasi Chicken Teriyaki",
    //     "Nasi Ayam Koloke", "Nasi Sop Iga", "Nasi Goreng Kampung", "Nasi Goreng Gila Bola", "Nasi Goreng Popmie",
    //     "Nasi Capcay",
    //     // Vegetable
    //     "Capcay", "Cah Kangkung", "Plecing Kangkung", "Tahu Tempe Goreng", 
    //     // Signature Bakso
    //     "Mie Bakso Ayam", "Mie Bakso Sapi", "Bakso Ayam Pangsit Komplit", "Bakso Sapi Pangsit Komplit", 
    //     // Western
    //     "Chicken Burger", "Sandwich", "Hotdog", "Spaghetti Carbonara", "Spaghetti Bolognaise",
    //     "Spaghetti Aglio o'llo", 
    //     // Signature Indomie
    //     "Indomie Telur Luncheon", "Indomie Telur Kornet", "Indomie Goreng Selera Semeton",
    //     "Indomie Kuah Selera Semeton", "Indomie Ayam Crispy Sambal Matah", "Indomie Ayam Geprek Tridatu",
    //     "Indomie Nendang Banget", "Indomie Nyemek", 
    //     // Drink
    //     "Creamy Latte", "Cappucino", "Black Coffee Torabika", "Black Tea", "Lemon Tea", "Lychee Tea", "Teh Tarik",
    //     "Beer Guinness", "Milkshake", "Tridatu Mocktails", 
    //     // Warming Up
    //     "Friench Fries", "Crazy Friench Fries", "Chicken Wing", "Chicken Luncheon", "Kacang Kapri", "Tahu Krispi",
    //     "Tempe Mendoan", "Roti Bakar Coklat", "Roti Bakar Keju", "Roti Bakar Coklat Keju", "Roti Bakar Gula",
    //     "Roti Bakar Telur Kornet", "Pisang Bakar Coklat", "Pisang Bakar Keju", "Pisang Bakar Coklat Keju"
    // };

    // private int harga[] = {
    //     // Signature Ricebowl
    //     26500, 25000, 25000, 20000, 20000, 20000,
    //     // Rice Menu
    //     30000, 30000, 25000, 26500, 45000, 25000, 26500, 25000, 20000,
    //     // Vegetable
    //     20000, 20000, 20000, 15000,
    //     // Signature Bakso
    //     20000, 22000, 23000, 25000,
    //     // Western
    //     20000, 25000, 24000, 23000, 23000, 20000,
    //     // Signature Indomie
    //     12000, 15000, 15000, 15000, 20000, 20000, 23000, 23000,
    //     // Drink
    //     12000, 12000, 12000, 5000, 5000, 5000, 15000, 30000, 18000, 20000,
    //     // Warming Up
    //     15000, 20000, 25000, 10000, 5000, 15000, 15000, 15000, 15000, 18000, 15000, 20000, 20000, 20000, 22000
    // };


    // public static void tampilkanMenu() {
    //     System.out.println("=============================================================");
    //     System.out.println("||                                                         ||");
    //     System.out.println("||                    BALI UNITED CAFE                     ||");
    //     System.out.println("||                                                         ||");
    //     System.out.println("||=========================================================||");
    //     System.out.println("||                      MENU RESTAURANT                    ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| Kode |             Nama Menu              |    Harga    ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                  ~ Signature Ricebowl ~                 ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [1]  Nasi Ayam Sambal Geprek              |  Rp. 26,5 k ||");
    //     System.out.println("|| [2]  Nasi Ayam Sambal Matah               |  Rp. 25 k   ||");
    //     System.out.println("|| [3]  Nasi Ayam Sambal Konslet             |  Rp. 25 k   ||");
    //     System.out.println("|| [4]  Nasi Kulit Ayam Sambal Geprek        |  Rp. 20 k   ||");
    //     System.out.println("|| [5]  Nasi Kulit Ayam Sambal Matah         |  Rp. 20 k   ||");
    //     System.out.println("|| [6]  Nasi Kulit Ayam Sambal Konslet       |  Rp. 20 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                       ~ Rice Menu ~                     ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [7]  Nasi Ayam Goreng + Plecing Kangkung  |  Rp. 30 k   ||");
    //     System.out.println("|| [8]  Nasi Ayam Bakar + Plecing Kangkung   |  Rp. 30 k   ||");
    //     System.out.println("|| [9]  Nasi Chicken Teriyaki                |  Rp. 25 k   ||");
    //     System.out.println("|| [10] Nasi Ayam Koloke                     |  Rp. 26,5 k ||");
    //     System.out.println("|| [11] Nasi Sop Iga                         |  Rp. 45 k   ||");
    //     System.out.println("|| [12] Nasi Goreng Kampung                  |  Rp. 25 k   ||");
    //     System.out.println("|| [13] Nasi Goreng Gila Bola                |  Rp. 26,5 k ||");
    //     System.out.println("|| [14] Nasi Goreng Popmie                   |  Rp. 25 k   ||");
    //     System.out.println("|| [15] Nasi Capcay                          |  Rp. 20 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                       ~ Vegetable ~                     ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [16] Capcay                               |  Rp. 20 k   ||");
    //     System.out.println("|| [17] Cah Kangkung                         |  Rp. 20 k   ||");
    //     System.out.println("|| [18] Plecing Kangkung                     |  Rp. 20 k   ||");
    //     System.out.println("|| [19] Tahu Tempe Goreng                    |  Rp. 15 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                    ~ Signature Bakso ~                  ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [20] Mie Bakso Ayam                       |  Rp. 20 k   ||");
    //     System.out.println("|| [21] Mie Bakso Sapi                       |  Rp. 22 k   ||");
    //     System.out.println("|| [22] Bakso Ayam Pangsit Komplit           |  Rp. 23 k   ||");
    //     System.out.println("|| [23] Bakso Sapi Pangsit Komplit           |  Rp. 25 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                        ~ Western ~                      ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [24] Chicken Burger                       |  Rp. 20 k   ||");
    //     System.out.println("|| [25] Sandwich                             |  Rp. 25 k   ||");
    //     System.out.println("|| [26] Hotdog                               |  Rp. 24 k   ||");
    //     System.out.println("|| [27] Spaghetti Carbonara                  |  Rp. 23 k   ||");
    //     System.out.println("|| [28] Spaghetti Bolognaise                 |  Rp. 23 k   ||");
    //     System.out.println("|| [29] Spaghetti Aglio o'llo                |  Rp. 20 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                  ~ Signature Indomie ~                  ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [30] Indomie Telur Luncheon               |  Rp. 12 k   ||");
    //     System.out.println("|| [31] Indomie Telur Kornet                 |  Rp. 15 k   ||");
    //     System.out.println("|| [32] Indomie Goreng Selera Semeton        |  Rp. 15 k   ||");
    //     System.out.println("|| [33] Indomie Kuah Selera Semeton          |  Rp. 15 k   ||");
    //     System.out.println("|| [34] Indomie Ayam Crispy Sambal Matah     |  Rp. 20 k   ||");
    //     System.out.println("|| [35] Indomie Ayam Geprek Tridatu          |  Rp. 20 k   ||");
    //     System.out.println("|| [36] Indomie Nendang Banget               |  Rp. 23 k   ||");
    //     System.out.println("|| [37] Indomie Nyemek                       |  Rp. 23 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                         ~ Drink ~                       ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [38] Creamy Latte                         |  Rp. 12 k   ||");
    //     System.out.println("|| [39] Cappucino                            |  Rp. 12 k   ||");
    //     System.out.println("|| [40] Black Coffee Torabika                |  Rp. 12 k   ||");
    //     System.out.println("|| [41] Black Tea                            |  Rp. 5 k    ||");
    //     System.out.println("|| [42] Lemon Tea                            |  Rp. 5 k    ||");
    //     System.out.println("|| [43] Lychee Tea                           |  Rp. 5 k    ||");
    //     System.out.println("|| [44] Teh Tarik                            |  Rp. 15 k   ||");
    //     System.out.println("|| [45] Beer Guinness                        |  Rp. 30 k   ||");
    //     System.out.println("|| [46] Milkshake                            |  Rp. 18 k   ||");
    //     System.out.println("|| [47] Tridatu Mocktails                    |  Rp. 20 k   ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("||                      ~ Warming Up ~                     ||");
    //     System.out.println("||---------------------------------------------------------||");
    //     System.out.println("|| [48] French Fries                         |  Rp. 15 k   ||");
    //     System.out.println("|| [49] Crazy Friench Fries                  |  Rp. 20 k   ||");
    //     System.out.println("|| [50] Chicken Wing                         |  Rp. 25 k   ||");
    //     System.out.println("|| [51] Chicken Luncheon                     |  Rp. 10 k   ||");
    //     System.out.println("|| [52] Kacang Kapri                         |  Rp. 5 k    ||");
    //     System.out.println("|| [53] Tahu Krispi                          |  Rp. 15 k   ||");
    //     System.out.println("|| [54] Tempe Mendoan                        |  Rp. 15 k   ||");
    //     System.out.println("|| [55] Roti Bakar Coklat                    |  Rp. 15 k   ||");
    //     System.out.println("|| [56] Roti Bakar Keju                      |  Rp. 15 k   ||");
    //     System.out.println("|| [57] Roti Bakar Coklat Keju               |  Rp. 18 k   ||");
    //     System.out.println("|| [58] Roti Bakar Gula                      |  Rp. 15 k   ||");
    //     System.out.println("|| [59] Roti Bakar Telur Kornet              |  Rp. 20 k   ||");
    //     System.out.println("|| [60] Pisang Bakar Coklat                  |  Rp. 20 k   ||");
    //     System.out.println("|| [61] Pisang Bakar Keju                    |  Rp. 20 k   ||");
    //     System.out.println("|| [62] Pisang Bakar Coklat Keju             |  Rp. 22 k   ||");
    //     System.out.println("=============================================================");
    // }
}
