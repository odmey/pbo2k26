public class PaketEkspres extends Paket {
    
    public PaketEkspres(String namaPengirim, String idPaket, int beratKg, double biayaKemasan, boolean antarPulau){
        super(namaPengirim, idPaket, "Ekspress", beratKg, biayaKemasan, antarPulau);
    }

    @Override 
    public double hitungOngkir(){
        return getBeratKg()*15000;
    }
    @Override 
    public double hitungBiayaAntarPulau(){
        double berat = getBeratKg()-1;
        return berat*6000;
    }
}
