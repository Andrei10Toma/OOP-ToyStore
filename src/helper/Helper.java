package helper;

import discount.DiscountType;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Helper class for some methods.
 */
public class Helper {
    /**
     * Private constructor so the user can't create an instance of this class.
     */
    private Helper() {
    }

    /**
     * Converting a String to DiscountType
     * @param discountTypeString discount type given as String (PERCENTAGE or FIXED).
     * @return discount type converted from the String.
     */
    public static DiscountType convertStringToDiscountType(String discountTypeString) {
        DiscountType discountType;
        if (discountTypeString.equals("PERCENTAGE")) {
            discountType = DiscountType.PERCENTAGE_DISCOUNT;
        }
        else {
            discountType = DiscountType.FIXED_DISCOUNT;
        }
        return discountType;
    }

    /**
     * Interpret the manufacturer String.
     * @param givenManufacturerString String read from the CSV file.
     * @return "Not Available" if the manufacturer String is empty, else the name of the manufacturer from the CSV.
     */
    public static String getManufacturerString(String givenManufacturerString) {
        if (givenManufacturerString.isEmpty()) {
            return "Not Available";
        } else {
            return givenManufacturerString;
        }
    }

    /**
     * Convert the quantity read from the CSV in int.
     * @param stringQuantity String read from the CSV file in the quantity column.
     * @return quantity converted to int.
     */
    public static int convertQuantity(String stringQuantity) {
        if (stringQuantity.equals("")) {
            return 0;
        } else {
            return Integer.parseInt(stringQuantity.split(Character.toString(160))[0]);
        }
    }

    /**
     * Converts the price read from the CSV file in value and Symbol.
     * @param priceWithCurrencySymbol price read from the csv.
     * @return a Pair with the key as a double value read and with the value as the symbol.
     */
    public static Pair<Double, String> convertPrice(String priceWithCurrencySymbol) {
        MutablePair<Double, String> pricePair = new MutablePair<>();
        pricePair.setLeft(Double.parseDouble(priceWithCurrencySymbol
                .substring(1)
                .split(" ")[0]
                .replace(",","")));
        pricePair.setRight(Character.toString(priceWithCurrencySymbol.charAt(0)));
        return pricePair;
    }
}
