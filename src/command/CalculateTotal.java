package command;

import exceptions.ProductNotFound;
import product.Product;
import store.Store;

/**
 * Class for the calculatetotal command.
 */
public class CalculateTotal implements Command {
    private final Store store;
    private final String[] productsId;

    /**
     * Constructor for CalculateTotal object.
     * @param store instance of the store.
     * @param productsId the ids of the products that
     */
    public CalculateTotal(Store store, String[] productsId) {
        this.store = store;
        this.productsId = productsId;
    }

    /**
     * Calculates the total price of the given products with the given IDs, if all products exist.
     * If one id is not found in the product list an exception will be thrown.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            double total = 0;
            for (int i = 1; i < productsId.length; i++) {
                boolean productFound = false;
                for (Product product : store.getProducts()) {
                    if (product.getUniqueId().equals(productsId[i])) {
                        productFound = true;
                        total += product.getPrice();
                    }
                }
                if (!productFound) {
                    throw new ProductNotFound("Product with ID " + productsId[i] + " not found.");
                }
            }
            System.out.println(store.getCurrency().getSymbol() + String.format("%,.03f", total));
        }
        catch (ProductNotFound e) {
            e.printStackTrace();
        }
    }
}
