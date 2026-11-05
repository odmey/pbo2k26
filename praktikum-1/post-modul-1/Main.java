public class Main {
    public static void main(String[] args) {
        Ekspedisi ekspedisi = new Ekspedisi("CV Kilat Nusantara");

        Paket paket1 = new PaketKargo("Rina", "KRG01", 40, 50000, 150000, true);
        Paket paket2 = new PaketEkspres("Dika", "EKS01", 3, 20000, true);
        Paket paket3 = new PaketRegular("Sari", "REG01", 5, 15000, true);
        Paket paket4 = new PaketRegular("Tono", "REG02", 2, 10000, false);

        ekspedisi.tambahPaket(paket1);
        ekspedisi.tambahPaket(paket2);
        ekspedisi.tambahPaket(paket3);
        ekspedisi.tambahPaket(paket4);

        ekspedisi.hitungSemuaBiaya();
    }
}