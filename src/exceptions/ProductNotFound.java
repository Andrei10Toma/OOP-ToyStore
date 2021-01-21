package exceptions;

/**
 * Exception for the product not found in the store.
 */
public class ProductNotFound extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public ProductNotFound(String message) {
        super(message);
    }
}
