package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Health_check {
	@FindBy(xpath = "//a[contains(text(),'Health Check')]")
	public static WebElement HealthCheck;
	
	@FindBy(xpath = "//input[@id='mui-1']")
	public static WebElement Datefield;
	
	@FindBy(xpath = "//span[text()='Find report']")
	public static WebElement Findreport;
	
	@FindBy(xpath = "//span[text()='Generate new report']")
	public static WebElement Generate_report;
	
	@FindBy(xpath = "//th[text()='Action']//following::a[1]")
	public static WebElement Viewreport;
	
	@FindBy(xpath = "//a[text()='View Request ID']")
	public static WebElement RequestID;
	
	@FindBy(xpath = "//input[@placeholder='Search by request ID']")
	public static WebElement search_field;
	
	@FindBy(xpath = "//span[text()='Search']")
	public static WebElement search_button;
	
	@FindBy(xpath = "//th[text()='request_id']//following::button[1]")
	public static WebElement Expand_button;
	
	@FindBy(xpath = "//span[@class='ant-spin-dot ant-spin-dot-spin']")
	public static WebElement Loading;

}
