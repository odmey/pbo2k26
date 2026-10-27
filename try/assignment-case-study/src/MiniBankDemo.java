/**
 * Demo / test driver. Every result is printed next to its "expected" value,
 * so you can see immediately that the program behaves as planned.
 *
 * Sections: 1 abstract class | 2 inheritance + polymorphism | 3 interface Reportable
 *           4 interface InterestBearing | 5 month end (polymorphism) | 6 static / constants
 */
public class MiniBankDemo {

    // tiny helper: prints  label: actual (expected: x) -> OK / WRONG
    private static void check(String label, String actual, String expected) {
        String verdict = actual.equals(expected) ? "OK" : "WRONG";
        System.out.println(label + ": " + actual + "  (expected: " + expected + ") -> " + verdict);
    }

    public static void main(String[] args) {

        // ---------- setup: customers HAVE accounts ----------
        BankCustomer akbar = new BankCustomer("Akbar", "Pratama");
        BankCustomer citra = new BankCustomer("Citra", "Dewi");

        SavingsAccount  savings1 = new SavingsAccount(1001, 1000.0, 0.12);  // 12% per year
        CheckingAccount checking = new CheckingAccount(1002, 500.0, 300.0); // overdraft 300
        SavingsAccount  savings2 = new SavingsAccount(1003, 300.0);         // overloaded constructor: default 4%

        akbar.addAccount(savings1);
        akbar.addAccount(checking);
        citra.addAccount(savings2);

        // ---------- 1. ABSTRACT CLASS ----------
        Reportable.printHeader("1. Abstract class");
        // BaseAccount a = new BaseAccount(1, 100);   // <- COMPILE ERROR: BaseAccount is abstract
        System.out.println("BaseAccount is abstract, so only its concrete subclasses can be created.");

        // ---------- 2. INHERITANCE + POLYMORPHISM ----------
        Reportable.printHeader("2. Inheritance + polymorphism");
        // ONE array typed with the PARENT class holds two different child classes.
        BaseAccount[] all = { savings1, checking, savings2 };
        for (BaseAccount a : all) {
            System.out.println(a.toReport());          // same call, different text per class
        }

        System.out.println();
        System.out.println("Withdraw 600 from every account (same call, different rules):");
        boolean[] expected = { true, true, false };
        String[] why = {
                "Savings: 1000 >= 600",
                "Checking: 500 + overdraft 300 = 800 >= 600",
                "Savings: 300 < 600" };
        for (int i = 0; i < all.length; i++) {
            boolean ok = all[i].withdraw(600);         // dynamic binding: the REAL object's method runs
            check("  " + all[i] + " (" + why[i] + ")", String.valueOf(ok), String.valueOf(expected[i]));
        }
        check("Checking balance is now", String.valueOf(checking.getBalance()), "-100.0");

        // ---------- 3. INTERFACE: Reportable (unrelated classes, one contract) ----------
        Reportable.printHeader("3. Interface Reportable (BankCustomer and BaseAccount are unrelated)");
        Reportable[] items = { akbar, savings1 };
        for (Reportable r : items) {
            r.printReport();                           // default method from the interface
        }

        // ---------- 4. INTERFACE: InterestBearing ----------
        Reportable.printHeader("4. Interface InterestBearing");
        for (BaseAccount a : all) {
            System.out.println(a + " is InterestBearing? " + (a instanceof InterestBearing));
        }
        InterestBearing[] earners = { savings1, savings2 };   // used through the INTERFACE type
        check("Interest of Savings #1001 this month", String.valueOf(earners[0].calculateInterest()), "4.0");
        check("Interest of Savings #1003 this month", String.valueOf(earners[1].calculateInterest()), "1.0");

        // ---------- 5. POLYMORPHISM: month end ----------
        Reportable.printHeader("5. Month end (one call, different behaviours)");
        akbar.monthEnd();
        citra.monthEnd();
        check("Savings #1001 (interest 4.0)", String.valueOf(savings1.getBalance()), "404.0");
        check("Checking #1002 (fee 5.0)", String.valueOf(checking.getBalance()), "-105.0");
        check("Savings #1003 (interest 1.0)", String.valueOf(savings2.getBalance()), "301.0");
        check("Akbar total (404.0 + -105.0)", String.valueOf(akbar.getTotalBalance()), "299.0");

        System.out.println();
        for (BaseAccount a : all) {
            System.out.println(a.toReport());
        }

        // ---------- 6. STATIC / CONSTANTS ----------
        Reportable.printHeader("6. Constants");
        check("CheckingAccount.MONTHLY_FEE", String.valueOf(CheckingAccount.MONTHLY_FEE), "5.0");
        check("SavingsAccount.DEFAULT_RATE", String.valueOf(SavingsAccount.DEFAULT_RATE), "0.04");
        check("Reportable.BANK_NAME", Reportable.BANK_NAME, "UNRAM Mini Bank");
    }
}
