package command;

import currency.Currency;
import store.Store;

/**
 * Class for listcurrencies command.
 */
public class ListCurrencies implements Command{
    private final Store store;

    /**
     * Constructor for ListCurrencies object.
     * @param store instance of store.
     */
    public ListCurrencies(Store store) {
        this.store = store;
    }

    /**
     * Print all the currencies from the list of currencies.
     * @see Command
     */
    @Override
    public void execute() {
        for (Currency currency: store.getCurrencies()) {
            System.out.println(currency);
        }
    }
}
