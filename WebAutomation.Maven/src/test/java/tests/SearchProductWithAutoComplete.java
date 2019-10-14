package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductWithAutoComplete extends TestBase {
    String productName ="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserSearchWithAutoComplete()
    {
        searchObject = new SearchPage(driver);
        searchObject.ProductSearchUsingAutoComplete("Mac");
        detailsObject = new ProductDetailsPage(driver);
        Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
    }
}
