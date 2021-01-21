package command;

import exceptions.ManufacturerNotFound;
import product.Product;
import store.Store;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for listproductsbymanufacturer command.
 */
public class ListProductsByManufacturer implements Command {
    private final Store store;
    private final String[] manufacturerNameElements;

    /**
     * Constructor for ListProductsByManufacturer object.
     * @param store instance of store.
     * @param manufacturerNameElements split name of the manufacturer.
     */
    public ListProductsByManufacturer(Store store, String[] manufacturerNameElements) {
        this.store = store;
        this.manufacturerNameElements = manufacturerNameElements;
    }

    /**
     * Create the manufacturer name.
     * @return the manufacturer name.
     */
    private String createManufacturerName() {
        StringBuilder manufacturerName = new StringBuilder();
        for (int i = 1; i < manufacturerNameElements.length; i++) {
            manufacturerName.append(manufacturerNameElements[i]).append(" ");
        }
        return String.valueOf(manufacturerName.deleteCharAt(manufacturerName.length() - 1));
    }

    /**
     * Print the products manufactured by the manufacturer with the given name, if the manufacturer with the given name
     * exists. Else an exception is thrown.
     * @see Command
     */
    @Override
    public void execute() {
        String manufacturerName = createManufacturerName();
        try {
            List<Product> manufacturerProducts = store.getProducts()
                    .stream()
                    .filter(product -> product.getManufacturer().getName().equals(manufacturerName))
                    .collect(Collectors.toList());
            if (manufacturerProducts.isEmpty()) {
                throw new ManufacturerNotFound("Manufacturer with name " + manufacturerName + " was not found.");
            }
            for (Product product: manufacturerProducts) {
                store.listProduct(product);
            }
        } catch (ManufacturerNotFound e) {
            e.printStackTrace();
        }
    }
}
