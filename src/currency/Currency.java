package currency;

import java.io.Serializable;
import java.util.Objects;

/**
 * A serializable class that saves information about the currency of the store.
 */
public class Currency implements Serializable {
    /**
     * name of the currency
     */
    private String name;
    /**
     * symbol of the currency
     */
    private String symbol;
    /**
     * parity to EUR of the currency
     */
    private double parityToEur;

    /**
     * Constructor for the Currency class.
     * @param name name of the currency
     * @param symbol symbol of the currency
     * @param parityToEur parity to EUR of the currency
     */
    public Currency(String name, String symbol, double parityToEur) {
        this.name = name;
        this.symbol = symbol;
        this.parityToEur = parityToEur;
    }

    /**
     * Getter for the name of the currency.
     * @return name of the Currency.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the currency.
     * @param name the new value for the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the symbol of the currency.
     * @return symbol of the currency.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Setter for the symbol of the currency.
     * @param symbol the new value for the symbol.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Getter for the parity to EUR for the currency.
     * @return the parity to EUR.
     */
    public double getParityToEur() {
        return parityToEur;
    }

    /**
     * Setter for the parity to EUR of the currency.
     * @param parityToEur the new value for parity to EUR.
     */
    public void setParityToEur(double parityToEur) {
        this.parityToEur = parityToEur;
    }

    /**
     * Returns a String representation of the currency object.
     * @return String representation of the currency object.
     */
    @Override
    public String toString() {
        return name + " " + String.format("%,.02f", parityToEur);
    }

    /**
     * Checks if two currency objects are equal (have the same name).
     * @param o object to compare.
     * @return true if the currency objects have the same name and false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return name.equals(currency.name);
    }

    /**
     * Generates a hash code for the name.
     * @return hash of the name.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
