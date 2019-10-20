package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    //Load the properties file from the folder

    public static Properties userData = loadProperties(System.getProperty("user.dir")+"/src/main/java/properties/userdata.properties");
    public static Properties environment = loadProperties(System.getProperty("user.dir")+"/src/main/java/properties/Environment.properties");


    private static Properties loadProperties(String path){
        Properties property = new Properties();
        //Streaming for reading files
        try {
            FileInputStream stream = new FileInputStream(path);
            property.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(("Error occurred: ") + e.getMessage());
        }
        catch (NullPointerException e) {
            System.out.println(("Error occurred: ") + e.getMessage());
        }
        return property;
    }
}
