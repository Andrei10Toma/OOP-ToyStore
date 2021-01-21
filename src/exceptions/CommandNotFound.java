package exceptions;

/**
 * Exception thrown if the given command at input is invalid.
 */
public class CommandNotFound extends Exception {
    /**
     * Constructor for the exception.
     * @param message printed message for the exception.
     */
    public CommandNotFound(String message) {
        super(message);
    }
}
