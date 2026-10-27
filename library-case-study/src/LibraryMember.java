import java.util.ArrayList;

/**
 * LibraryMember is NOT an item, it HAS items (has-a / composition).
 *   "A member IS AN item"  -> wrong
 *   "A member HAS items"   -> right
 *
 * The list is declared with the PARENT type, so one ArrayList can hold
 * Book and Magazine objects together.
 *
 * LibraryMember and LibraryItem have no common parent, but both implement Describable.
 */
public class LibraryMember implements Describable {

    private final String firstName;
    private final String lastName;
    private final ArrayList<LibraryItem> items = new ArrayList<>();

    public LibraryMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    // The item is added only if it could really be borrowed (not already taken).
    public boolean borrow(LibraryItem item) {
        if (item.borrowItem()) {
            items.add(item);
            return true;
        }
        return false;
    }

    public LibraryItem getItem(int index) { return items.get(index); }

    public int getNumOfItems() { return items.size(); }

    /**
     * POLYMORPHISM in action: one line, i.calculateFine(daysLate), but the REAL object decides
     * the amount (Book uses the default rule, Magazine uses its own).
     */
    public double calculateTotalFine(int daysLate) {
        double total = 0;
        for (LibraryItem i : items) {
            total = total + i.calculateFine(daysLate);
        }
        return total;
    }

    @Override
    public String describe() {
        return "Member " + firstName + " " + lastName
                + " | items: " + items.size();
    }
}
