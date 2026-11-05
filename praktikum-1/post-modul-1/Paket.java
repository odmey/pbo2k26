public class Paket {
    private String namaPengirim;
    private String idPaket;
    private String layanan;
    private int beratKg;
    private double biayaKemasan;
    private boolean antarPulau;

    public Paket(String namaPengirim, String idPaket, String layanan, int beratKg, double biayaKemasan, boolean antarPulau){
        this.namaPengirim = namaPengirim;
        this.idPaket = idPaket;
        this.layanan = layanan;
        this.beratKg = beratKg;
        this.biayaKemasan = biayaKemasan;
        this.antarPulau = antarPulau;
    }

    //setter
    public void setNamaPengirim(String namaPengirim){
        this.namaPengirim = namaPengirim;
    }
    public void setIdPaket(String idPaket){
        this.idPaket = idPaket;
    }
    public void setLayanan(String layanan){
        this.layanan = layanan;
    }
    public void setBeratKg(int beratKg){
        this.beratKg = beratKg;
    }
    public void setBiayaKemasan(double biayaKemasan){
        this.biayaKemasan = biayaKemasan;
    }
    public void setAntarPulau(boolean antarPulau){
        this.antarPulau = antarPulau;
    }

    //getter
    public String getNamaPengirim() {
        return namaPengirim;
    }
    public String getIdPaket() {
        return idPaket;
    }
    public String getLayanan() {
        return layanan;
    }
    public int getBeratKg() {
        return beratKg;
    }
    public double getBiayaKemasan() {
        return biayaKemasan;
    }
    public boolean isAntarPulau() {
        return antarPulau;
    }

    //overloading method
    public double hitungBiayaKemasan(){
        return biayaKemasan;
    }
    public double hitungBiayaKemasan(double biayaPeti){
        return biayaKemasan + biayaPeti;
    }

    public double hitungOngkir(){
        return 0;
    }

    public double hitungBiayaAntarPulau(){
        return 0;
    }
    public String getLabelKemasan(){
        return "Biaya Kemasan";
    }
    public double hitungTotalBiaya(boolean antarPulau){
        double total = hitungOngkir();
        if (antarPulau){
            total += hitungBiayaKemasan() + hitungBiayaAntarPulau();
        }else{
            total += hitungBiayaKemasan();
        }
        return total;
    }

}
