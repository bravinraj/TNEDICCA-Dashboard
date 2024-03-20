package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Monitoring {
	@FindBy(xpath = "//a[contains(text(),'Monitoring')]")
	public static WebElement Monitoring;

	@FindBy(xpath = "//a[contains(text(),'Infrastructure')]")
	public static WebElement Infrastructure;

	@FindBy(xpath = "//div[contains(text(),'Expiring In a Week')]")
	public static WebElement Expiry_week;

	@FindBy(xpath = "//div[contains(text(),'Expiring In a Month')]")
	public static WebElement Expiry_month;

	@FindBy(xpath = "//span[contains(text(),'Month')]")
	public static WebElement Month;

	@FindBy(xpath = "//span[contains(text(),'Year')]")
	public static WebElement year;

	@FindBy(xpath = "//span[contains(text(),'2024')]")
	public static WebElement select_year;

	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']")
	public static WebElement select_year_1;

	@FindBy(xpath = "//span[contains(text(),'Feb')]")
	public static WebElement select_month;

	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active' and @title='Oct']")
	public static WebElement select_month_1;

	@FindBy(xpath = "//div[contains(text(),'Expiring This Month')]")
	public static WebElement Expiring_this_month;

	@FindBy(xpath = "//div[contains(text(),'Expiring This Week')]")
	public static WebElement Expiring_this_week;
}
