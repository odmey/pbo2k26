/**
 * INTERFACE: Reportable  ("can produce a report")
 *
 * An interface is a CONTRACT: it says WHAT a class can do, not HOW.
 * BaseAccount and BankCustomer are NOT related by inheritance,
 * yet both sign this contract (can-do relationship).
 *
 * Slide topics shown here (PBO 7 and 8):
 *  - a constant         (implicitly public static final)
 *  - an abstract method (implicitly public abstract, no body)
 *  - a default method   (Java 8)
 *  - a static method    (Java 8)
 */
public interface Reportable {

    // CONSTANT: public static final automatically.
    String BANK_NAME = "UNRAM Mini Bank";

    // ABSTRACT METHOD: only the signature. Each class decides HOW.
    String toReport();

    // DEFAULT METHOD: has a body, implementing classes can use it as is.
    default void printReport() {
        System.out.println("[" + BANK_NAME + "] " + toReport());
    }

    // STATIC METHOD: called through the interface name, Reportable.printHeader(..)
    static void printHeader(String title) {
        System.out.println();
        System.out.println("===== " + title + " =====");
    }
}
