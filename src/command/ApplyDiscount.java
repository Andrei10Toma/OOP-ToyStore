package command;

import discount.Discount;
import discount.DiscountType;
import exceptions.DiscountNotFoundException;
import store.Store;
import java.time.LocalDateTime;

/**
 * Class for the applydiscount command.
 */
public class ApplyDiscount implements Command {
    private final Store store;
    private final DiscountType discountType;
    private final double discountValue;

    /**
     * Constructor for ApplyDiscount object.
     * @param store instance of the store.
     * @param discountType type of the discount.
     * @param value value of the discount.
     */
    public ApplyDiscount(Store store, DiscountType discountType, double value) {
        this.store = store;
        this.discountType = discountType;
        this.discountValue = value;
    }

    /**
     * Searches for the given Discount in the list of discounts, if it is not found throw exception.
     * If it is found the discount is applied for the products in the store and the lastDateApplied field is updated
     * with the current date and time.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            boolean foundDiscount = false;
            Discount applyDiscount = null;
            for (Discount discount : store.getDiscounts()) {
                if (discount.getDiscountType() == discountType && discount.getValue() == discountValue) {
                    foundDiscount = true;
                    applyDiscount = discount;
                    break;
                }
            }
            if (!foundDiscount) {
                throw new DiscountNotFoundException("Discount " + discountType + " " + discountValue + " not found.");
            } else {
                store.applyDiscountProducts(applyDiscount);
                applyDiscount.setLastDateApplied(LocalDateTime.now().withNano(0));
            }
        }
        catch (DiscountNotFoundException e) {
            e.printStackTrace();
        }
    }
}
