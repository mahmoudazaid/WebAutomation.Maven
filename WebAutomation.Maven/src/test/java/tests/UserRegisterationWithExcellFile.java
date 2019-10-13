package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;
import utilities.ExcelReader;

import java.io.IOException;

public class UserRegisterationWithExcellFile extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegisterationObject;

    @DataProvider(name="ExcelData")
    public static Object[][] userData() throws IOException {
        //read data from excel file
        ExcelReader er = new ExcelReader();
        return er.getExcelData("userdata");

    }

    @Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
    public void UserCanRegisterSuccessfully(String fname, String lname, String email, String password) {
        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        userRegisterationObject = new UserRegisterationPage(driver);
        userRegisterationObject.userRegisteration(fname, lname, email, password, password);
        Assert.assertTrue(userRegisterationObject.successMessage.getText().contains("Your registration completed"));
        userRegisterationObject.logoutButton.click();
    }
}
