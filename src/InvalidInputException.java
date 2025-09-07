/**
 * Class for InvalidInputException
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class InvalidInputException extends Exception {

    /**
     * Method for an InvalidInputException
     * with a default message.
     */
    public InvalidInputException() {
        super("Invalid input");
    }

    /**
     * Method for an InvalidInputException
     * with a custom message.
     * 
     * @param message
     *            is the custom message for
     *            the InvalidInputException
     */
    public InvalidInputException(String message) {
        super(message);
    }

}
