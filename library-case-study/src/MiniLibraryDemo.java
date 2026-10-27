/**
 * Demo / test driver. Every result is printed next to its "expected" value,
 * so you can see immediately that the program behaves as planned.
 *
 * Sections: 1 abstract class | 2 inheritance + polymorphism | 3 interface Describable
 *           4 interface Renewable | 5 fines (polymorphism) | 6 static / constants
 */
public class MiniLibraryDemo {

    // tiny helper: prints  label: actual (expected: x) -> OK / WRONG
    private static void check(String label, String actual, String expected) {
        String verdict = "WRONG";
        if (actual.equals(expected)) {
            verdict = "OK";
        }
        System.out.println(label + ": " + actual + "  (expected: " + expected + ") -> " + verdict);
    }

    public static void main(String[] args) {

        // ---------- setup: members HAVE items ----------
        LibraryMember rina  = new LibraryMember("Rina", "Lestari");
        LibraryMember dimas = new LibraryMember("Dimas", "Putra");

        Book     book1 = new Book(2001, "Java Basics", "Ani Wijaya");   // 3 parameters
        Magazine mag1  = new Magazine(2002, "Tech Monthly", 45);
        Book     book2 = new Book(2003, "Data Structures");             // overloaded constructor: author "Unknown"

        // ---------- 1. ABSTRACT CLASS ----------
        Describable.printHeader("1. Abstract class");
        // LibraryItem x = new LibraryItem(1, "Test");   // <- COMPILE ERROR: LibraryItem is abstract
        System.out.println("LibraryItem is abstract, so only its concrete subclasses can be created.");

        // ---------- 2. INHERITANCE + POLYMORPHISM ----------
        Describable.printHeader("2. Inheritance + polymorphism");
        // ONE array typed with the PARENT class holds two different child classes.
        LibraryItem[] all = { book1, mag1, book2 };
        for (LibraryItem i : all) {
            System.out.println(i.describe());          // same call, different text per class
        }

        System.out.println();
        System.out.println("Loan period of every item (same call, different values):");
        int[] expectedDays = { 14, 3, 14 };
        for (int k = 0; k < all.length; k++) {
            check("  " + all[k], "" + all[k].getLoanDays(), "" + expectedDays[k]);   // dynamic binding
        }

        System.out.println();
        System.out.println("Borrowing (the shared concrete method from LibraryItem):");
        check("  Rina borrows Book #2001", "" + rina.borrow(book1), "true");
        check("  Rina borrows Magazine #2002", "" + rina.borrow(mag1), "true");
        check("  Dimas borrows Book #2003", "" + dimas.borrow(book2), "true");
        check("  Dimas borrows Book #2001 (already taken)", "" + dimas.borrow(book1), "false");

        // ---------- 3. INTERFACE: Describable (unrelated classes, one contract) ----------
        Describable.printHeader("3. Interface Describable (LibraryMember and LibraryItem are unrelated)");
        Describable[] things = { rina, book1 };
        for (Describable d : things) {
            d.printInfo();                             // default method from the interface
        }

        // ---------- 4. INTERFACE: Renewable ----------
        Describable.printHeader("4. Interface Renewable");
        for (LibraryItem i : all) {
            System.out.println(i + " is Renewable? " + (i instanceof Renewable));
        }
        Renewable r = book1;                           // used through the INTERFACE type
        check("Renew Book #2001, 1st time", "" + r.renew(), "true");
        check("Renew Book #2001, 2nd time", "" + r.renew(), "true");
        check("Renew Book #2001, 3rd time (limit is " + Renewable.MAX_RENEWALS + ")", "" + r.renew(), "false");
        check("Renewal count of Book #2001", "" + r.getRenewalCount(), "2");

        // ---------- 5. POLYMORPHISM: fines ----------
        Describable.printHeader("5. Fines (one call, different behaviours)");
        check("Fine of Book #2001 for 5 days late (5 x 500)", "" + book1.calculateFine(5), "2500.0");
        check("Fine of Magazine #2002 for 5 days late (5 x 1000)", "" + mag1.calculateFine(5), "5000.0");
        check("Fine of Magazine #2002 for 0 days late", "" + mag1.calculateFine(0), "0.0");
        check("Rina total fine, 5 days late (2500 + 5000)", "" + rina.calculateTotalFine(5), "7500.0");
        check("Dimas total fine, 5 days late (2500)", "" + dimas.calculateTotalFine(5), "2500.0");

        System.out.println();
        check("Rina returns Book #2001", "" + book1.returnItem(), "true");
        check("Rina returns Book #2001 again", "" + book1.returnItem(), "false");
        System.out.println(book1.describe());

        // ---------- 6. STATIC / CONSTANTS ----------
        Describable.printHeader("6. Constants");
        check("LibraryItem.DEFAULT_FINE_PER_DAY", "" + LibraryItem.DEFAULT_FINE_PER_DAY, "500.0");
        check("Magazine.FINE_PER_DAY", "" + Magazine.FINE_PER_DAY, "1000.0");
        check("Renewable.MAX_RENEWALS", "" + Renewable.MAX_RENEWALS, "2");
        check("Describable.LIBRARY_NAME", Describable.LIBRARY_NAME, "UNRAM Mini Library");
    }
}
