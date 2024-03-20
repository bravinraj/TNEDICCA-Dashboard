package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Gateway_Control {
	@FindBy(xpath = "//a[contains(text(),'Gateway Control')]")
	public static WebElement Gatewaycontrol;

	@FindBy(xpath = "//input[@placeholder='IP to blacklist']")
	public static WebElement IPblacklist;

	@FindBy(xpath = "//span[contains(text(),'Blacklist')]")
	public static WebElement Ipbutton;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	public static WebElement messagehandle;

	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement ipaddmessage;

	@FindBy(xpath="//td[@class='ant-table-cell']")
	public static WebElement IPaddress;

	@FindBy(xpath = "//th[contains(text(),'Action')]//following::a[1]")
	public static WebElement Ipremove;

	@FindBy(xpath = "//a[contains(text(),'Remove')]//following::button[1]")
	public static WebElement previouspage;

	@FindBy(xpath="//li[@title='Next Page']")
	public static WebElement Nextbutton;

	@FindBy(xpath="//td[@class='ant-table-cell']")
	public static WebElement Nextpageassertion;

	@FindBy(xpath="//td[contains(text(),'1')]")
	public static WebElement previouspageassertion;

	@FindBy(xpath="//th[contains(text(),'S.No')]//following::button[3]")
	public static WebElement Reloadbutton;

	@FindBy(xpath = "//div[@class='ant-modal-body']")
	public static WebElement Reloadalert;

	@FindBy(xpath = "//div[@class='ant-modal-footer']//following::span[1]")
	public static WebElement alertok;

	@FindBy(xpath="//div[@class='ant-modal-footer']//following::span[2]")
	public static WebElement alertcancel;

}
