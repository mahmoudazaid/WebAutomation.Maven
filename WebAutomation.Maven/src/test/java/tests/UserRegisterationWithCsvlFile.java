package tests;

import com.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserRegisterationPage;

import java.io.FileReader;
import java.io.IOException;

public class UserRegisterationWithCsvlFile extends TestBase {

    HomePage homeObject;
    UserRegisterationPage userRegisterationObject;
    CSVReader reader;

    @Test
    public void UserCanRegisterSuccessfully() throws IOException {
        // get csv file path
        String CSV_file = System.getProperty("user.dir") + "/Data/userdata.csv";
        reader = new CSVReader(new FileReader(CSV_file));

        String[] csvCell;
        //While loop will be executed the last value in CSV file
        while((csvCell = reader.readNext()) != null){
            String firstName = csvCell[0];
            String lastName = csvCell[1];
            String email = csvCell[2];
            String password = csvCell[3];

            homeObject = new HomePage(driver);
            homeObject.openRegisterationPage();
            userRegisterationObject = new UserRegisterationPage(driver);
            userRegisterationObject.userRegisteration(firstName, lastName, email, password, password);
            Assert.assertTrue(userRegisterationObject.successMessage.getText().contains("Your registration completed"));
            userRegisterationObject.logoutButton.click();
        }
    }
}
