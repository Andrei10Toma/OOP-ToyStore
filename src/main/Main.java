package main;

import command.*;
import currency.Currency;
import exceptions.*;
import helper.Helper;
import store.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * The main class where the main function is located.
 */
public class Main {
    private static final int TEST_NUMBER = 5; // enter a number between 1 and 5 to run one of the 5 tests
    private static final String INPUT_FILE = "tests/input/test" + TEST_NUMBER;
    private static final String OUTPUT_FILE = "tests/output/test" + TEST_NUMBER + "/test" + TEST_NUMBER + ".out";
    private static final String ERR_FILE = "tests/output/test" + TEST_NUMBER + "/test" + TEST_NUMBER + ".err";

    /**
     * Method that reads the input from a file, prints the messages in an output file and the exceptions in an err file.
     * Initialise the store, the command queue and add the first Currency object (EUR) in the list of currencies of
     * the store. Interprets the commands read from file and after executes them.
     * @param args not used here.
     */
    public static void main(String[] args) {
        try (
                Scanner scanner = new Scanner(new FileReader(new File(INPUT_FILE)));
                PrintStream out = new PrintStream(new File(OUTPUT_FILE));
                PrintStream err = new PrintStream(new File(ERR_FILE))) {
            System.out.println("Starting program, wait for the end of the execution.");
            System.setOut(out);
            System.setErr(err);
            Currency initialCurrency = new Currency("EUR", "€", 1.0);
            CommandQueue commandQueue = new CommandQueue();
            Store store = Store.getInstance();
            store.getCurrencies().add(initialCurrency);
            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(" ");
                if (!command[0].equals("#")) {
                    interpretCommand(commandQueue, store, command);
                }
            }
            commandQueue.executeCommands();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Interprets the command read from the input file.
     * @param commandQueue the command queue that will be executed.
     * @param store the instance of the store.
     * @param command the elements of the command.
     */
    private static void interpretCommand(CommandQueue commandQueue, Store store, String[] command) {
        try {
            switch (command[0]) {
                case "exit", "quit" -> commandQueue.executeCommands();
                case "listcurrencies" -> commandQueue.takeCommand(new ListCurrencies(store));
                case "getstorecurrency" -> commandQueue.takeCommand(new GetStoreCurrency(store));
                case "addcurrency" -> commandQueue.takeCommand(new AddCurrency(store,
                        new Currency(command[1], command[2], Double.parseDouble(command[3]))));
                case "setstorecurrency" -> commandQueue.takeCommand(new SetStoreCurrency(store, command[1]));
                case "loadcsv" -> commandQueue.takeCommand(new LoadCSV(store, command[1]));
                case "savecsv" -> commandQueue.takeCommand(new SaveCSV(store, command[1]));
                case "updateparity" -> commandQueue.takeCommand(new UpdateParity(store,
                        Double.parseDouble(command[2]), command[1]));
                case "listproducts" -> commandQueue.takeCommand(new ListProducts(store));
                case "showproduct" -> commandQueue.takeCommand(new ShowProduct(store, command[1]));
                case "listmanufacturers" -> commandQueue.takeCommand(new ListManufacturers(store));
                case "listproductsbymanufacturer" -> commandQueue.takeCommand(new ListProductsByManufacturer(store,
                        command));
                case "listdiscounts" -> commandQueue.takeCommand(new ListDiscounts(store));
                case "adddiscount" -> commandQueue.takeCommand(new AddDiscount(store, command));
                case "applydiscount" -> commandQueue.takeCommand(new ApplyDiscount(store,
                        Helper.convertStringToDiscountType(command[1]), Double.parseDouble(command[2])));
                case "calculatetotal" -> commandQueue.takeCommand(new CalculateTotal(store, command));
                case "savestore" -> commandQueue.takeCommand(new SaveStore(store, command[1]));
                case "loadstore" -> commandQueue.takeCommand(new LoadStore(store, command[1]));
                default -> throw new CommandNotFound("Input command " + command[0] + " not found.");
            }
        } catch (CommandNotFound e) {
            e.printStackTrace();
        }
    }
}
