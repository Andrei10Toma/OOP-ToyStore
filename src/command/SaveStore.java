package command;

import store.Store;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Class for savestore command.
 */
public class SaveStore implements Command {
    private final Store store;
    private final String filename;

    /**
     * Constructor for SaveStore object.
     * @param store instance of the store.
     * @param filename file where the state of the store will be saved.
     */
    public SaveStore(Store store, String filename) {
        this.store = store;
        this.filename = filename;
    }

    /**
     * Saves the products, the current currency and the list of discounts in a binary file.
     * @see Command
     */
    @Override
    public void execute() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(store.getProducts());
            oos.writeObject(store.getCurrency());
            oos.writeObject(store.getDiscounts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
