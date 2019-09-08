package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {

    public ProductDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath = "//strong[@class='current-item']")
    public WebElement productNameBreadCrumb;
}
