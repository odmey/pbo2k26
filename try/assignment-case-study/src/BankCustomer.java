import java.util.ArrayList;

/**
 * BankCustomer is NOT an account, it HAS accounts (has-a / composition).
 *   "A customer IS AN account"  -> wrong
 *   "A customer HAS accounts"   -> right
 *
 * The list is declared with the PARENT type, so one ArrayList can hold
 * SavingsAccount and CheckingAccount objects together.
 *
 * BankCustomer and BaseAccount have no common parent, but both implement Reportable.
 */
public class BankCustomer implements Reportable {

    private final String firstName;
    private final String lastName;
    private final ArrayList<BaseAccount> accounts = new ArrayList<BaseAccount>();

    public BankCustomer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public void addAccount(BaseAccount account) {
        accounts.add(account);
    }

    public BaseAccount getAccount(int index) { return accounts.get(index); }

    public int getNumOfAccounts() { return accounts.size(); }

    public double getTotalBalance() {
        double total = 0;
        for (BaseAccount a : accounts) {
            total = total + a.getBalance();
        }
        return total;
    }

    /**
     * POLYMORPHISM in action: one line, a.monthEndUpdate(), but the REAL object decides
     * what happens (Savings pays interest, Checking charges a fee).
     */
    public void monthEnd() {
        for (BaseAccount a : accounts) {
            a.monthEndUpdate();
        }
    }

    @Override
    public String toReport() {
        return "Customer " + firstName + " " + lastName
                + " | accounts: " + accounts.size()
                + " | total balance: " + getTotalBalance();
    }
}
