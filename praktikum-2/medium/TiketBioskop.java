public class TiketBioskop extends Tiket implements IPromo {
    private String nomorKursi;
    private String kelas;
    private static int promoUsageCount = 0;
    private static final int MAX_PROMO_USAGE = 2;

    public TiketBioskop(String nama, double harga, String kursi, String kelas) {
        super(nama, harga);
        this.nomorKursi = kursi;
        this.kelas = kelas;
    }

    @Override
    public double hitungHargaAkhir() {
        double subtotal;
        if (kelas.equals("GOLD")) {
            subtotal = hargaDasar * 1.5;
        } else {
            subtotal = hargaDasar * 1.1;
        }
        return subtotal - diskonPromo;
    }

    @Override
    public double terapkanKodePromo(String kode) {
        System.out.println("Mencoba promo '" + kode + "' untuk " + namaAcara);
        if (kode.equals("HEMATXXI")) {
            if (promoUsageCount < MAX_PROMO_USAGE) {
                promoUsageCount++;
                diskonPromo = 10000;
                System.out.println("Berhasil! Diskon Rp " + diskonPromo
                        + ". Sisa penggunaan: " + (MAX_PROMO_USAGE - promoUsageCount));
                return diskonPromo;
            } else {
                System.out.println("Gagal! Promo '" + kode + "' sudah habis.");
                return 0;
            }
        }
        System.out.println("Kode promo tidak valid.");
        return 0;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("  Nomor Kursi : " + nomorKursi);
        System.out.println("  Kelas Tiket : " + kelas);
        System.out.println("  Subtotal    : Rp " + (hitungHargaAkhir() + diskonPromo));
        if (diskonPromo > 0) {
            System.out.println("  Diskon Promo: -Rp " + diskonPromo);
        }
    }
}