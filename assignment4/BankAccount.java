public class BankAccount {
    final private Customer[] customers;
    private int numberOfCustomers;

    public BankAccount() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        Customer newCustomer = new Customer(f, l);
        customers[numberOfCustomers] = newCustomer;
        numberOfCustomers++;
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    // Mengembalikan customer berdasarkan index
    public Customer getCustomer(int index) {
        return customers[index];
    }
}