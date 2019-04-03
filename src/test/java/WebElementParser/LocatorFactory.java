package WebElementParser;

import org.openqa.selenium.By;

import static WebElementParser.LocatorTypes.*;

public class LocatorFactory {
    public static By CreateLocator(WebElement element) {
        By by = null;
        switch (element.getLocator()) {
            case Id:
                by = By.id(element.getValue());
                break;
            case Name:
                by = By.name(element.getValue());
                break;
            case Xpath:
                by =By.xpath(element.getValue());
                break;
            case CssSelector:
                by =By.cssSelector(element.getValue());
                break;
            case LinkText:
                by =By.linkText(element.getValue());
                break;
            case PartialLinkText:
                by =By.partialLinkText(element.getValue());
                break;
            case ClassName:
                by =By.className(element.getValue());
                break;
            case TagName:
                by =By.tagName(element.getValue());
                break;
        }
        return by;

    }
}

