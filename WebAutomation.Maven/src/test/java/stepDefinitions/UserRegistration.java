package stepDefinitions;

import browser.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.UserRegisterationPage;
import parser.ElementParser;
import parser.ParserManager;

import java.io.IOException;

public class UserRegistration extends Driver {
    HomePage homeObject;
    UserRegisterationPage userRegistrationObject;
    ParserManager parser = new ParserManager(new String[]{"Login.json","Login2.json"});

    Faker fakeData = new Faker();
    String firstName = fakeData.name().firstName();
    String lastName = fakeData.name().lastName();
    String email = fakeData.internet().emailAddress();
    String password = fakeData.number().digits(8).toString();

    public UserRegistration() throws IOException, ParseException {
    }

    @Given("I am on home page")
    public void iAmOnHomePage() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
    }

    @When("I click on register")
    public void iClickOnRegister() {
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }


    @Then("The user has been registered successfully")
    public void theUserHasBeenRegisteredSuccessfully() {
        Assert.assertTrue(userRegistrationObject.successMessage.getText().contains("Your registration completed"));
        userRegistrationObject.logoutButton.click();
    }

    @And("I entered registration data")
    public void iEnteredRegistrationData() {
        userRegistrationObject = new UserRegisterationPage(driver);
        userRegistrationObject.userRegistration(firstName, lastName, email, password, password);
        System.out.println("The registration data: " + firstName + ", " + lastName + ", " + email + ", " + password);
    }

    @And("I have entered {string} into {string}")
    public void iHaveEnteredInto(String text, String element) throws IOException, ParseException {
        parser.getElementDetails("login");
    }
}
