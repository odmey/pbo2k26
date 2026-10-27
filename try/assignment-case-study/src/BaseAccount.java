/**
 * ABSTRACT CLASS: BaseAccount  (the "is-a" parent of every account type)
 *
 * An abstract class is a PARTIALLY COMPLETE class:
 *  - it has real fields and a constructor,
 *  - it has concrete methods (deposit, withdraw, toReport),
 *  - it has ABSTRACT methods = requirements that every concrete subclass MUST implement.
 *
 * new BaseAccount(...) does NOT compile:
 *     error: BaseAccount is abstract; cannot be instantiated
 *
 * BaseAccount also implements Reportable, so every account IS-A Reportable too.
 */
public abstract class BaseAccount implements Reportable {

    private final int accountNumber;     // private: only reachable through the getter
    protected double balance;            // protected: subclasses may use it directly

    // Constructor of an abstract class: runs when a subclass calls super(...).
    public BaseAccount(int accountNumber, double initBalance) {
        this.accountNumber = accountNumber;
        if (initBalance > 0) {           // validation: never start negative
            this.balance = initBalance;
        }
    }

    public int getAccountNumber() { return accountNumber; }

    public double getBalance() { return balance; }

    // CONCRETE method: the same for every account type.
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }

    // CONCRETE method with a default rule. Subclasses may OVERRIDE it.
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    // ---------- ABSTRACT METHODS: "what", without "how" ----------

    /** Every account type must give its own name. */
    public abstract String getAccountType();

    /** Every account type does something different at the end of the month. */
    public abstract void monthEndUpdate();

    // ---------- Reportable contract ----------

    /** A concrete method that calls an abstract one: the REAL object's version runs. */
    @Override
    public String toReport() {
        return "#" + accountNumber + " " + getAccountType() + " | balance: " + balance;
    }

    @Override
    public String toString() {
        return getAccountType() + " #" + accountNumber;
    }
}
