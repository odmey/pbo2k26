//     String name;
//     String nim;
//     int age;

//     // constructor: given the name same as the class name
//     // its automate callesd when the object is created
//     Student(String nim, String name){
//         this.name = name;
//         this.nim = nim;
//     }
//     // selector/accessor/getter: 
//     public String getName(){
//         return name;
//     }
//     public String getNim(){
//         return nim;
//     }
//     public int getAge(){
//         return age;
//     }
//     //mutator/setter: 
//     public void setName(String name){
//         this.name = name;
//     }
//     public void setNim(String nim){
//         this.nim = nim;
//     }
//     public void setAge(int age){
//         this.age = age;
//     }

//     public void learn(){
//         System.out.println(name + " sedang belajar, di usianya yang ke-" + age);
//     }
    
// }
class Circle {

    static final double PI = 3.141592;

    double r;

    Circle(double r) {
        this.r = r;
    }

    double hitungLuas() {
        return PI * r * r;
    }
}

public class Main {
    public static void main(String[] args) {

        // Student std1 = new Student("Mey", "f1d02410072");
        // System.out.println("Name: " + std1.getName());
        // std1.setName("Meisya");
        
        // std1.learn();
        

    // try (Scanner input = new Scanner(System.in)) {
    //     System.out.print("Enter your name: ");
    //     String name = input.nextLine();

    //     System.out.print("Enter your age: ");
    //     int age = input.nextInt();

    //     System.out.println("Hi " + name + ", age " + age);
    // }

    Circle c = new Circle(11.78);

        double area = c.hitungLuas();

        System.out.println("Decimal : " + area);
        System.out.println("Integer : " + (int) area);
        System.out.println("Rounded : " + Math.round(area));
    

    }
}
