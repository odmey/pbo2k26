public class Ayah {
    private final String name;
    private final Rumah rumah;

    public Ayah(String name, Rumah rumah){
        this.name = name;
        this.rumah = rumah;
    }

   public String getName(){
    return name;
   }
   public Rumah getRumah(){
    return rumah;
   }

   public double getPBB(){
    return rumah.CountTax();
   }


}