package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;
    @Test
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration("Mahmoud", "Abuzaid", "Testt100@test.com","123456","123456");
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
    }
}
