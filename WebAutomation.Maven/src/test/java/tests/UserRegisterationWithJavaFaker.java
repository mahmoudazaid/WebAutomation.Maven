package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

import java.io.IOException;

public class UserRegisterationWithJavaFaker extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;
    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    @Test
    public void UserCanRegisterSuccessfully() throws IOException {

        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(firstName, lastName, email, password, password);
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email:" + email);
        System.out.println("Password: " + password);
        userRegistrationObject.logoutButton.click();
    }
}
