package tests;

import utilities.LoadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithPF extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;
    String fname = LoadProperties.userData.getProperty("firstname");
    String lname = LoadProperties.userData.getProperty("lastname");
    String email = LoadProperties.userData.getProperty("email");
    String password = LoadProperties.userData.getProperty("password");
    @Test
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(fname, lname, email,password,password);
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
    }
}
