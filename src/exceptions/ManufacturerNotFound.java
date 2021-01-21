package exceptions;

/**
 * Exception thrown when the manufacturer is not found in the store.
 */
public class ManufacturerNotFound extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public ManufacturerNotFound(String message) {
        super(message);
    }
}
