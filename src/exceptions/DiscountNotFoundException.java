package exceptions;

/**
 * Exception thrown when the discount is not found in the store.
 */
public class DiscountNotFoundException extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public DiscountNotFoundException(String message) {
        super(message);
    }
}
