package command;

import exceptions.CurrencyNotFoundException;
import exceptions.DuplicateProductException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import store.Store;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Class for loadcsv command.
 */
public class LoadCSV implements Command{
    private final Store store;
    private final String filename;

    /**
     * Constructor for LoadCSV object.
     * @param store instance of the store.
     * @param filename the input CSV filename.
     */
    public LoadCSV(Store store, String filename) {
        this.store = store;
        this.filename = filename;
    }

    /**
     * Fill the store with products from the given CSV file.
     * @see Command
     */
    @Override
    public void execute() {
        try (Reader fileReader = new FileReader(filename)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(fileReader);
            for (CSVRecord record : records) {
                store.addProduct(record);
            }
        } catch (IOException | DuplicateProductException | CurrencyNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}

