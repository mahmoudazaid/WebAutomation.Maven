package tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;
import utilities.ExcelReader;
import utilities.JsonReader;

import java.io.IOException;

public class UserRegisterationWithJsonFile extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;

    @Test(priority = 1, alwaysRun = true)
    public void UserCanRegisterSuccessfully() throws IOException, ParseException {
        JsonReader jsonReader = new JsonReader();
        jsonReader.LoadJson();
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(jsonReader.firstName,jsonReader.lastName,jsonReader.email,jsonReader.password,jsonReader.password);
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
        userRegistrationObject.logoutButton.click();
    }
}