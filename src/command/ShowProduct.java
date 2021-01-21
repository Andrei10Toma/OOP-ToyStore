package command;

import exceptions.ProductNotFound;
import product.Product;
import store.Store;


/**
 * Class fow showproduct command.
 */
public class ShowProduct implements Command {
    private final Store store;
    private final String productId;

    /**
     * Constructor for ShowProduct object.
     * @param store instance of the store.
     * @param productId id of the product.
     */
    public ShowProduct(Store store, String productId) {
        this.store = store;
        this.productId = productId;
    }

    /**
     * Search for the product with the given ID in the product list. If it is found, is printed in the output file, else
     * an exception is thrown.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            final Product[] productFound = new Product[1];
            store.getProducts()
                    .stream()
                    .filter(product -> product.getUniqueId().equals(productId))
                    .findFirst()
                    .ifPresent(product -> productFound[0] = product);
            if (productFound[0] == null) {
                throw new ProductNotFound("Product with id " + productId + " not found.");
            }
            else {
                store.listProduct(productFound[0]);
            }
        }
        catch (ProductNotFound e) {
            e.printStackTrace();
        }
    }
}