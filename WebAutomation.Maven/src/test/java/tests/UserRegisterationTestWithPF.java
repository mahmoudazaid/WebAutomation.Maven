package tests;

import utilities.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

public class UserRegisterationTestWithPF extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;
    String fname = PropertiesReader.userData.getProperty("firstname");
    String lname = PropertiesReader.userData.getProperty("lastname");
    String email = PropertiesReader.userData.getProperty("email");
    String password = PropertiesReader.userData.getProperty("password");
    @Test
    public void UserCanRegisterSuccessfully(){
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(fname, lname, email,password,password);
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
    }
}
