public class PaketRegular extends Paket{

    public PaketRegular(String namaPengirim, String idPaket, int beratKg, double biayaKemasan, boolean antarPulau){
        super(namaPengirim, idPaket, "Regular", beratKg, biayaKemasan, antarPulau);
    }

    @Override 
    public double hitungOngkir(){
        return getBeratKg()*8000;
    }
    @Override 
    public double hitungBiayaAntarPulau(){
        double berat = getBeratKg()-1;
        return berat*3000;
    }

}
