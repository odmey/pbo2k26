/**
 * INTERFACE: Describable  ("can describe itself")
 *
 * An interface is a CONTRACT: it says WHAT a class can do, not HOW.
 * LibraryItem and LibraryMember are NOT related by inheritance,
 * yet both sign this contract (can-do relationship).
 *
 */
public interface Describable {

    // CONSTANT: public static final automatically.
    String LIBRARY_NAME = "UNRAM Mini Library";

    // ABSTRACT METHOD: only the signature. Each class decides HOW.
    String describe();

    // DEFAULT METHOD: has a body, implementing classes can use it as is.
    default void printInfo() {
        System.out.println("[" + LIBRARY_NAME + "] " + describe());
    }

    // STATIC METHOD: called through the interface name, Describable.printHeader(..)
    static void printHeader(String title) {
        System.out.println();
        System.out.println("===== " + title + " =====");
    }
}
