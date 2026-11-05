public abstract class Tiket {
    protected String idBeli;
    protected String namaAcara;
    protected double hargaDasar;
    protected double diskonPromo;
    static private int idCounter;

    public Tiket(String namaAcara, double hargaDasar){
        this.namaAcara = namaAcara;
        this.hargaDasar = hargaDasar;
        //additional info for others variabel u can place below the this syntax
        this.diskonPromo = 0;
        idCounter++;
        this.idBeli = "TIX-" + idCounter;
    }

    public String getIdBeli(){
        return idBeli;
    }

    public void tampilkanInfo(){
        
        System.out.println("  ID Pemesanan : " + getIdBeli());
        System.out.println("  Nama Acara   : " + namaAcara);
        System.out.println("  Harga Dasar  : Rp " + hargaDasar);
    }

    public abstract double hitungHargaAkhir();

}
