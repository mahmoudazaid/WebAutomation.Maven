package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver){
        super(driver);
    }
    @FindBy(id="small-searchterms")
    WebElement searchTextBox;

    @FindBy(xpath="//input[@class='button-1 search-box-button']")
    WebElement searchBtn;

    @FindBy(id="ui-id-1")
    WebElement ProductList;

    @FindBy(linkText = "Apple MacBook Pro 13-inch")
    WebElement productTitle;

    public void productSearch(String productName)
    {
        typeText(searchTextBox,productName);
        clickButton(searchBtn);
    }

    public void openProductDetailsPage()
    {
        clickButton(productTitle);
    }

}
