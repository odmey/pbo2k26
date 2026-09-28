public class Rumah {
    private final double price;
    private final int type;

    public Rumah(double price, int type){
        this.price = price;
        this.type = type;
    }

    public double getPrice(){
        return price;
    }

    public int getType(){
        return type;
    }

    public double CountTax(){
        if (type == 36){
            return 0.04*price;
        } else if (type == 45){
            return 0.06*price;
        } else if(type > 45){
            return 0.09*price;
        }
        return 0;
    }

}
