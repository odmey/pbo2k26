/**
 * INTERFACE: InterestBearing  ("can earn interest")
 *
 * Only SOME accounts earn interest (SavingsAccount does, CheckingAccount does not),
 * so "earns interest" is a CAPABILITY (can-do), not a parent class (is-a).
 */
public interface InterestBearing {

    /** Interest earned for ONE month at the current balance. */
    double calculateInterest();

    /** Yearly rate as a fraction, e.g. 0.12 means 12% per year. */
    double getInterestRate();
}
