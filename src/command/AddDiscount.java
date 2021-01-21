package command;

import discount.Discount;
import discount.DiscountType;
import helper.Helper;
import store.Store;
import java.time.LocalDateTime;

/**
 * Class for adddiscount command.
 */
public class AddDiscount implements Command {
    private final Store store;
    private final String[] discountElements;

    /**
     * Constructor for AddDiscount object.
     * @param store instance of the store.
     * @param discount the discount that will be added to the list.
     */
    public AddDiscount(Store store, String[] discount) {
        this.store = store;
        this.discountElements = discount;
    }

    /**
     * Add the discount to the list of discounts if it is not a duplicate.
     * When the discount is created the lastDateApplied field will be the moment of creation.
     * @see Command
     */
    @Override
    public void execute() {
        DiscountType discountType = Helper.convertStringToDiscountType(discountElements[1]);
        StringBuilder discountName = new StringBuilder(discountElements[3] + " ");
        for (int i = 4; i < discountElements.length; i++) {
            discountName.append(discountElements[i]).append(" ");
        }
        store.getDiscounts().add(new Discount(discountName.toString(), discountType,
                Double.parseDouble(discountElements[2]), LocalDateTime.now().withNano(0)));
    }
}
