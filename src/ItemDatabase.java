import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Erik Sandvik
 * @version JDK 17.0.4.1
 * 
 * This class store and load the itemregister to/from disk. In lack of a proper databasesystem this class uses the Java API.
 * The file containing the itemregister will be rewritten every time the save method is called. There is
 * no support for saving individual changes.
 * 
 */
public class ItemDatabase {
    private static final String FILE_NAME_DB = "ItemRegister.db";

    /**
     * Save the state of the itemRegister to disk. 
     * 
     * If the file exist it will be overwritten, if it does not exist a new file is created.
     * 
     * The user running the application must have access to create and write to files in the current directory.
     * @param db is the itemregister saved
     */
    public static void save(ItemRegister db) {

        try {
            FileOutputStream writeData = new FileOutputStream(FILE_NAME_DB);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(db);
            writeStream.flush();
            writeStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Load the state of the itemRegister from disk. 
     * 
     * If the file exist it the state of the saved itemregister will be loaded into memory. If the file do not exist 
     * the default item categories will be created.
     * 
     * The user running the application must have access to open and read from files in the current directory.
     * 
     * Catches FileNotFoundException when there is no itemRegister to load, then sets the default categories to
     * the categoryList
     * 
     * @return the loaded state of itemRegister from disk
     */
    public static ItemRegister load() {

        ItemRegister itemRegister = new ItemRegister();

        try {
            FileInputStream readData = new FileInputStream(FILE_NAME_DB);
            ObjectInputStream readStream = new ObjectInputStream(readData);

            itemRegister = (ItemRegister) readStream.readObject();
            readStream.close();

        }

        catch (FileNotFoundException ignored) {
            CategoryList defaultList = new CategoryList();
            defaultList.addDefaultCategories();

            itemRegister.setItemCategoryList(defaultList);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemRegister;

    }

}
