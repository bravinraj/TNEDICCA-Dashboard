package Common_function;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Common_function.Base_function;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_report extends Base_function {
	private static ExtentReports extent;
	public static String screenshotName;
	// Properties properties;

	public static ExtentReports createInstance(String fileName) {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		//htmlReporter.config().setReportName("Bravin");
		htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.config().setReportName("TNEDICCA DASHBOARD AUTOMATION");
		htmlReporter.config().setDocumentTitle("TNEDICCA DEV DASHBOARD");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("          ");

		String logoPath = "file:///C:/Users/10155/eclipse-workspace/TNEDICCA_DASHBOARD_AUTOMATION/src/main/resources/Test_case/KcubeLogo.svg";
		htmlReporter.config()
				.setJS("" + "document.querySelector('.brand-logo').innerHTML = '<div><img class=\"logo-x\" src=\"" + logoPath
						+ "\" height=\"50px\" width=\"150px !important\" margin-top=\"25px\" ></div>';");
		String css =  ""
				+ ".brand-logo  {"
		        + "  background-color: skyblue !important;"  
		        + "}"
		        + ".nav-wrapper {"
		        + "  background-color: skyblue !important;"  
		        + "}";
		htmlReporter.config().setCSS(css);
		/*
		 * int logoHeight = 100; // Set your preferred height in pixels int logoWidth =
		 * 200; // Set your preferred width in pixels
		 * 
		 * String jsScript =
		 * "document.querySelector('.brand-logo').innerHTML = '<img class=\"logo\" src=\""
		 * + logoPath + "\" height=\"" + logoHeight + "px\" width=\"" + logoWidth +
		 * "px\">';"; htmlReporter.config().setJS(jsScript);
		 */

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Release No", "22");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Build no", "B-12673");

		return extent;
	}

	public static void captureScreenshot() {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Call method to capture screenshot
		File src = screenshot.getScreenshotAs(OutputType.FILE);

		try {
			Date d = new Date();
			screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
			System.out.println("Successfully captured a screenshot");
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
	}
}
