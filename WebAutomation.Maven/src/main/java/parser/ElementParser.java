package parser;


import io.cucumber.java.it.Ma;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ElementParser {
    static PageElement element = new PageElement();
    static LocatorFactory locatorFactory = new LocatorFactory();
    static Map<String, By> dictionary = new HashMap<String, By>();

    public ElementParser(String fileName) throws IOException, ParseException {
        loadWebElements(fileName);
    }


    public static Map<String, By> loadWebElements(String fileName) throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/main/java/pom/";
        File scrFile = new File(filePath + fileName);
        JSONParser parser = new JSONParser();
        JSONArray elements = (JSONArray) parser.parse(new FileReader(scrFile));

        for (Object jsonObject : elements) {
            JSONObject webElement = (JSONObject) jsonObject;
            element.elementName = (String) webElement.get("name");
            System.out.println(element.elementName);

            element.locator = (String) webElement.get("locator");
            System.out.println(element.locator);

            element.value = (String) webElement.get("value");
            System.out.println(element.value);
            dictionary.put(element.elementName, locatorFactory.CreateLocator(element.locator, element.value));
        }
        System.out.println(dictionary);
        return dictionary;
    }

    public By getElementDetails(String name) throws IOException, ParseException {
        By myElement = dictionary.get(name);
        return myElement;
    }
}
