/**
 * CONCRETE class #2: may go below zero up to an overdraft limit.
 * It does NOT implement InterestBearing: no interest, it pays a monthly fee instead.
 *
 * It OVERRIDES withdraw() with another rule than BaseAccount.withdraw():
 * same name and parameters, different behaviour = RUN-TIME POLYMORPHISM.
 */
public class CheckingAccount extends BaseAccount {

    public static final double MONTHLY_FEE = 5.0;

    private double overdraftLimit;

    public CheckingAccount(int accountNumber, double initBalance, double overdraftLimit) {
        super(accountNumber, initBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        // balance + overdraftLimit = money the customer may really use
        if (amount > 0 && balance + overdraftLimit >= amount) {
            balance = balance - amount;        // balance may become negative
            return true;
        }
        return false;
    }

    @Override
    public String getAccountType() { return "Checking"; }

    @Override
    public void monthEndUpdate() {
        balance = balance - MONTHLY_FEE;       // month end = fee is charged
    }

    @Override
    public String toReport() {
        return super.toReport() + " | overdraft limit: " + overdraftLimit;
    }
}
