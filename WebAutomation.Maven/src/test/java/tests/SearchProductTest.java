package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {
    String productname="Apple MacBook Pro 13-inch";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test
    public void UserSearchForProduct()
    {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productname);
        searchObject.openProductDetailsPage();
        Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productname));
        Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),productname);
    }
}
