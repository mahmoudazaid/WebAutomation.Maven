package extensions;

import browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementExtensions {

    public static WebElement InspectElement (By by){
        WebElement element = Driver.driver.findElement(by);
        return element;
    }

    public static WebElement typeText (By by){
        WebElement element = Driver.driver.findElement(by);
        return element;
    }
}
