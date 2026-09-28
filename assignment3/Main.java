public class Main {
    public static void main(String[] args) {
        Ayah akbar = new Ayah("Akbar", new Rumah (300000000, 36));
        Ayah bambang = new Ayah("Bambang", new Rumah(450000000, 45));
        Ayah charlie = new Ayah ("Charlie", new Rumah(900000000, 90));

        Ayah[] daftarAyah = {akbar, bambang, charlie};

        for (Ayah ayah : daftarAyah){
            Rumah rumah = ayah.getRumah();
            System.out.println(
                "PBB " + ayah.getName()
                + " (rumah tipe " + rumah.getType()
                + ", harga " + String.format("%,.0f", rumah.getPrice())
                + ") = pajak Rp. " + String.format("%,.0f", ayah.getPBB()));
        }

    }
    
}
