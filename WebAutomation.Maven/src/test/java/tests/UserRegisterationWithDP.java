package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDP extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegisterationObject;

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
        homeObject.openRegisterationPage();
        userRegisterationObject = new UserRegisterationPage(driver);
        userRegisterationObject.userRegisteration(fname,lname,email,password, password);
        Assert.assertTrue(userRegisterationObject.successMessage.getText().contains("Your registration completed"));
    }
}
