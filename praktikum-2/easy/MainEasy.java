public class MainEasy {
    public static void main(String[] args) {

        Seminar s = new Seminar("Seminar Teknologi", 50);
        Workshop w = new Workshop("Workshop java", 30);

        System.out.println("=== INFORMASI KEGIATAN ===");
        System.out.println();

        s.tampilkanInfo();       
        System.out.println("Total Biaya  : " + s.hitungBiaya());
        s.terbitkanSertifikat();

        System.out.println();

        w.tampilkanInfo();
        System.out.println("Total Biaya  : " + w.hitungBiaya());

    
    
    }   
}
