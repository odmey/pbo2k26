public class Shape {
    protected String color;

    public Shape (String color){
        this.color = color;
    }
    
    public String getcolor (){
        return color;
    }

    public void setcolor (String color){
        this.color = color;
    }

    public void printInfo(){
        System.out.println("Shape colored" + color);
    }


}
