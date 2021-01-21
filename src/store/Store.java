package store;

import currency.Currency;
import discount.Discount;
import discount.DiscountType;
import exceptions.*;
import helper.Helper;
import manufacturer.Manufacturer;
import org.apache.commons.lang3.tuple.Pair;
import product.Product;
import product.ProductBuilder;
import org.apache.commons.csv.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class that contains the information about a store.
 */
public class Store implements Serializable {
    /**
     * name of the store
     */
    private String name;
    /**
     * current currency of the store
     */
    private Currency currency;
    /**
     * list of products
     */
    private List<Product> products = new ArrayList<>();
    /**
     * list of manufacturers
     */
    private List<Manufacturer> manufacturers = new ArrayList<>();
    /**
     * list of currencies
     */
    private List<Currency> currencies = new ArrayList<>();
    /**
     * list of discounts
     */
    private List<Discount>  discounts = new ArrayList<>();
    /**
     * instance of store
     */
    private static Store instance;

    /**
     * Singleton design pattern (only one instance of a store).
     * @return instance of a Store.
     */
    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    /**
     * Private constructor for the store.
     */
    private Store() {
        this.name = "POO Store";
        this.currency = new Currency("EUR", "€", 1);
    }

    /**
     * Getter for the name of the store.
     * @return name of the store.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the store.
     * @param name new name of the store.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the currency of the store.
     * @return currency of the store.
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Setter for the currency of the store.
     * @param currency new currency for the store.
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * Getter for the list of products.
     * @return the list of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Setter for the list of products.
     * @param products the new list of products of the store.
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Getter for the list of manufacturers.
     * @return the manufacturers list of the store.
     */
    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * Setter for the list of manufacturers.
     * @param manufacturers the new list of manufacturers.
     */
    public void setManufacturers(List<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    /**
     * Getter for the currencies list.
     * @return the currencies list of the store.
     */
    public List<Currency> getCurrencies() {
        return currencies;
    }

    /**
     * Setter for the currencies list.
     * @param currencies the new list of currencies.
     */
    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    /**
     * Getter for the discounts list.
     * @return the discounts list of the store.
     */
    public List<Discount> getDiscounts() {
        return discounts;
    }

    /**
     * Setter for the discounts list.
     * @param discounts the new list of discounts.
     */
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    /**
     * If the manufacturer is already in the list the countProducts field of the manufacturer object will be
     * incremented, else a new Manufacturer object will be created and added to the manufacturers list.
     * @param manufacturerString manufacturer name or "Not Available" if the manufacturer record is empty.
     * @return the existent or the created manufacturer.
     */
    private Manufacturer createOrUpdateManufacturer(String manufacturerString) {
        Manufacturer manufacturerAdd;
        Manufacturer manufacturerFound = null;
        for (Manufacturer manufacturer : manufacturers) {
            if (manufacturer.getName().equals(manufacturerString)) {
                manufacturer.setCountProducts(manufacturer.getCountProducts() + 1);
                manufacturerFound = manufacturer;
                break;
            }
        }
        if (manufacturerFound == null) {
            manufacturerAdd = new Manufacturer(manufacturerString, 1);
            manufacturers.add(manufacturerAdd);
            manufacturerFound = manufacturerAdd;
        }
        return manufacturerFound;
    }

    /**
     * Adds a product in the products list.
     * @param record teh record extracted from the CSV file.
     * @throws DuplicateProductException if two products have the same id.
     * @throws CurrencyNotFoundException if the symbol of the current currency of the store is not the same as the
     * symbol extracted from the CSV record.
     */
    public void addProduct(CSVRecord record) throws DuplicateProductException, CurrencyNotFoundException {
        for (Product product : products) {
            if (product.getUniqueId().equals(record.get(0))) {
                throw new DuplicateProductException("Duplicate product found with id " + record.get(0) + ".");
            }
        }
        if (!record.get(3).isEmpty()) {
            Pair<Double, String> price = Helper.convertPrice(record.get(3));
            if (!price.getRight().equals(currency.getSymbol())) {
                throw new CurrencyNotFoundException("The store was set on " + currency.getSymbol() + "and not on " +
                        price.getRight() + ".");
            }
            String manufacturerString = Helper.getManufacturerString(record.get(2));
            Manufacturer manufacturer = createOrUpdateManufacturer(manufacturerString);
            products.add(new ProductBuilder()
                    .withUniqueId(record.get(0))
                    .withPrice(price.getLeft())
                    .withManufacturer(manufacturer)
                    .withName(record.get(1))
                    .withQuantity(Helper.convertQuantity(record.get(4)))
                    .build());
        }
    }

    /**
     * List information a product.
     * @param product the product object we will list information about.
     */
    public void listProduct(Product product) {
        System.out.println(product + currency.getSymbol() + String.format("%,.03f",product.getPrice())
                + "," + product.getQuantity());
    }

    /**
     * Applies a discount for all the products from the store.
     * @param applyDiscount the discount that will be applied.
     */
    public void applyDiscountProducts(Discount applyDiscount) {
        if (applyDiscount.getDiscountType() == DiscountType.PERCENTAGE_DISCOUNT) {
            for (Product product: products) {
                product.setPrice(product.getPrice() - product.getPrice() * applyDiscount.getValue() / 100);
            }
        }
        else {
            try {
                for (Product product: products) {
                    if (product.getPrice() - applyDiscount.getValue() < 0) {
                        throw new NegativePriceException("The product with price " + product.getPrice() + " and id " +
                                product.getUniqueId() + " cannot have a fixed discount of " + applyDiscount.getValue() +
                                " applied.");
                    }
                }
                for (Product product: products) {
                    product.setPrice(product.getPrice() - applyDiscount.getValue());
                }
            }
            catch (NegativePriceException e) {
                e.printStackTrace();
            }
        }
    }
}
