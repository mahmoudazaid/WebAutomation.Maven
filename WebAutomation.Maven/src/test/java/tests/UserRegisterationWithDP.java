package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDP extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;

    @DataProvider(name = "testData")
    public static Object[][] userData() {

        return new Object[][]{
                {"Mahmoud", "Abuzaid", "testxxxx@gmail.com", "123456"},
                {"Ahmed", "Ali", "test2525@gmail.com", "123456789"}
        };
    }

    @Test(priority = 1,alwaysRun = true,dataProvider = "testData")
    public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password ) {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(fname,lname,email,password, password);
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
    }
}
