package command;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to maintain the order of the commands.
 */
public class CommandQueue {
    private final List<Command> commandList = new ArrayList<>();

    /**
     * Add a command to the command queue.
     * @param command the command that will be added.
     */
    public void takeCommand(Command command) {
        commandList.add(command);
    }

    /**
     * Execute all the commands from the queue.
     */
    public void executeCommands() {
        for (Command command: commandList) {
            command.execute();
        }
        commandList.clear();
        System.exit(0);
    }
}
