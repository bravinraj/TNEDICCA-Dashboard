package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Fail_over_data_sync {
	@FindBy(xpath="//a[contains(text(),'Failover Data Sync')]")
	public static WebElement failoverdata_button;

	@FindBy(xpath = "//input[@placeholder='Start date']")
	public static WebElement start_date;

	@FindBy(xpath="//input[@placeholder='End date']")
	public static WebElement End_date;

	@FindBy(xpath = "//span[contains(text(),'Export failover Data')]")
	public static WebElement Export_button;

	@FindBy(xpath ="//span[contains(text(),'Import failover Data')]")
	public static WebElement Import_button;

	@FindBy(xpath = "//span[contains(text(),'QC imported data')]")
	public static WebElement QC_import;

	@FindBy(xpath = "//span[contains(text(),'Merge imported data')]")
	public static WebElement Merge_import_data;

	@FindBy(xpath = "//span[contains(text(),'Usage counter sync')]")
	public static WebElement Usage_counter;

	@FindBy(xpath = "//span[contains(text(),'Dashboard statistics update')]")
	public static WebElement Dashboard_statistics;

	@FindBy(xpath = "//span[contains(text(),'Truncate failover schema records')]")
	public static WebElement Truncate;

	@FindBy(xpath = "//span[contains(text(),'10 / page')]//preceding::button[1]")
	public static WebElement Nextbutton;

	@FindBy(xpath = "//span[contains(text(),'10 / page')]//preceding::button[2]")
	public static WebElement previousbutton;

	@FindBy(xpath = "//span[contains(text(),'10 / page')]")
	public static WebElement page;

	@FindBy(xpath = "//button[@class='ant-btn css-yp8pcc ant-btn-primary ant-btn-sm']")
	public static WebElement Ok_button;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]//preceding::span[1]")
	public static WebElement Export;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	public static WebElement Cancel;

	@FindBy(xpath = "//button[@class='ant-btn css-yp8pcc ant-btn-default']//following::span[3]")
	public static WebElement ok_message;

	@FindBy(xpath="//span[contains(text(),'OK')]")
	public static WebElement handle_alert;

}
