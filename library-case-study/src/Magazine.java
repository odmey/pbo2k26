/**
 * CONCRETE class #2: short loan, higher fine.
 * It does NOT implement Renewable: a magazine cannot be renewed.
 *
 * It OVERRIDES calculateFine() with another rule than LibraryItem.calculateFine():
 * same name and parameters, different behaviour = RUN-TIME POLYMORPHISM.
 */
public class Magazine extends LibraryItem {

    public static final double FINE_PER_DAY = 1000.0;   // constant: static final

    private int issueNumber;

    public Magazine(int itemId, String title, int issueNumber) {
        super(itemId, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate > 0) {
            return daysLate * FINE_PER_DAY;      // double the default fine
        }
        return 0.0;
    }

    @Override
    public String getItemType() { return "Magazine"; }

    @Override
    public int getLoanDays() { return 3; }

    @Override
    public String describe() {
        return super.describe() + " | issue: " + issueNumber;
    }
}
