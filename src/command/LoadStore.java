package command;

import currency.Currency;
import discount.Discount;
import product.Product;
import store.Store;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Class for loadstore command.
 */
public class LoadStore implements Command {
    private final Store store;
    private final String filename;

    /**
     * Constructor for a LoadStore object.
     * @param store instance of the store.
     * @param filename the file where the store will be loaded.
     */
    public LoadStore(Store store, String filename) {
        this.store = store;
        this.filename = filename;
    }

    /**
     * Load an older state of the store. Suppressed the unchecked warnings, because the file we read should not be
     * empty.
     * @see Command
     */
    @Override
    @SuppressWarnings("unchecked")
    public void execute() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            store.setProducts((List<Product>) ois.readObject());
            store.setCurrency((Currency) ois.readObject());
            store.setDiscounts((List<Discount>) ois.readObject());
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
