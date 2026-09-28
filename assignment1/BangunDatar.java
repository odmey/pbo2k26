public class BangunDatar {
    int side;
    int length;
    int width;
    //concstructor
    public BangunDatar(){
        this.side = 0;
        this.length = 0;
        this.width = 0;
    }

    public BangunDatar(int s){
        this.side = s;
    }

    public BangunDatar(int l, int w){
        this.length = l;
        this.width = w;
    }
    //Accessor
    public int getSide(){
        return side;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    //Mutator
    public void setSide(int side){
        this.side = side;
    }
    public void setLength(int length){
        this.length = length;
    }
    public void setWidth(int width){
        this.width = width;
    }
    
    //methods
    public int calculateSquareArea(){
        return side*side;
    }
    public int calculateRectangleArea(){
        return length*width;
    }
    public int calculateSquarePerimeter(){
        return 4*side;
    }
    public int calculateRectanglePerimeter(){
        return 2*(length+width);
    }
}
