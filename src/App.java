import java.util.ArrayList;
import java.util.Scanner;

/**
 * The App class includes the userinterface
 * and the different options for the itemRegister.
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class App {
    private ItemRegister itemRegister;

    /**
     * Constructor for app that takes an object of class
     * ItemRegister as the parameter.
     * @param itemRegister is the item-register that the
     *        application applys to
     */
    public App(ItemRegister itemRegister) {
        this.itemRegister = itemRegister;
    }

    /**
     * Shows the different options the user may choose from,
     * then calls the method getIntInput() to get the userinput.
     * 
     * @return menuchoice which is the option that the user picked
     */
    private int showMenu() {
        System.out.println("\n***** Item Register Application v1.0 *****\n");
        System.out.println("1. Add item");
        System.out.println("2. List all items");
        System.out.println("3. Search for item");
        System.out.println("4. Reduce stock");
        System.out.println("5. Add stock");
        System.out.println("6. Delete item");
        System.out.println("7. Load items (use ONLY for testing purposes)");
        System.out.println("8. Add item category");
        System.out.println("9. Quit");
        System.out.println("\nPlease enter a number between 1 and 9.\n");
        int menuChoice = 0;
        menuChoice = getIntInput();
        return menuChoice;
    }

    /**
     * Shows the Search-option-menu which shows the user the
     * different options of how to search for an item. Then calls
     * the method getIntInput() to get the userinput.
     * 
     * @return searchOption which is the option that the user picked
     */
    private int showSearchOptionMenu() {
        System.out.println();
        System.out.println("1. Search for item by item-number");
        System.out.println("2. Search for item by description");
        System.out.println("3. Search for item by both item-number and description");
        System.out.println("\nPlease enter a number between 1 and 3.\n");
        int searchOption = 0;
        searchOption = getIntInput();
        return searchOption;
    }

    /**
     * Takes all the items from a list that is given as the parameter, and then
     * shows the user those items with a correlating number, and lets the
     * user pick from those items by the getIntInput() method. If the user
     * types in an integer that does not correlate with an item, the method
     * prints out that the input is unrecognized and asks for a new input
     * 
     * @param listOfItems
     *            is the list of items that the user gets to choose from
     * @return itemchoice-1 which is the userinput-1 since the userinput will then
     *         correlate with the position of the item that they chose in the actual
     *         arrayList 'list of items'
     */
    private int showMultipleItemsMenu(ArrayList<Item> listOfItems) {
        int itemChoice = 0;

        System.out.println("\nThere were multiple items matching your search.\n");
        while (true) {
            System.out.println(itemListToString(listOfItems));
            System.out.println("\nType the number correlating with the item you want to select.\n");
            itemChoice = getIntInput();
            if (itemChoice < 0 || itemChoice > listOfItems.size()) {
                System.out.println("Unrecognized input....\n");
                System.out.println("\nType the number correlating with the item you want to select\n");
            } else {
                break;
            }
        }
        return itemChoice - 1;
    }

    /**
     * Asks for the item number of the item.
     * Calls the method getStringInput().
     * 
     * @return the userinput
     */
    private String getInputItemNum() {
        System.out.println("\nType in the item-number.\n");
        return getStringInput();
    }

    /**
     * Asks for the description of the item.
     * Calls the method getStringInput().
     * 
     * @return the userinput
     */
    private String getInputDescription() {
        System.out.println("\nType in the description.\n");
        return getStringInput();
    }

    /**
     * Asks for the price of the item.
     * Calls the method getIntInput().
     * 
     * @return the userinput
     */
    private int getInputPrice() {
        System.out.println("\nType in the price.\n");
        return getIntInput();
    }

    /**
     * Asks for the brand-name of the item.
     * Calls the method getStringInput().
     * 
     * @return the userinput
     */
    private String getInputBrandName() {
        System.out.println("\nType in the brand name.\n");
        return getStringInput();
    }

    /**
     * Asks for the weight of the item.
     * Calls the method getDoubleInput().
     * 
     * @return the userinput
     */
    private double getInputWeight() {
        System.out.println("\nType in the weight.\n");
        return getDoubleInput();
    }

    /**
     * Asks for the length of the item.
     * Calls the method geDoubleInput().
     * 
     * @return the userinput
     */
    private double getInputLength() {
        System.out.println("\nType in the length.\n");
        return getDoubleInput();
    }

    /**
     * Asks for the height of the item.
     * Calls the method getDoubleInput().
     * 
     * @return the userinput
     */
    private double getInputHeight() {
        System.out.println("\nType in the height.\n");
        return getDoubleInput();
    }

    /**
     * Asks for the color of the item.
     * Calls the method getStringInput().
     * 
     * @return the userinput
     */
    private String getInputColor() {
        System.out.println("\nType in the color.\n");
        return getStringInput();
    }

    /**
     * Asks for the stock on hand of the item.
     * Calls the method getIntInput().
     * 
     * @return the userinput
     */
    private int getInputStockOnHand() {
        System.out.println("\nType in the stock on hand.\n");
        return getIntInput();
    }

    /**
     * Asks for the category of the item.
     * Calls the method getIntInput().
     * 
     * @return the userinput
     */
    private int getInputCategory() {
        System.out.println("\nType in the integer correlating with the category.\n");
        return getIntInput();
    }

    /**
     * Asks for the number of items the user wishes to remove from the inventory.
     * Calls the method getIntInput().
     * 
     * @return the negative of the userinput.
     */
    private int getInputStockReduced() {
        System.out.println("\nNumber of items to remove from inventory.\n");
        return -getIntInput();
    }

    /**
     * Asks for the number of items the user wishes to add to the inventory.
     * Calls the method getIntInput().
     * 
     * @return the userinput
     */
    private int getInputStockAdded() {
        System.out.println("\nNumber of items to add to inventory.\n");
        return getIntInput();
    }

    /**
     * Asks for the name of the new category.
     * Calls the method getStringInput().
     * 
     * @return the userinput
     */
    private String getCategoryName() {
        System.out.println("\nName of category to add.\n");
        return getStringInput();
    }

    /**
     * Creates a scanner and asks for a number until the user
     * types in a valid number. Supressed the warning of resource
     * leak from the scanner since it is not relevant in this case.
     * 
     * @return the userinput as an integer
     */
    private int getIntInput() {
        int input = 0;
        boolean validInput = false;

        do {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
                input = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("\nYou must enter a number, not text.\n");
            }
        } while (validInput == false);

        return input;
    }

    /**
     * Creates a scanner and asks for a text until the user
     * types in something valid. Supressed the warning of resource
     * leak from the scanner since it is not relevant in this case.
     * 
     * @return the userinput as a String
     */
    private String getStringInput() {
        String input = "";
        boolean validInput = false;
        do {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextLine()) {
                input = sc.nextLine();
                validInput = true;
            } else {
                System.out.println("\nYou must enter a text.\n");
            }
        } while (validInput == false);

        return input;
    }

    /**
     * Creates a scanner and asks for a number until the user
     * types in a valid number. Supressed the warning of resource
     * leak from the scanner since it is not relevant in this case.
     * 
     * @return the userinput as a double
     */
    private double getDoubleInput() {
        double input = 0;
        boolean validInput = false;

        do {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                validInput = true;
            } else {
                System.out.println("\nYou must enter a text.\n");
            }
        } while (validInput == false);

        return input;
    }

    /**
     * Asks the user to press enter to continue. Waits until the user provides.
     * Supressed the warning of resource leak from the scanner since it is not
     * relevant in this case.
     */
    private void showPressEnterToContinue() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Press enter to continue.....");

        sc.nextLine();
    }

    /**
     * Adds a new item to the itemRegister. Calls the different methods that asks
     * the user for the different parameters that is necessary to create an
     * object of class Item.
     * 
     * @throws InvalidInputException
     *             if any of the inputs are invalid
     */
    private void addingItemOption() throws InvalidInputException {
        itemRegister.addNewItem(getInputItemNum(), getInputDescription(), getInputPrice(), getInputBrandName(),
                getInputWeight(), getInputLength(), getInputHeight(), getInputColor(), getInputStockOnHand(),
                getInputCategory());
    }

    /**
     * Calls the showSearchOptionMenu() method to ask the user for
     * how they want search for the item. Then goes to the corresponding
     * case, where it calls the corresponding methods to get the userinput for
     * the parameter that they chose to search by.
     * 
     * @return the found items in an arrayList
     */
    private ArrayList<Item> findItems() {
        while (true) {
            int searchOption = this.showSearchOptionMenu();
            switch (searchOption) {
                case SEARCH_BY_ITEMNUM:
                    return itemRegister.searchByItemNum(getInputItemNum());

                case SEARCH_BY_DESC:
                    return itemRegister.searchByDesc(getInputDescription());

                case SEARCH_BY_BOTH:
                    return itemRegister.searchByItemNumAndDesc(getInputItemNum(), getInputDescription());

                default:
                    System.out.println("Unrecognised input\n");
                    break;
            }
        }
    }

    /**
     * Method that calls findItems() and then calls
     * itemListToString() on the result. If there were no
     * items found then it returns that there were no items found.
     * 
     * @return either "No items found" or the list of found items as String.
     */
    private String findAndListItems() {
        ArrayList<Item> listOfItems = findItems();
        if (listOfItems.isEmpty()) {
            return "\nNo items found\n";
        } else {
            return itemListToString(listOfItems);
        }
    }

    /**
     * Takes an arrayList of items as a parameter then turns that
     * arraylist into a String of all the items.
     * 
     * @param listOfItems
     *            is an arrayList of Items
     * @return a String that is a list of all the items in an arrayList
     */
    private String itemListToString(ArrayList<Item> listOfItems) {
        String list = "";

        for (int i = 0; i < listOfItems.size(); i++) {
            list += i + 1 + ": " + listOfItems.get(i) + "\n";
        }

        return list;
    }

    /**
     * Tries to decrease the stock on hand of an item in the itemRegister and calls
     * the methods required to ask the user for the necessary information.
     * Also catches an IndexOutOfBoundsException if there were no items found.
     * 
     * @throws InvalidInputException
     *             if the new stock on hand is negative
     */
    private void takeOutOfinventory() throws InvalidInputException {
        try {
            itemRegister.changeStockOnHand(selectItem(findItems()), getInputStockReduced());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nNo items found.\n");
        }
    }

    /**
     * Tries to increase the stock on hand of an item in the itemRegister and calls
     * the methods required to ask the user for the necessary information.
     * Also catches an IndexOutOfBoundsException if there were no items found.
     * 
     * @throws InvalidInputException
     *             if the stock on hand is invalid
     */
    private void addItemsToinventory() throws InvalidInputException {
        try {
            itemRegister.changeStockOnHand(selectItem(findItems()), getInputStockAdded());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nNo items found.\n");
        }
    }

    /**
     * Tries to delete an item from the itemRegister and calls
     * the methods required to ask the user for the necessary information.
     * Also catches an IndexOutOfBoundsException if there were no items found.
     */
    private void deleteItem() {
        try {
            itemRegister.deleteItem(selectItem(findItems()));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nNo items to delete by those parameters.\n");
        }
    }

    /**
     * Method that takes an arrayList of items and selects an item
     * from that arrayList. This is either done by getting the item in the first
     * position if the size of the arraylist is 1 or less, or by calling the
     * startMultipleItemMenu() method where the user picks an item from the
     * arraylist.
     * 
     * @param listOfItems
     *            the arraylist from which the item is selected
     * @return a singular item from the arraylist listOfItems
     */
    private Item selectItem(ArrayList<Item> listOfItems) {
        if (listOfItems.size() > 1) {
            return startMultipleItemMenu(listOfItems);
        } else {
            return listOfItems.get(0);
        }
    }

    /**
     * Calls the showMultipleItemsMenu() and
     * returns the item that the user chose from
     * the arrayList of items.
     * 
     * @param listOfItems
     *            is an arrayList of items that
     *            the user gets to choose from.
     * @return the singular item from the arrayList that the
     *         user selected
     */
    private Item startMultipleItemMenu(ArrayList<Item> listOfItems) {
        int itemChoice = this.showMultipleItemsMenu(listOfItems);
        return listOfItems.get(itemChoice);
    }

    /**
     * Method that adds a new category to the current list of categories
     * and calls methods to get the necessary userinput.
     * Also calls method showCurrentCategories().
     * Gives feedback messeage and calls showPressEnterToContinue().
     */
    private void addCategory() {
        String newCategory;

        System.out.println(showCurrentCategories());

        newCategory = getCategoryName();

        itemRegister.addCategory(newCategory);

        System.out.println("Category '" + newCategory + "' correlating with integer '"
                + itemRegister.getCategoryListSize() + "' was added to the item register.");

        showPressEnterToContinue();
    }

    /**
     * Method for Showing the current categories as a list.
     * 
     * @return the current categories, in a list, as a String
     */
    private String showCurrentCategories() {
        return "Current categories are:\n" + itemRegister.showCategories();
    }

    /**
     * Start method for the application.
     * Initially loads the item database so that the itemRegister is not
     * lost between sessions.
     * Calls the showMenu() method to get userInput and then goes to the
     * corresponding
     * case. Does this until the user selects the option to quit.
     * If there is an unrecognized input, prints out the message: 'Unrecognized
     * input'.¨
     * Catches InvalidInputException and prints out its message.
     */
    public void start() {
        itemRegister = ItemDatabase.load();
        boolean finished = false;

        while (!finished) {
            try {
                int menuChoice = this.showMenu();
                switch (menuChoice) {
                    case ADD_ITEM:
                        addingItemOption();
                        break;

                    case LIST_ALL_ITEMS:
                        System.out.println(itemRegister.toString());
                        showPressEnterToContinue();
                        break;

                    case FIND_ITEM:
                        System.out.println(findAndListItems());
                        showPressEnterToContinue();
                        break;

                    case TAKE_OUT_ITEMS:
                        takeOutOfinventory();
                        break;

                    case ADD_ITEMS_TO_inventory:
                        addItemsToinventory();
                        break;

                    case DELETE_ITEM:
                        deleteItem();
                        break;

                    case ADD_DEFAULT_ITEMS:
                        itemRegister.addExampleItems();
                        break;

                    case ADD_CATEGORY:
                        addCategory();
                        break;

                    case EXIT:
                        System.out.println("Application closed\n");
                        finished = true;
                        break;

                    default:
                        System.out.println("Unrecognized input\n");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * The corresponding integers for the cases.
     */
    private final int ADD_ITEM = 1;
    private final int LIST_ALL_ITEMS = 2;
    private final int FIND_ITEM = 3;
    private final int TAKE_OUT_ITEMS = 4;
    private final int ADD_ITEMS_TO_inventory = 5;
    private final int DELETE_ITEM = 6;
    private final int ADD_DEFAULT_ITEMS = 7;
    private final int ADD_CATEGORY = 8;
    private final int EXIT = 9;

    private final int SEARCH_BY_ITEMNUM = 1;
    private final int SEARCH_BY_DESC = 2;
    private final int SEARCH_BY_BOTH = 3;
}
