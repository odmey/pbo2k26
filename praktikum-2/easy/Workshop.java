public class Workshop extends Kegiatan {
    public Workshop(String namaKegiatan, int jumlahPeserta){
        super(namaKegiatan, jumlahPeserta);
    }
    @Override 
    public double hitungBiaya(){
        return jumlahPeserta*25000;
    }

}
