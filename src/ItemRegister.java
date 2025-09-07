import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Class that represents a place to register objects of class Item.
 * This class can add and remove items from the arraylist 'itemRegister'
 * where the objects are stored.
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class ItemRegister implements Serializable {
    /**
     * Arraylist 'itemRegister' is where the items are stored.
     */
    ArrayList<Item> itemRegister = new ArrayList<Item>();
    /**
     * This object of class CategoryList is mainly
     * used for validation purposes.
     */
    CategoryList itemCategoryList = new CategoryList();

    /**
     * Sets the list of categories that applys to the
     * item-register.
     * 
     * @param itemCategoryList
     *            is list of categories that
     *            is set.
     */
    public void setItemCategoryList(CategoryList itemCategoryList) {
        this.itemCategoryList = itemCategoryList;
    }

    /**
     * Method that adds a new object of class item to the item-register.
     * This method also calls the method validateCategory() to check
     * if the category param is valid.
     * 
     * @param itemNumber
     *            is a String that is the itemnumber of the new item
     * @param description
     *            is a String that is the description of the new item
     * @param price
     *            is an integer that is the price of the new item
     * @param brandName
     *            is a String that is the brand-name of the new item
     * @param weight
     *            is a double that is the weight of the new item
     * @param length
     *            is a double that is the length of the new item
     * @param height
     *            is a double that is the height of the new item
     * @param color
     *            is a String that is the color of the new item
     * @param stockOnHand
     *            is an integer that is the stock on hand of the new item
     * @param category
     *            is an integer that correlates with the category of the new item
     * @throws InvalidInputException
     *             if any of the params are invalid
     */
    public void addNewItem(String itemNumber, String description, int price, String brandName, double weight,
            double length, double height, String color, int stockOnHand, int category) throws InvalidInputException {
        validateCategory(category);
        itemRegister.add(new Item(itemNumber, description, price, brandName, weight, length, height, color, stockOnHand,
                category));
        ItemDatabase.save(this);
    }

    /**
     * Finds items in the arraylist 'itemRegister' that shares
     * the itemnumber of the param.
     * 
     * @param itemNumber
     *            is the itemnumber that is searched for
     *            in the item register.
     * @return all the items found as the arraylist 'itemResults'
     */
    public ArrayList<Item> searchByItemNum(String itemNumber) {
        ArrayList<Item> itemResults = new ArrayList<Item>();

        itemResults = this.itemRegister.stream().filter(item -> item.getItemNumber().equals(itemNumber)).collect(Collectors.toCollection(ArrayList<Item>::new));

        return itemResults;
    }

    /**
     * Finds items in the arraylist 'itemRegister' that shares
     * the description of the param.
     * 
     * @param description
     *            is the description that is searched for
     *            in the item register.
     * @return all the items found as the arraylist 'itemResults'
     */
    public ArrayList<Item> searchByDesc(String description) {
        ArrayList<Item> itemResults = new ArrayList<Item>();

        itemResults = this.itemRegister.stream().filter(item -> item.getDescription().equals(description)).collect(Collectors.toCollection(ArrayList<Item>::new));

        return itemResults;
    }

    /**
     * Finds items in the arraylist 'itemRegister' that shares
     * the description and the itemnumber of the param.
     * 
     * @param itemNumber
     *            is the itemnumber that is searched for
     *            in the item register.
     * @param description
     *            is the description that is searched for
     *            in the item register.
     * @return all the items found as the arraylist 'itemResults'
     */
    public ArrayList<Item> searchByItemNumAndDesc(String itemNumber, String description) {
        ArrayList<Item> itemNumResults = new ArrayList<Item>();
        ArrayList<Item> descriptionResults = new ArrayList<Item>();
        
        itemNumResults = searchByItemNum(itemNumber);
        descriptionResults = searchByDesc(description);
     
        itemNumResults.retainAll(descriptionResults);
        return itemNumResults;
    }

    /**
     * Calls the method toString() on
     * all the items in the itemRegister
     * and formats it as a list.
     * 
     * @return the String 'list' that
     *         consists of the items
     */
    public String toString() {
        String list = "";

        for (Item item : itemRegister) {
            list += item.toString() + "\n";
        }

        return list;
    }

    /**
     * Changes the stock on hand of a item
     * by a value 'change'. Also saves this change
     * in the item database.
     * 
     * @param item
     *            is the item that gets its stock on hand changed
     * @param change
     *            is the value that the stock on hand is adjusted
     * @throws InvalidInputException
     *             if the new stock on hand is negative
     */
    public void changeStockOnHand(Item item, int change) throws InvalidInputException {
        item.setStockOnHand(item.getStockOnHand() + change);
        ItemDatabase.save(this);
    }

    /**
     * Removes a specific item from the arraylist
     * 'itemRegister'. Also saves this removal in
     * the item database.
     * 
     * @param item
     *            is the item deleted
     */
    public void deleteItem(Item item) {
        itemRegister.remove(item);
        ItemDatabase.save(this);
    }

    /**
     * Adds 5 example items to the arraylist 'itemRegister'.
     * 
     * @throws InvalidInputException
     */
    public void addExampleItems() throws InvalidInputException {
        addNewItem("230H", "Simple wood flooring", 205, "Hysk", 3000, 20, 30, "Brown", 25, 1);
        addNewItem("230H", "Stone flooring", 198, "Hysk", 3000, 20, 30, "Blue", 40, 1);
        addNewItem("188K", "Normal window", 105, "Bikea", 9000, 50, 100, "White", 60, 2);
        addNewItem("144B", "Sliding door", 300, "Bikea", 5000, 100, 200, "Grey", 35, 3);
        addNewItem("130D", "Lumber", 40, "XI Build", 10000, 100, 30, "Brown", 200, 4);
    }

    /**
     * Validates the integer 'category' by calling the method categoryIsValid().
     * 
     * @param category
     *            the integer that is validated.
     * @throws InvalidInputException
     *             if the categoryIsValid() returns false
     */
    private void validateCategory(int category) throws InvalidInputException {

        if (!itemCategoryList.categoryIsValid(category)) {

            throw new InvalidInputException(category + " is invalid input for category");

        }
    }

    /**
     * Adds a category to the object of class CategoryList.
     * Saves this in the ItemDatabase, by calling the addCategory()
     * method on the object.
     * 
     * @param categoryName
     *            is the name of the category added
     */
    public void addCategory(String categoryName) {
        itemCategoryList.addCategory(categoryName);
        ItemDatabase.save(this);
    }

    /**
     * Gets all the categories in the object 'itemCategoryList'
     * returned as a String, by calling the showCategories() method
     * on the object.
     * 
     * @return the category-names and position as a String.
     */
    public String showCategories() {
        return itemCategoryList.showCategories();
    }

    /**
     * get-method for the size of the arraylist in the object 'itemCategoryList'
     * of class CategoryList.
     * 
     * @return the size of the categorylist.
     */
    public int getCategoryListSize() {
        return itemCategoryList.getCategoryListSize();
    }

}
