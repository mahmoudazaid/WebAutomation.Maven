package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

    public UserRegisterationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement genderRadioBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxt;

    @FindBy(id = "LastName")
    WebElement lastNameTxt;

    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;

    @FindBy(id = "Email")
    WebElement emailTxt;

    @FindBy(id = "Password")
    WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxt;

    @FindBy(id = "register-button")
    WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    public WebElement successMessage;

    public void userRegisteration(String firstName, String lastName, String email, String password, String confirmPassword) {
        clickButton(genderRadioBtn);

        typeText(firstNameTxt, firstName);

        typeText(lastNameTxt, lastName);

        typeText(emailTxt, email);

        typeText(passwordTxt, password);

        typeText(confirmPasswordTxt, confirmPassword);

        clickButton(registerButton);
    }
}
