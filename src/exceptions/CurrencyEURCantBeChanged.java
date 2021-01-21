package exceptions;

/**
 * Exception if the user tries to change parity of the EUR currency.
 */
public class CurrencyEURCantBeChanged extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public CurrencyEURCantBeChanged(String message) {
        super(message);
    }
}
