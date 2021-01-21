package command;

import currency.Currency;
import exceptions.CurrencyNotFoundException;
import product.Product;
import store.Store;

/**
 * Class for setstorecurrency command.
 */
public class SetStoreCurrency implements Command {
    private final Store store;
    private final String givenCurrency;

    /**
     * Constructor for SetStoreCurrency object.
     * @param store instance of the store.
     * @param givenCurrency the currency in which the store will be changed.
     */
    public SetStoreCurrency(Store store, String givenCurrency) {
        this.store = store;
        this.givenCurrency = givenCurrency;
    }

    /**
     * Searches for the given currency in the list of currencies. If it is found the currency of the store is updated
     * and the price of products are updated with the new currency. Else an exception is thrown.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            boolean foundCurrency = false;
            double lastParityToEur = store.getCurrency().getParityToEur();
            for (Currency currency : store.getCurrencies()) {
                if (currency.getName().equals(givenCurrency)) {
                    foundCurrency = true;
                    store.setCurrency(currency);
                    break;
                }
            }
            if (!foundCurrency) {
                throw new CurrencyNotFoundException("Currency with name " + givenCurrency + " not found.");
            }
            else {
                for (Product product: store.getProducts()) {
                    product.setPrice(product.getPrice() / store.getCurrency().getParityToEur() * lastParityToEur);
                }
            }
        }
        catch (CurrencyNotFoundException e) {
            e.printStackTrace();
        }
    }
}
