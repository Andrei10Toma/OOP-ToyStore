package command;

import manufacturer.Manufacturer;
import store.Store;
import java.util.Comparator;

/**
 * Class for listmanufacturers command.
 */
public class ListManufacturers implements Command {
    private final Store store;

    /**
     * Constructor for ListManufacturers object.
     * @param store instance of the store.
     */
    public ListManufacturers(Store store) {
        this.store = store;
    }

    /**
     * Print the sorted list of manufacturers, if the name of the manufacturer is available.
     * @see Command
     */
    @Override
    public void execute() {
        store.getManufacturers().sort(Comparator.comparing(Manufacturer::getName));
        for (Manufacturer manufacturer : store.getManufacturers()) {
            if (!manufacturer.getName().equals("Not Available")) {
                System.out.println(manufacturer);
            }
        }
    }
}
