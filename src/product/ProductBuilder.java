package product;

import discount.Discount;
import manufacturer.Manufacturer;

/**
 * Builder for the Product object.
 */
public class ProductBuilder {
    private final Product product = new Product();

    /**
     * Sets the value for uniqueId of the product.
     * @param uniqueId given unique id.
     * @return ProductBuilder object.
     */
    public ProductBuilder withUniqueId(String uniqueId) {
        product.setUniqueId(uniqueId);
        return this;
    }

    /**
     * Sets the name of the product.
     * @param name name of the product.
     * @return ProductBuilder object.
     */
    public ProductBuilder withName(String name) {
        product.setName(name);
        return this;
    }

    /**
     * Sets the manufacturer of the product.
     * @param manufacturer manufacturer of the product.
     * @return ProductBuilder object.
     */
    public ProductBuilder withManufacturer(Manufacturer manufacturer) {
        product.setManufacturer(manufacturer);
        return this;
    }

    /**
     * Sets the price of the product.
     * @param price price of the product.
     * @return ProductBuilder object.
     */
    public ProductBuilder withPrice(double price) {
        product.setPrice(price);
        return this;
    }

    /**
     * Sets the quantity of the product.
     * @param quantity quantity of the product.
     * @return ProductBuilder object.
     */
    public ProductBuilder withQuantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }

    /**
     * Sets the discount of the product.
     * @param discount discount of the product
     * @return ProductBuilder object.
     */
    public ProductBuilder withDiscount(Discount discount) {
        product.setDiscount(discount);
        return this;
    }

    /**
     * Builds the product.
     * @return Product object.
     */
    public Product build() {
        return product;
    }
}