package command;

import product.Product;
import store.Store;

/**
 * Class for listproducts command.
 */
public class ListProducts implements Command {
    private final Store store;

    /**
     * Constructor for ListProducts object.
     * @param store instance of the store
     */
    public ListProducts(Store store) {
        this.store = store;
    }

    /**
     * Prints all the products existent in the store.
     * @see Command
     */
    @Override
    public void execute() {
        for (Product product : store.getProducts()) {
            store.listProduct(product);
        }
    }
}
