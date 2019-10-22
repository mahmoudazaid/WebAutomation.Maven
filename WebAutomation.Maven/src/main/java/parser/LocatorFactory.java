package parser;

import org.openqa.selenium.By;

public class LocatorFactory {

    public static By CreateLocator(String elementLocator,String locatorValue){
        By by = null;

        switch (elementLocator) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "cssselector":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "tagname":
                by = By.tagName(locatorValue);
                break;
            case "classname":
                by = By.className(locatorValue);
                break;
            default:
                break;
        }
        return by;
    }
}