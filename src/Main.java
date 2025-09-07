/**
 * The Main class.
 * Its from here the application can be ran.
 * 
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 */
public class Main {
    public static void main(String[] args) {
        ItemRegister itemRegister = new ItemRegister();
        App app = new App(itemRegister);
        app.start();
    }
}
