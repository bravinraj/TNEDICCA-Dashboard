package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_page_objects {

	@FindBy(xpath="//input[@id='username']//preceding::img[1]")
	public static WebElement loginpage_Header;

	@FindBy(id="username")
	public static WebElement userid_Textfield;

	@FindBy(id="password")
	public static WebElement password_Textfield;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	public static WebElement login_button;

	@FindBy(xpath = "//input[@id='password']//following::span[2]")
	public static WebElement eye_button;

	@FindBy(xpath = "//h3[contains(text(),'Client Management')]")
	public static WebElement CLient_management_headers;

	@FindBy(xpath ="//a[contains(text(),'Client Management')]//preceding::img[2]")
	public static WebElement logout_arrow;

	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	public static WebElement logout_button;

	@FindBy(xpath = "//p[contains(text(),'Incorrect Username or Password')]")
	public static WebElement Error_message;


}
