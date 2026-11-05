public class MainMedium {

    public static void prosesCheckout(Tiket[] keranjang) {
        System.out.println("=========================================");
        System.out.println("--- MEMPROSES CHECKOUT ---");
        System.out.println("=========================================");
        double totalBelanja = 0;

        for (Tiket tiket : keranjang) {
            tiket.tampilkanInfo();

            double hargaFinal = tiket.hitungHargaAkhir();

            System.out.println("  Harga Final : Rp " + hargaFinal);
            totalBelanja = totalBelanja + hargaFinal;
            System.out.println("---------------------------------");
        }

        System.out.println("TOTAL BELANJA ANDA: Rp " + totalBelanja);
    }

    public static void main(String[] args) {

        System.out.println("--- Proses Pembelian Tiket ---");

        TiketKonser tiket1 = new TiketKonser("Konser Coldplay", 500000, "Coldplay", "VIP");
        tiket1.terapkanKodePromo("KONSERHEMAT");

        TiketBioskop tiket2 = new TiketBioskop("Film The Dark Knight", 40000, "C7", "GOLD");
        tiket2.terapkanKodePromo("HEMATXXI");

        TiketBioskop tiket3 = new TiketBioskop("Film In The Heart of The Sea", 35000, "A1", "REGULER");
        tiket3.terapkanKodePromo("HEMATXXI");

        TiketKonser tiket4 = new TiketKonser("Konser Jazz One", 150000, "Musisi Jazz", "REGULER");
        tiket4.terapkanKodePromo("SALAH");

        TiketBioskop tiket5 = new TiketBioskop("Film Oppenheimer", 40000, "D4", "GOLD");
        tiket5.terapkanKodePromo("HEMATXXI");

        TiketKonser tiket6 = new TiketKonser("Konser Pop Lokal", 200000, "Artis Pop", "REGULER");
        tiket6.terapkanKodePromo("KONSERHEMAT");

        Tiket[] keranjangBelanja = {tiket1, tiket2, tiket3, tiket4, tiket5, tiket6};
        prosesCheckout(keranjangBelanja);
    }
}