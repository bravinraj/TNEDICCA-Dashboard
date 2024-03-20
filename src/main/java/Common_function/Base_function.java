package Common_function;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;

public class Base_function {
	public Properties properties;
	public static WebDriver driver;
	public ExtentReports extent;

	public Properties configfilereader() throws IOException {

		properties = new Properties();
		InputStream input = null;

		try {
			// input =
			// getClass().getClassLoader().getResourceAsStream("/TNEDICCA_DASHBOARD_AUTOMATION/Configuration.properties");
			input = new FileInputStream("Configuration.properties");
			// Load a properties file from the classpath
			properties.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;

	}

	/*
	 * public void Screenshot() throws IOException, AWTException { //Take particular
	 * size screenshot TakesScreenshot screenshot=(TakesScreenshot)driver; File
	 * sourcefile=screenshot.getScreenshotAs(OutputType.FILE); File
	 * destinationfile=new File("F:\\TNEDICCA_Screeshot");
	 * FileUtils.copyFile(sourcefile, destinationfile);
	 * 
	 * //Take Full size screenshot Robot robot=new Robot(); //Get screen size
	 * Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize(); Rectangle
	 * rectangle=new Rectangle(screensize); BufferedImage source
	 * =robot.createScreenCapture(rectangle); File destinationfile=new
	 * File("F:\\TNEDICCA_Screeshot"); ImageIO.write(source, "png",
	 * destinationfile); }
	 * 
	 * public static ExtentReports Report() { ExtentReports extent = new
	 * ExtentReports(); ExtentSparkReporter sparkreport=new
	 * ExtentSparkReporter("TNEDICCA.html"); //ExtentHtmlReporter htmlReporter = new
	 * ExtentHtmlReporter("extent.html"); extent.attachReporter(sparkreport);
	 * //extent.config("TNEDICCA Dashboard"); return extent; String path
	 * =System.getProperty("user.dir")+"\\reports\\index.html";
	 * 
	 * 
	 * ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	 * reporter.config().setReportName("WebAutomation");
	 * reporter.config().setDocumentTitle("Test Result");
	 * 
	 * 
	 * extent = new ExtentReports(); extent.attachReporter(reporter);
	 * extent.setSystemInfo("Tester", "Bravin"); return extent; }
	 */
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		// TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//screenshots//" + testCaseName + ".png";
		FileHandler.copy(source, new File(destinationFile));
		return destinationFile;
	}

	@BeforeClass
	public void lunchbrowser() throws IOException {
		configfilereader();
		String browser_Name = properties.getProperty("browser");
		String url = properties.getProperty("URL");
		String geck_driver_path = properties.getProperty("chrome_driver_path");
		String chrome_driver_path = properties.getProperty("geck_driver_path");

		if (browser_Name.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.driver.chrome", chrome_driver_path);

			driver = new ChromeDriver();

		} else if (browser_Name.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.driver.gecko", geck_driver_path);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void teardown() {
		// close browser
		driver.quit();
	}

}
