/**
 * ABSTRACT CLASS: LibraryItem  (the "is-a" parent of every item type)
 *
 * An abstract class is a PARTIALLY COMPLETE class:
 *  - it has real fields and a constructor,
 *  - it has concrete methods (borrowItem, returnItem, calculateFine, describe),
 *  - it has ABSTRACT methods = requirements that every concrete subclass MUST implement.
 *
 * new LibraryItem(...) does NOT compile:
 *     error: LibraryItem is abstract; cannot be instantiated
 *
 * LibraryItem also implements Describable, so every item IS-A Describable too.
 */
public abstract class LibraryItem implements Describable {

    public static final double DEFAULT_FINE_PER_DAY = 500.0;   // constant: static final

    private final int itemId;        // private: only reachable through the getter
    private String title;            // private: encapsulation
    protected boolean borrowed;      // protected: subclasses may use it directly

    // Constructor of an abstract class: runs when a subclass calls super(...).
    public LibraryItem(int itemId, String title) {
        this.itemId = itemId;
        if (title != null) {         // validation: never keep a null title
            this.title = title;
        } else {
            this.title = "Untitled";
        }
    }

    public int getItemId() { return itemId; }

    public String getTitle() { return title; }

    public boolean isBorrowed() { return borrowed; }

    // CONCRETE method: the same for every item type.
    public boolean borrowItem() {
        if (!borrowed) {
            borrowed = true;
            return true;
        }
        return false;
    }

    // CONCRETE method: the same for every item type.
    public boolean returnItem() {
        if (borrowed) {
            borrowed = false;
            return true;
        }
        return false;
    }

    // CONCRETE method with a default rule. Subclasses may OVERRIDE it.
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * DEFAULT_FINE_PER_DAY;
        }
        return 0.0;
    }

    // ---------- ABSTRACT METHODS: "what", without "how" ----------

    /** Every item type must give its own name. */
    public abstract String getItemType();

    /** Every item type has its own loan period (in days). */
    public abstract int getLoanDays();

    // ---------- Describable contract ----------

    /** A concrete method that calls abstract ones: the REAL object's version runs. */
    @Override
    public String describe() {
        String status = "available";
        if (borrowed) {
            status = "borrowed";
        }
        return "#" + itemId + " " + getItemType() + " \"" + title + "\""
                + " | loan: " + getLoanDays() + " days | " + status;
    }

    @Override
    public String toString() {
        return getItemType() + " #" + itemId;
    }
}
