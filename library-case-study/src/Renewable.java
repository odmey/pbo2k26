/**
 * INTERFACE: Renewable  ("can be renewed")
 *
 * Only SOME library items can be renewed (a Book can, a Magazine cannot),
 * so "renewable" is a CAPABILITY (can-do), not a parent class (is-a).
 */
public interface Renewable {

    // CONSTANT: public static final automatically.
    int MAX_RENEWALS = 2;

    /** Try to extend the loan. Returns true if it worked. */
    boolean renew();

    /** How many times this item has been renewed so far. */
    int getRenewalCount();
}
