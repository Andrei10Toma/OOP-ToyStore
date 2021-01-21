package command;

import currency.Currency;
import exceptions.CurrencyEURCantBeChanged;
import exceptions.CurrencyNotFoundException;
import store.Store;

/**
 * Class for updateparity command.
 */
public class UpdateParity implements Command {
    private final Store store;
    private final double newParity;
    private final String givenCurrencyName;

    /**
     * Constructor for UpdateParity object.
     * @param store instance of the store.
     * @param newParity new value of the parity.
     * @param givenCurrency name of the currency.
     */
    public UpdateParity(Store store, double newParity, String givenCurrency) {
        this.store = store;
        this.newParity = newParity;
        this.givenCurrencyName = givenCurrency;
    }

    /**
     * Search for the currency with the given name in the list of currencies. If it is found it is updated and, also,
     * if the store is currently on the given currency the currency of the store is updated. Else if it is not found
     * an exception is thrown.
     * @see Command
     */
    @Override
    public void execute() {
        try {
            if (givenCurrencyName.equals("EUR")) {
                throw new CurrencyEURCantBeChanged("The EUR currency can't be changed.");
            }
            boolean currencyFound = false;
            for (Currency curr : store.getCurrencies()) {
                if (curr.getName().equals(givenCurrencyName)) {
                    currencyFound = true;
                    curr.setParityToEur(newParity);
                    break;
                }
            }
            if (!currencyFound) {
                throw new CurrencyNotFoundException("Currency " + givenCurrencyName + " was not found.");
            } else if (store.getCurrency().getName().equals(givenCurrencyName)) {
                store.getCurrency().setParityToEur(newParity);
            }
        }
        catch (CurrencyNotFoundException | CurrencyEURCantBeChanged e) {
            e.printStackTrace();
        }
    }
}
