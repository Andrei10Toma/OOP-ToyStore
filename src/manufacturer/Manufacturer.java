package manufacturer;

import java.io.Serializable;

/**
 * Serializable class that saves the manufacturers information from the store.
 */
public class Manufacturer implements Serializable {
    /**
     * name of the manufacturer
     */
    private String name;
    /**
     * number of products of every manufacturer
     */
    private int countProducts;

    /**
     * Constructor for a manufacturer object.
     * @param name name of the manufacturer.
     * @param countProducts number of products that each manufacturer has.
     */
    public Manufacturer(String name, int countProducts) {
        this.name = name;
        this.countProducts = countProducts;
    }

    /**
     * Constructor for a manufacturer object only with name.
     * @param name name of the manufacturer.
     */
    public Manufacturer(String name) {
        this.name = name;
    }

    /**
     * Getter for the name of the manufacturer.
     * @return name of the manufacturer.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the manufacturer.
     * @param name the new value for the name of the manufacturer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the countProducts field.
     * @return countProducts of the manufacturer.
     */
    public int getCountProducts() {
        return countProducts;
    }

    /**
     * Setter for the countProducts field.
     * @param countProducts new value of the countProducts.
     */
    public void setCountProducts(int countProducts) {
        this.countProducts = countProducts;
    }

    /**
     * String representation of the manufacturer object.
     * @return String representation of the manufacturer object.
     */
    @Override
    public String toString() {
        return name;
    }
}
