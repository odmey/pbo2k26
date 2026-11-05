public abstract class Kegiatan{
    protected String namaKegiatan;
    protected int jumlahPeserta;

    public Kegiatan(String namaKegiatan, int jumlahPeserta){
        this.namaKegiatan = namaKegiatan;
        this.jumlahPeserta = jumlahPeserta;
    }

    public void tampilkanInfo(){
        System.out.println("Nama kegiatan  : " + namaKegiatan);
        System.out.println("Jumlah peserta : " + jumlahPeserta);
    }

    public abstract double hitungBiaya();
}