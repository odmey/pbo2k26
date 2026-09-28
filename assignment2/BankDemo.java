public class BankDemo {
    public static void main(String[] args) {
        Bank customer = new Bank();
        customer.setBalance(100000);
        customer.setDeposit(500000);
        customer.setWithdraw(150000)
;
        System.out.println("Welcome to Bank ABC");
        System.out.println("Current Balance: " + customer.getBalance());

        System.out.println("Deposit: " + customer.getDeposit());
        customer.addDeposit(customer.getDeposit());
        System.out.println("Current Balanced: " + customer.getBalance());

        System.out.println("Withdraw: " + customer.getWithdraw());
        customer.withdrawMoney(customer.getWithdraw());
        System.out.println("Current Balanced: " + customer.getBalance());


    }
}
