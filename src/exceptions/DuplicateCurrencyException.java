package exceptions;

/**
 * Exception for duplicate currency in the store.
 */
public class DuplicateCurrencyException extends Exception{
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public DuplicateCurrencyException(String message) {
        super(message);
    }
}
