package command;

/**
 * Interface to declare the operation that every command will execute.
 */
public interface Command {
    /**
     * The action that every command will do.
     */
    void execute();
}
