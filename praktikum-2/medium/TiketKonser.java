public class TiketKonser extends Tiket implements IPromo {
    private String namaArtis;
    private String kelas;
    private static int promoUsageCount = 0;
    private static final int MAX_PROMO_USAGE = 2;

    public TiketKonser(String nama, double harga, String artis, String kelas) {
        super(nama, harga);
        this.namaArtis = artis;
        this.kelas = kelas;
    }

    @Override
    public double hitungHargaAkhir() {
        double subtotal;
        if (kelas.equals("VIP")) {
            subtotal = hargaDasar * 2.0;
        } else {
            subtotal = hargaDasar * 1.2;
        }
        return subtotal - diskonPromo;
    }

    @Override
    public double terapkanKodePromo(String kode) {
        System.out.println("Mencoba promo '" + kode + "' untuk " + namaAcara);
        if (kode.equals("KONSERHEMAT")) {
            if (promoUsageCount < MAX_PROMO_USAGE) {
                promoUsageCount++;
                diskonPromo = 50000;
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
        System.out.println("  Artis       : " + namaArtis);
        System.out.println("  Kelas Tiket : " + kelas);
        System.out.println("  Subtotal    : Rp " + (hitungHargaAkhir() + diskonPromo));
        if (diskonPromo > 0) {
            System.out.println("  Diskon Promo: -Rp " + diskonPromo);
        }
    }
}