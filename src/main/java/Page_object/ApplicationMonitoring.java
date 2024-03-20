package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationMonitoring {
	@FindBy(xpath = "//a[contains(text(),'Application Monitoring')]")
	public static WebElement Application_monitoring;
	
	@FindBy(xpath = "//a[contains(text(),'Gateway Monitoring')]")
	public static WebElement GatewayMonitoring;
	
	@FindBy(xpath = "//span[contains(text(),'Refresh')]")
	public static WebElement Refresh_button;
	
	@FindBy(xpath = "//div[@id='client-select']")
	public static WebElement Client_dropdown;
	
	@FindBy(xpath = "//li[contains(text(),'All User')]")
	public static WebElement Alluser;
	
	@FindBy(xpath = "//div[@id='date-type-select']")
	public static WebElement datedropdowm;
	
	@FindBy(xpath = "//li[contains(text(),'Today')]")
	public static WebElement Today;
	
	@FindBy(xpath = "//li[text()='Date']")
	public static WebElement Date;
	
	@FindBy(xpath = "//li[text()='Date Range']")
	public static WebElement DateRange;
	
	@FindBy(xpath = "//span[text()='Search']//preceding::input[2]")
	public static WebElement StartDate;
	
	@FindBy(xpath = "//span[text()='Search']//preceding::input[1]")
	public static WebElement Enddate;
	
	@FindBy(xpath = "//span[text()='Search']")
	public static WebElement Search;
	
	@FindBy(xpath = "//div[contains(text(),'Avg Response Time')]")
	public static WebElement AvgResponseTime;
	
	@FindBy(xpath = "//div[contains(text(),'Success Percentage')]")
	public static WebElement Successpercentage;
	
	@FindBy(xpath = "//div[contains(text(),'Error')]")
	public static WebElement Error;
	
	@FindBy(xpath = "//div[text()='Success']")
	public static WebElement Success;
	
	@FindBy(xpath = "//div[text()='Average response time crossed 500 ms threshold.']")
	public static WebElement Avg_tooltip;
	

	@FindBy(xpath = "//div[text()='Success percentage less than 95% threshold.']")
	public static WebElement Suc_tooltip;
	
	@FindBy(xpath = "//h5[text()='Trend']//following::div[2]")
	public static WebElement Trend_success;
	
	@FindBy(xpath = "//h5[text()='Trend']//following::div[3]")
	public static WebElement Trend_error;
	
	@FindBy(xpath = "//div[@id='trend-select-success']")
	public static WebElement statusCodeDropdown;
	
	@FindBy(xpath = "//li[text()='207']")
	public static WebElement statucCode;
	
	@FindBy(xpath = "//div[@id='trend-select-state']")
	public static WebElement Allstate;
	
	

}
