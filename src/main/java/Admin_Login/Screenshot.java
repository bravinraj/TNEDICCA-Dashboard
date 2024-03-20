package Admin_Login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void captureScreenshot(WebDriver driver, String methodName) {
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File source = screenshotDriver.getScreenshotAs(OutputType.FILE);
        String destPath = "screenshots/" + methodName + "_screenshot.png";

        try {
            FileUtils.copyFile(source, new File(destPath));
            System.out.println("Screenshot taken: " + destPath);
        } catch (IOException e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }
    }

}
