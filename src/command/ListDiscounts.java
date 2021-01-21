package command;

import discount.Discount;
import store.Store;

/**
 * Class for listdiscounts command.
 */
public class ListDiscounts implements Command {
    private final Store store;

    /**
     * Constructor for ListDiscounts object.
     * @param store instance of store.
     */
    public ListDiscounts(Store store) {
        this.store = store;
    }

    /**
     * Print all the discounts from the list of discounts.
     * @see Command
     */
    @Override
    public void execute() {
        if (!store.getDiscounts().isEmpty()) {
            for (Discount discount : store.getDiscounts()) {
                System.out.println(discount);
            }
        }
    }
}
