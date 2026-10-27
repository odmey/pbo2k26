/**
 * CONCRETE class #1.
 *   extends    LibraryItem -> INHERITANCE (is-a)
 *   implements Renewable   -> INTERFACE   (can-do)
 *
 * Being concrete, it must implement every abstract method it received:
 * getItemType() and getLoanDays() (from LibraryItem),
 * renew() and getRenewalCount() (from Renewable).
 */
public class Book extends LibraryItem implements Renewable {

    public static final String UNKNOWN_AUTHOR = "Unknown";   // constant: static final

    private String author;
    private int renewalCount;

    public Book(int itemId, String title, String author) {
        super(itemId, title);        // super(...) is the FIRST line
        this.author = author;
    }

    // OVERLOADING (compile-time polymorphism): same name, different parameters.
    public Book(int itemId, String title) {
        this(itemId, title, UNKNOWN_AUTHOR);
    }

    public String getAuthor() { return author; }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public int getLoanDays() { return 14; }

    @Override
    public boolean renew() {
        // only an item that is currently borrowed can be renewed, and only a limited number of times
        if (borrowed && renewalCount < MAX_RENEWALS) {
            renewalCount = renewalCount + 1;
            return true;
        }
        return false;
    }

    @Override
    public int getRenewalCount() { return renewalCount; }

    @Override
    public String describe() {
        return super.describe() + " | author: " + author + " | renewals: " + renewalCount;
    }
}
