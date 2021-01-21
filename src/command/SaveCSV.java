package command;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import product.Product;
import store.Store;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class for savecsv command.
 */
public class SaveCSV implements Command {
    private final Store store;
    private final String filename;

    /**
     * Constructor for SaveCSV object.
     * @param store instance of the store.
     * @param filename the file where the CSV will be saved.
     */
    public SaveCSV(Store store, String filename) {
        this.store = store;
        this.filename = filename;
    }

    /**
     * Write the products of the store in the given CSV file.
     * @see Command
     */
    @Override
    public void execute() {
        try (
                FileWriter out = new FileWriter(filename);
                CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                        .withHeader("uniq_id", "product_name", "manufacturer", "price", "number_available_in_stock"))
        ) {
            for (Product product : store.getProducts()) {
                printer.printRecord(product.getUniqueId(),
                        product.getName(),
                        product.getManufacturer().getName(),
                        store.getCurrency().getSymbol() + String.format("%,.03f", product.getPrice()),
                        product.getQuantity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
