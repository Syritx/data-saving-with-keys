import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataService {

    private static Scanner scanner;
    private static PrintWriter writer;


    //---------------------------------------------------------------------------------//
    //---------------------------------------------------------------------------------//
    // DATA SAVING
    //---------------------------------------------------------------------------------//
    //---------------------------------------------------------------------------------//


    // SAVES AN INTEGER
    public static void saveInt(int data, String key) {

        File dataStore = new File(key+"I.txt"); // specifies an integer key with an addition of the letter I
        if (!dataStore.exists()) {
            try {
                dataStore.createNewFile();
            } catch (IOException e) {}
        }

        // writing data
        try {
            writer = new PrintWriter(dataStore);
            writer.write(Integer.toString(data));
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {}
    }

    // SAVES A FLOAT
    public static void saveFloat(float data, String key) {

        File dataStore = new File(key+"F.txt"); // specifies a float key with an addition of the letter F
        if (!dataStore.exists()) {
            try {
                dataStore.createNewFile();
            } catch (IOException e) {}
        }
        
        // writing data
        try {
            writer = new PrintWriter(dataStore);
            writer.write(Float.toString(data));
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {}
    }

    // SAVES A STRING
    public static void saveString(String data, String key) {

        File dataStore = new File(key+"S.txt"); // specifies a string key with an addition of the letter S
        if (!dataStore.exists()) {
            try {
                dataStore.createNewFile();
            } catch (IOException e) {}
        }

        // writing data
        try {
            writer = new PrintWriter(dataStore);
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {}
    }

    //---------------------------------------------------------------------------------//
    //---------------------------------------------------------------------------------//
    // DATA LOADING
    //---------------------------------------------------------------------------------//
    //---------------------------------------------------------------------------------//

    public static int getInt(String key) {
        File data = new File(key + "I.txt");
        int loadedData = 0;

        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                loadedData = Integer.parseInt(scanner.nextLine());
            }scanner.close();
        } 
        catch (FileNotFoundException e) {System.out.println("the key: '" + key + "' was never used");}
        return loadedData;
    }

    public static float getFloat(String key) {
        File data = new File(key + "F.txt");
        float loadedData = 0;

        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                loadedData = Float.parseFloat(scanner.nextLine());
            }scanner.close();
        } 
        catch (FileNotFoundException e) {System.out.println("the key: '" + key + "' was never used");}
        return loadedData;
    }

    public static String getString(String key) {
        File data = new File(key + "S.txt");
        String loadedData = "";

        try {
            scanner = new Scanner(data);
            while (scanner.hasNext()) {
                loadedData = scanner.nextLine();
            }scanner.close();
        } 
        catch (FileNotFoundException e) {System.out.println("the key: '" + key + "' was never used");}
        return loadedData;
    }
}
