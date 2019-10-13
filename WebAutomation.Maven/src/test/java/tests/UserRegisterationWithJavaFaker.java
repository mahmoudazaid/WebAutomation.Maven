package tests;

import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegisterationWithJavaFaker extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegisterationObject;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test
    public void UserCanRegisterSuccessfully() throws IOException {

        homeObject = new HomePage(driver);
        homeObject.openRegisterationPage();
        userRegisterationObject = new UserRegisterationPage(driver);
        userRegisterationObject.userRegisteration(firstName, lastName, email, password, password);
        Assert.assertTrue(userRegisterationObject.successMessage.getText().contains("Your registration completed"));
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email:" + email);
        System.out.println("Password: " + password);
        userRegisterationObject.logoutButton.click();
    }
}
