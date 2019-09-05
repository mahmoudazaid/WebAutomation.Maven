package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegisterationObject;
    @Test
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        userRegisterationObject = new UserRegisterationPage(driver);
        userRegisterationObject.userRegisteration("Mahmoud", "Abuzaid", "Testt100@test.com","123456","123456");
        Assert.assertTrue(userRegisterationObject.successMessage.getText().contains("Your registration completed"));
    }
}
