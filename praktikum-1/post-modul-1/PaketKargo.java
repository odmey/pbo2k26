public class PaketKargo extends Paket {
    private double biayaPetiKayu;

    public PaketKargo(String namaPengirim, String idPaket, int beratKg, double biayaKemasan, double biayaPetiKayu, boolean antarPulau){
        super(namaPengirim, idPaket, "Kargo", beratKg, biayaKemasan, antarPulau);
        this.biayaPetiKayu = biayaPetiKayu;
    }

    //setter&getter
    public void setBiayaPetiKayu(double biayaPetiKayu){
        this.biayaPetiKayu = biayaPetiKayu;
    }
    public double getBiayaPetiKayu(){
        return biayaPetiKayu;
    }

    @Override 
    public double hitungOngkir(){
        return getBeratKg()*5000;
    }
    @Override 
    public double hitungBiayaAntarPulau(){
        double berat = getBeratKg()-1;
        return berat*2000;
    }
    @Override 
    public double hitungBiayaKemasan(){
        return getBiayaKemasan() + biayaPetiKayu;
    }
    @Override 
    public String getLabelKemasan(){
        return "Kemasan + Peti Kayu";
    }




}
