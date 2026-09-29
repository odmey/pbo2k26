import java.util.Scanner;
public class ShapeMain {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("How much shape you want to make?: ");
        int jumlah = input.nextInt();
        input.nextLine();

        Shape[] shapes = new Shape[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\n--- Shape ke-" + (i + 1) + " ---");
            System.out.println("\n1) Square  \n2) Circle  \n3) Cylinder \nChoose type (input number): ");
            int choose = input.nextInt();
            input.nextLine();

            System.out.print("Color: ");
            String color = input.nextLine();

            switch (choose){
                case 1 -> {
                    System.out.print("Side length (side): ");
                    double side = input.nextDouble();
                    shapes[i] = new Square(side, color);
                }
                case 2 -> {
                    System.out.print("Radius: ");
                    double radius = input.nextDouble();
                    shapes[i] = new Circle(radius, color);
                }
                case 3 -> {
                    System.out.print("Radius: ");
                    double r = input.nextDouble();
                    System.out.print("Tinggi: ");
                    double height = input.nextDouble();
                    shapes[i] = new Cylinder(height, r, color);
                }
                default -> System.out.println("input is not valid please try again.");
            }

            System.out.println("\n=== Result ===");
            for (Shape s : shapes) {
                if (s != null) {
                    s.printInfo();
                }
            }
            input.close();
        }

    }
}
