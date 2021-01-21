package exceptions;

/**
 * Exception for duplicate products in the store.
 */
public class DuplicateProductException extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public DuplicateProductException(String message) {
        super(message);
    }
}
