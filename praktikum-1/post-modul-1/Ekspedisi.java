import java.util.ArrayList;

public class Ekspedisi{
    final private String namaEkspedisi;
    final private ArrayList<Paket> daftarPaket;

    public Ekspedisi(String namaEkspedisi){
        this.namaEkspedisi = namaEkspedisi;
        this.daftarPaket = new ArrayList<>();
    }

    public String getNamaEkspedisi(){
        return namaEkspedisi;
    }

    public void tambahPaket(Paket paket){
        daftarPaket.add(paket);
    }

    private String formatRupiah(double nilai){
        long bulat = Math.round(nilai);
        String digit = String.valueOf(Math.abs(bulat));
        StringBuilder hasil = new StringBuilder();
        for (int i = 0; i < digit.length(); i++){
            if (i > 0 && (digit.length() - i) % 3 == 0){
                hasil.append('.');
            }
            hasil.append(digit.charAt(i));
        }
        return (bulat < 0 ? "-Rp " : "Rp ") + hasil;
    }

    private void cetak(String label, String isi){
        System.out.printf("%-15s : %s%n", label, isi);
    }

    public void hitungSemuaBiaya(){
        double totalSeluruhnya = 0;
        System.out.println("=======================================");
        System.out.println("LAPORAN BIAYA PENGIRIMAN PAKET");
        System.out.println("=======================================");

        for(int i =0; i < daftarPaket.size(); i++){
            Paket p = daftarPaket.get(i);

            String tujuan;
            String peti;
            if (p.isAntarPulau()) {
                tujuan = "Antar Pulau";
                peti = formatRupiah(p.hitungBiayaAntarPulau());
            } else {
                tujuan = "Dalam Pulau";
                peti = formatRupiah(0) + " (dalam pulau)";
            }
 
            double total = p.hitungTotalBiaya(p.isAntarPulau());
            totalSeluruhnya += total;

            cetak("Nama Pengirim", p.getNamaPengirim());
            cetak("ID", p.getIdPaket());
            cetak("Layanan", p.getLayanan());
            cetak("Berat", p.getBeratKg() + " kg");
            cetak("Tujuan", tujuan);
            cetak("Ongkos Kirim", formatRupiah(p.hitungOngkir()));
            cetak("Antar Pulau", peti);
            cetak(p.getLabelKemasan(), formatRupiah(p.hitungBiayaKemasan()));
            cetak("Total Biaya", formatRupiah(total));

            if (i < daftarPaket.size() - 1) {
                System.out.println("---------------------------------------");
            }
        }
        System.out.println("=======================================");
        cetak("TOTAL SELURUHNYA", formatRupiah(totalSeluruhnya));
    }

}