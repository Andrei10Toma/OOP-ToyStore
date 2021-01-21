package exceptions;

/**
 * Exception thrown if currency is not found.
 */
public class CurrencyNotFoundException extends Exception{
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public CurrencyNotFoundException(String message) {
        super(message);
    }
}
