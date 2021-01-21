package discount;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A serializable class that saves information about the discounts of the store.
 */
public class Discount implements Serializable {
    /**
     * name of the discount
     */
    private String name;
    /**
     * type of the discount
     */
    private DiscountType discountType;
    /**
     * value of the discount
     */
    private double value;
    /**
     * last date when the discount was applied or the date when the discount was created
     */
    private LocalDateTime lastDateApplied;

    /**
     * Constructor for a discount object.
     * @param name name of the discount.
     * @param discountType type of the discount (FIXED or PERCENTAGE).
     * @param value value of the discount.
     * @param lastDateApplied the date when the discount was created, updated when the discount is applied.
     */
    public Discount(String name, DiscountType discountType, double value, LocalDateTime lastDateApplied) {
        this.name = name;
        this.discountType = discountType;
        this.value = value;
        this.lastDateApplied = lastDateApplied;
    }

    /**
     * Default constructor.
     */
    public Discount() {

    }

    /**
     * Getter for the name of the discount.
     * @return the name of the discount.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the discount.
     * @param name the new value of the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the discount type of the discount.
     * @return discount type.
     */
    public DiscountType getDiscountType() {
        return discountType;
    }

    /**
     * Setter for the discount type of the discount.
     * @param discountType the new value of the discount type.
     */
    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    /**
     * Getter for the value of the discount.
     * @return the value of the discount.
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter for the value of the discount.
     * @param value the new value of the discount.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Getter for the last date applied (if not applied yet, last date applied will be the creation date).
     * @return the last date applied (or the creation date) of the discount.
     */
    public LocalDateTime getLastDateApplied() {
        return lastDateApplied;
    }

    /**
     * Setter for the last date applied.
     * @param lastDateApplied the new value for the last date applied.
     */
    public void setLastDateApplied(LocalDateTime lastDateApplied) {
        this.lastDateApplied = lastDateApplied;
    }

    /**
     * String representation of the Discount object.
     * @return String representation of Discount object.
     */
    @Override
    public String toString() {
        return discountType + " " + value + " " + name +  lastDateApplied;
    }
}
