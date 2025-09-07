import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class that represents a set of
 * registered categories.
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class CategoryList implements Serializable {
    /**
     * Arraylist that consists of Strings that
     * represent the name of the categories.
     */
    private ArrayList<String> registeredCategories = new ArrayList<String>();

    /**
     * Adds a new category. It adds the new
     * category to the arraylist 'registeredCategories'.
     * 
     * @param newCategory
     *            is the name of the new category
     *            in a String
     */
    public void addCategory(String newCategory) {
        registeredCategories.add(newCategory);
    }

    /**
     * Shows all currently registered categories
     * as a String. Makes a list of the categories
     * with corresponding numbers.
     * 
     * @return all the Strings in arraylist 'registeredCategories'
     *         and their position in the arraylist +1
     */
    public String showCategories() {
        String categoriesAsString = "";

        for (int i = 0; i < registeredCategories.size(); i++) {
            categoriesAsString += i + 1 + ": " + registeredCategories.get(i) + "\n";
        }
        return categoriesAsString;
    }

    /**
     * Adds the default categories to the arraylist 'registeredCategories'.
     * These categories were given in the assignment.
     */
    public void addDefaultCategories() {
        registeredCategories.add("Laminate Flooring");
        registeredCategories.add("Windows");
        registeredCategories.add("Doors");
        registeredCategories.add("Lumber");
    }

    /**
     * get-method for the size of the arraylist
     * 'registeredCategories'. Will mainly be used for validation
     * purposes.
     * 
     * @return the amount of categories registered
     */
    public int getCategoryListSize() {
        return registeredCategories.size();
    }

    /**
     * Method to check if a integer 'category'
     * correlates with a category in arraylist
     * 'registeredCategories'. The integer is deemed invalid if
     * its value is below zero or higher/equals the size of the
     * arraylist 'registeredCategories'.
     * 
     * @param category
     *            is a integer that is supposed to
     *            represent a category for an item.
     * @return a boolean of value true if the
     *         integer 'category' is a valid, or of value
     *         false if it is invalid
     */
    public boolean categoryIsValid(int category) {

        if (category > 0 && category <= registeredCategories.size()) {

            return true;

        } else {

            return false;
        }

    }
}
