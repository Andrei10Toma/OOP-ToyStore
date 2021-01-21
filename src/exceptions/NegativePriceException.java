package exceptions;

/**
 * Exception for the negative price.
 */
public class NegativePriceException extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public NegativePriceException(String message) {
        super(message);
    }
}
