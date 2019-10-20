package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    public static void captureScreenshot(WebDriver driver , String screenShotName)
    {
        Path dest = Paths.get("./Screenshots",screenShotName+".png");
        try
        {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
}
