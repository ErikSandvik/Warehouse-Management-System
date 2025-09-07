import java.io.Serializable;

/**
 * Class that represents a generic item-object.
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class Item implements Serializable {
    private String itemNumber;
    private String description;
    private int price;
    private String brandName;
    private double weight;
    private double length;
    private double height;
    private String color;
    private int stockOnHand;
    /**
     * An integer that is supposed to
     * correlate with a category.
     */
    private int category;

    /**
     * Constructor for the class Item, that also calls a method
     * to check if any of the parameters given were invalid.
     * 
     * @param itemNumber
     *            the item-number of the item as a String
     * @param description
     *            the description of the item as a String
     * @param price
     *            the price of the item as an integer
     * @param brandName
     *            the brandName of the item as a String
     * @param weight
     *            the weight of the item as a double
     * @param length
     *            the length of the item as a double
     * @param height
     *            the height of the item as a double
     * @param color
     *            the color of the item as a String
     * @param stockOnHand
     *            is how much of the item that is in stock as a int
     * @param category
     *            is an integer that should correlate with a category
     * @throws InvalidInputException
     *             if one of the parameters were invalid
     */
    public Item(String itemNumber, String description, int price, String brandName, double weight, double length,
            double height, String color, int stockOnHand, int category) throws InvalidInputException {

        checkIfValidInput(stockOnHand, height, length, price, weight);

        this.itemNumber = itemNumber;
        this.description = description;
        this.price = price;
        this.brandName = brandName;
        this.weight = weight;
        this.length = length;
        this.height = height;
        this.color = color;
        this.stockOnHand = stockOnHand;
        this.category = category;

    }

    /**
     * get-method for the item-number of the item.
     * 
     * @return the item-number
     */
    public String getItemNumber() {
        return itemNumber;
    }

    /**
     * set-method for the item-number of the item.
     * 
     * @param itemNumber
     *            is the new item-number
     *            for the item
     */
    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    /**
     * get-method for the description of the item.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set-method for the description of the item.
     * 
     * @param description
     *            is the new description
     *            of the item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get-method for the price of the item.
     * 
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * set-method for the price of the item that
     * also calls the method checkIfValidInputPrice()
     * to check if the price is valid.
     * 
     * @param price
     *            is the new price of the item
     * @throws InvalidInputException
     *             if the param
     *             price is invalid
     */
    public void setPrice(int price) throws InvalidInputException {
        checkIfValidInputPrice(price);

        this.price = price;
    }

    /**
     * get-method for the brand name of the item.
     * 
     * @return the brandname
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * set-method for the brand name of the item.
     * 
     * @param brandName
     *            is the new brand name of the item
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * get-method for the weight of the item.
     * 
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * set-method for the weight of the item that
     * also calls the method checkIfValidInputWeight()
     * to check if the weight is valid.
     * 
     * @param weight
     *            is the new weight of the item
     * @throws InvalidInputException
     *             if the param is
     *             invalid
     */
    public void setWeight(double weight) throws InvalidInputException {
        checkIfValidInputWeight(weight);

        this.weight = weight;
    }

    /**
     * get-method for the length of the item.
     * 
     * @return the length
     */
    public double getLength() {
        return length;
    }

    /**
     * set-method for the length of the item. Also
     * calls the method checkIfValidInputLength() to
     * check if the length is valid.
     * 
     * @param length
     *            is the new length of the item
     * @throws InvalidInputException
     *             if the param is
     *             invalid
     */
    public void setLength(double length) throws InvalidInputException {
        checkIfValidInputLength(length);
        this.length = length;
    }

    /**
     * get-method for the height of the item.
     * 
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * set-method for the height of the item. Also calls
     * the method checkIfValidInputHeight() to check
     * if the height is valid.
     * 
     * @param height
     *            is the new height of the item
     * @throws InvalidInputException
     *             if the param is
     *             invalid
     */
    public void setHeight(double height) throws InvalidInputException {
        checkIfValidInputHeight(height);

        this.height = height;
    }

    /**
     * get-method for the color of the item.
     * 
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * set-method for the color of the item.
     * 
     * @param color
     *            is the new color of the item.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get-method for the stock on hand
     * of the item.
     * 
     * @return the stock on hand.
     */
    public int getStockOnHand() {
        return stockOnHand;
    }

    /**
     * set-method for the stock on hand
     * of the item. Also calls the method
     * checkIfValidInputStock() to check if
     * the stock on hand is valid.
     * 
     * @param stockOnHand
     *            the new stock on hand
     * @throws InvalidInputException
     *             if the param
     *             is invalid.
     */
    public void setStockOnHand(int stockOnHand) throws InvalidInputException {
        checkIfValidInputStock(stockOnHand);

        this.stockOnHand = stockOnHand;
    }

    /**
     * get-method for the category of the item.
     * 
     * @return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * set-method for the category of the item.
     * 
     * @param category
     *            is the new category of the item
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /*
     * Method that formats a String of all the instance variables
     * of an item, with the type of unit where it is necessary.
     * 
     * @return a String of all the instance variables
     */
    public String toString() {
        return itemNumber + ", " + description + ", " + brandName + ", Category: " + category + ", " + length + "x" + height
                + "cm, " + color + ", " + price + ",-/per, " + weight + "g, " + "Stock: " + stockOnHand;
    }

    /**
     * calls all the 'checkIfValidInput()' methods, and
     * throws an InvalidInputException if any of the
     * params are invalid.
     * 
     * @param stockOnHand
     *            is an integer that gets checked if its negative
     * @param height
     *            is a double that gets checked if its negative
     * @param length
     *            is a double that gets checked if its negative
     * @param price
     *            is an integer that gets checked if its negative
     * @param weight
     *            is a double that gets checked if its negative
     * @throws InvalidInputException
     *             if any of the params are invalid
     */
    private void checkIfValidInput(int stockOnHand, double height, double length, int price, double weight)
            throws InvalidInputException {
        checkIfValidInputStock(stockOnHand);
        checkIfValidInputHeight(height);
        checkIfValidInputLength(length);
        checkIfValidInputPrice(price);
        checkIfValidInputWeight(weight);
    }

    /**
     * Checks if param integer 'price' is invalid. The param
     * is invalid if it is negative.
     * 
     * @param price
     *            is an integer that gets checked if its negative
     * @throws InvalidInputException
     *             if the price is negative
     */
    private void checkIfValidInputPrice(int price) throws InvalidInputException {
        if (price < 0) {
            throw new InvalidInputException("An item cannot have a negative price");
        }
    }

    /**
     * Checks if param double 'length' is invalid. The param
     * is invalid if it is negative.
     * 
     * @param length
     *            is a double that gets checked if its negative
     * @throws InvalidInputException
     *             if the length is negative
     */
    private void checkIfValidInputLength(double length) throws InvalidInputException {
        if (length < 0) {
            throw new InvalidInputException("An item cannot include a negative distance");
        }
    }

    /**
     * Checks if param double 'height' is invalid. The param is
     * invalid if it is negative.
     * 
     * @param height
     *            is a double that gets checked if its negative
     * @throws InvalidInputException
     *             if the height is negative
     */
    private void checkIfValidInputHeight(double height) throws InvalidInputException {
        if (height < 0) {
            throw new InvalidInputException("An item cannot include a negative distance");
        }
    }

    /**
     * Checks if param double 'weight' is invalid. The param is
     * invalid if it is negative.
     * 
     * @param weight
     *            is a double that gets checked if its negative
     * @throws InvalidInputException
     *             if the weight is negative
     */
    private void checkIfValidInputWeight(double weight) throws InvalidInputException {
        if (weight < 0) {
            throw new InvalidInputException("An item cannot have a negative weight");
        }
    }

    /**
     * Checks if param integer 'stockOnHand' is invalid. The param is
     * invalid if it is negative
     * 
     * @param stockOnHand
     *            is an integer that gets checked if its negative
     * @throws InvalidInputException
     *             if the stockOnHand is negative
     */
    private void checkIfValidInputStock(int stockOnHand) throws InvalidInputException {
        if (stockOnHand < 0) {
            throw new InvalidInputException("There cannot be a negative amount in storage");
        }
    }

}
