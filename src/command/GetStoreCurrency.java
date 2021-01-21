package command;

import store.Store;

/**
 * Class for getstorecurrency command.
 */
public class GetStoreCurrency implements Command{
    private final Store store;

    /**
     * Constructor for GetStoreCurrency object.
     * @param store instance of store.
     */
    public GetStoreCurrency(Store store) {
        this.store = store;
    }

    /**
     * Print the name of the current currency of the store.
     * @see Command
     */
    @Override
    public void execute() {
        System.out.println(store.getCurrency().getName());
    }
}
