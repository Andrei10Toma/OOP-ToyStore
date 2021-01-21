package command;

import currency.Currency;
import exceptions.DuplicateCurrencyException;
import store.Store;

/**
 * Class for the addcurrency command.
 */
public class AddCurrency implements Command{
    private final Store store;
    private final Currency currencyAdd;

    /**
     * Constructor for AddCurrency object.
     * @param store instance of the store.
     * @param addCurrency the currency that will be added in the list of currencies.
     */
    public AddCurrency(Store store, Currency addCurrency) {
        this.store = store;
        this.currencyAdd = addCurrency;
    }

    /**
     * Add the currency to the list of currencies if it is not a duplicate.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            for (Currency currency : store.getCurrencies()) {
                if (currency.equals(currencyAdd)) {
                    throw new DuplicateCurrencyException("Currency with name " + currencyAdd.getName() + " tried to be" +
                            " added");
                }
            }
            store.getCurrencies().add(currencyAdd);
        }
        catch (DuplicateCurrencyException e) {
            e.printStackTrace();
        }
    }
}
