package product;

import discount.Discount;
import manufacturer.Manufacturer;

import java.io.Serializable;

/**
 * Serializable class that saves the information about a product of the store.
 */
public class Product implements Serializable {
    /**
     * unique ID of a product
     */
    private String uniqueId;
    /**
     * name of the product
     */
    private String name;
    /**
     * the manufacturer of the product
     */
    private Manufacturer manufacturer;
    /**
     * price of the product
     */
    private double price;
    /**
     * quantity of the product in the store
     */
    private int quantity;
    /**
     * the discount applied to the product
     */
    private Discount discount;

    /**
     * Getter for the unique ID of the product.
     * @return unique ID of the product.
     */
    public String getUniqueId() {
        return uniqueId;
    }

    /**
     * Setter for the unique ID of the product.
     * @param uniqueId the new unique ID of the product.
     */
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Getter for the name of the product.
     * @return the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the product.
     * @param name the new name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the manufacturer of the product.
     * @return the manufacturer of the product.
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    /**
     * Setter for the manufacturer of the product.
     * @param manufacturer the manufacturer of the product.
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Getter for the price of the product.
     * @return price of the product.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for the price of the product.
     * @param price the new price of the product.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the quantity of the product.
     * @return quantity of the product.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for the quantity of the product.
     * @param quantity the new value of the quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for the discount of the product.
     * @return discount of the product.
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Setter for the discount of the product.
     * @param discount the new value of the discount.
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * String representation of the product object.
     * @return String representation of the product object.
     */
    @Override
    public String toString() {
        return uniqueId + "," + name + "," + manufacturer + ",";
    }
}
