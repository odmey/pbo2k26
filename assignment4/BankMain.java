import java.util.Scanner;
public class BankMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount bank = new BankAccount();

        System.out.println("Berapa customer yang mau ditambahkan?: ");
        int jumlah = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jumlah; i++){
            System.out.println("Customer ke-" + (i + 1));

            System.out.println("Nama depan: ");
            String first = input.nextLine();

            System.out.println("Nama belakang: ");
            String last = input.nextLine();

            bank.addCustomer(first, last);
           
            System.out.print("Saldo awal account: ");
            double saldo = input.nextDouble();
            input.nextLine();

            bank.getCustomer(i).setAccount(new Account(saldo));
        }

        System.out.println("\n=== Daftar Customer ===");
        System.out.println("Jumlah customer: " + bank.getNumOfCustomers());

        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            Customer c = bank.getCustomer(i);
            System.out.println((i + 1) + ". " + c.getFirstName() + " " + c.getLastName()
                    + " | Saldo: " + c.getAccount(0).getBalance());
        }

        input.close();
    }

}
