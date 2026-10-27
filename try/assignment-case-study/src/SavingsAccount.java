/**
 * CONCRETE class #1.
 *   extends    BaseAccount     -> INHERITANCE (is-a)
 *   implements InterestBearing -> INTERFACE   (can-do)
 *
 * Being concrete, it must implement every abstract method it received:
 * getAccountType() and monthEndUpdate() (from BaseAccount),
 * calculateInterest() and getInterestRate() (from InterestBearing).
 */
public class SavingsAccount extends BaseAccount implements InterestBearing {

    public static final double DEFAULT_RATE = 0.04;   // constant: static final

    private double annualRate;

    public SavingsAccount(int accountNumber, double initBalance, double annualRate) {
        super(accountNumber, initBalance);   // super(...) is the FIRST line
        this.annualRate = annualRate;
    }

    // OVERLOADING (compile-time polymorphism): same name, different parameters.
    public SavingsAccount(int accountNumber, double initBalance) {
        this(accountNumber, initBalance, DEFAULT_RATE);
    }

    @Override
    public double getInterestRate() { return annualRate; }

    @Override
    public double calculateInterest() {
        return balance * annualRate / 12;      // one month of interest
    }

    @Override
    public String getAccountType() { return "Savings"; }

    @Override
    public void monthEndUpdate() {
        balance = balance + calculateInterest();   // month end = interest is paid in
    }

    @Override
    public String toReport() {
        return super.toReport() + " | rate: " + (annualRate * 100) + "%/yr";
    }
}
