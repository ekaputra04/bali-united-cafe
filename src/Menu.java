public class Menu {
    private String namaMenu[] = {
            " si Ayam Sambal Geprek", " si Ayam Sambal Matah", " si Ayam Sambal Konslet",
            " si Kulit Ayam Sambal Geprek", " si Kulit Ayam Sambal Matah", " si Kulit Ayam Sambal Konslet", // Signature
                                                                                                               // Ricebowl
            " si Ayam Goreng + Plecing Kangkung", " si Ayam Bakar + Plecing Kangkung", " si Chicken Teriyaki",
            " si Ayam Koloke", " si Sop Iga", " si Goreng Kampung", " si Goreng Gila Bola", " si Goreng Popmie",
            " si Capcay", // Rice Menu
            "Capcay", "Cah Kangkung", "Plecing Kangkung", "Tahu Tempe Goreng", // Menu Vegetable
            "Mie Bakso Ayam", "Mie Bakso Sapi", "Bakso Ayam Pangsit Komplit", // Signature Menu
            "Chicken Burger", "Sandwich", "Hotdog", "Spaghetti Carbonara", "Spaghetti Bolognaise",
            "Spaghetti Aglio o'llo", // Western
            "Indomie Telur Luncheon", "Indomie Telur Kornet", "Indomie Goreng Selera Semeton",
            "Indomie Kuah Selera Semeton", "Indomie Ayam Crispy Sambal Matah", "Indomie Ayam Geprek Tridatu",
            "Indomie Nendang Banget", "Indomie Nyemek", // Signature Indomie
            "Creamy Latte", "Cappucino", "Black Coffee Torabika", "Black Tea", "Lemon Tea", "Lychee Tea", "Teh Tarik",
            "Beer Guinness", "Milkshake", "Tridatu Mocktails", // Drink
            "Friench Fries", "Crazy Friench Fries", "Chicken Wing", "Chicken Luncheon", "Kacang Kapri", "Tahu Krispi",
            "Tmpe Mendoan", "Roti Bakar Cokla", "Roti Bakar Keju", "Roti Bakar Coklat Keju", "Roti Bakar Gula",
            "Roti Bakar Telur Kornet", "Pisang Bakar Coklat", "Pisang Bakar Keju", "Pisang Bakar Coklat Keju" // Warming
                                                                                                            // Up
    };    
    
    private int harga;
    
    public Menu(String nama[], int harga) {
        this.namaMenu = nama;
        this.harga = harga;
    }

    public static void tampilkanMenu() {
        Main.header();
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                      MENU RESTAURANT                    ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("||                 Nama Menu                 |    Harga    ||");
        System.out.println("||---------------------------------------------------------||");
        System.out.println("|| [1]  Nasi Ayam Sambal Geprek              |  Rp. 26,5 k ||");
        System.out.println("|| [2]  Nasi Ayam Sambal Matah               |  Rp. 25 k   ||");
        System.out.println("|| [3]  Nasi Ayam Sambal Konslet             |  Rp. 25 k   ||");
        System.out.println("|| [4]  Nasi Kulit Ayam Sambal Geprek        |  Rp. 20 k   ||");
        System.out.println("|| [5]  Nasi Kulit Ayam Sambal Matah         |  Rp. 20 k   ||");
        System.out.println("|| [6]  Nasi Kulit Ayam Sambal Konslet       |  Rp. 20 k   ||");
        System.out.println("|| [7]  Nasi Ayam Goreng + Plecing Kangkung  |  Rp. 30 k	 ||");
        System.out.println("|| [8]  Nasi Ayam Bakar + Plecing Kangkung   |  Rp. 30 k   ||");
        System.out.println("|| [9]  Nasi Chicken Teriyaki                |  Rp. 25 k   ||");
        System.out.println("|| [10] Nasi Ayam Koloke                     |  Rp. 26,5 k ||");
        System.out.println("|| [11] Nasi Sop Iga                         |  Rp. 45 k   ||");
        System.out.println("|| [12] Nasi Goreng Kampung                  |  Rp. 25 k   ||");
        System.out.println("|| [13] Nasi Goreng Gila Bola                |  Rp. 26,5 k ||");
        System.out.println("|| [14] Nasi Goreng Popmie                   |  Rp. 25 k   ||");
        System.out.println("|| [15] Nasi Capcay                          |  Rp. 20 k   ||");
        System.out.println("|| [16] Capcay                               |  Rp. 20 k   ||");
        System.out.println("|| [17] Cah Kangkung                         |  Rp. 20 k   ||");
        System.out.println("|| [18] Plecing Kangkung                     |  Rp. 20 k   ||");
        System.out.println("|| [19] Tahu Tempe Goreng                    |  Rp. 15 k   ||");
        System.out.println("|| [20] Mie Bakso Ayam                       |  Rp. ");
        System.out.println("|| [21] Mie Bakso Sapi                       |  Rp. ");
        System.out.println("|| [22] Bakso Ayam Pangsit Komplit           |  Rp. ");
        System.out.println("|| [23] Chicken Burger                       |  Rp. ");
        System.out.println("|| [24] Sandwich                             |  Rp. ");
        System.out.println("|| [25] Hotdog                               |  Rp. ");
        System.out.println("|| [26] Spaghetti Carbonara                  |  Rp. ");
        System.out.println("|| [27] Spaghetti Bolognaise                 |  Rp. ");
        System.out.println("|| [28] Spaghetti Aglio o'llo                |  Rp. ");
        System.out.println("|| [29] Indomie Telur Luncheon               |  Rp. ");
        System.out.println("|| [30] Indomie Telur Kornet                 |  Rp. ");
        System.out.println("|| [31] Indomie Goreng Selera Semeton        |  Rp. ");
        System.out.println("|| [32] Indomie Kuah Selera Semeton          |  Rp. ");
        System.out.println("|| [33] Indomie Ayam Crispy Sambal Matah     |  Rp. ");
        System.out.println("|| [34] Indomie Ayam Geprek Tridatu          |  Rp. ");
        System.out.println("|| [35] Indomie Nendang Banget               |  Rp. ");
        System.out.println("|| [36] Indomie Nyemek                       |  Rp. ");
        System.out.println("|| [37] Creamy Latte	");
        System.out.println("|| [38] Cappucino	");
        System.out.println("|| [39] Black Coffee Torabika	");
        System.out.println("|| [40] Black Tea	");
        System.out.println("|| [41] Lemon Tea	");
        System.out.println("|| [42] Lychee Tea	");
        System.out.println("|| [43] Teh Tarik	");
        System.out.println("|| [44] Beer Guinness	");
        System.out.println("|| [45] Milkshake	");
        System.out.println("|| [46] Tridatu Mocktails	");
        System.out.println("|| [47] French Fries	");
        System.out.println("|| [48] Crazy Friench Fries	");
        System.out.println("|| [49] Chicken Wing	");
        System.out.println("|| [50] Chicken Luncheon	");
        System.out.println("|| [51] Kacang Kapri	");
        System.out.println("|| [52] Tahu Krispi	");
        System.out.println("|| [53] Tempe Mendoan	");
        System.out.println("|| [54] Roti Bakar Coklat	");
        System.out.println("|| [55] Roti Bakar Keju	");
        System.out.println("|| [56] Roti Bakar Coklat Keju	");
        System.out.println("|| [57] Roti Bakar Gula	");
        System.out.println("|| [58] Roti Bakar Telur Kornet	");
        System.out.println("|| [59] Pisang Bakar Coklat	");
        System.out.println("|| [60] Pisang Bakar Keju	");
        System.out.println("|| [61] Pisang Bakar Coklat Keju	");
    }

    public String getNama(int indexNamaMenu) {
        return namaMenu[indexNamaMenu];
    }

    public int getHarga() {
        return harga;
    }
}
