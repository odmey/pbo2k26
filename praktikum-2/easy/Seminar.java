public class Seminar extends Kegiatan implements Bersertifikat {
    
    public Seminar(String namaKegiatan, int jumlahPeserta){
        super(namaKegiatan, jumlahPeserta);
    }
    @Override 
    public double hitungBiaya(){
        return jumlahPeserta*100000;
    }
    @Override 
    public void terbitkanSertifikat(){
        System.out.println("Sertifikat seminar telah diterbitkan.");
    }
}