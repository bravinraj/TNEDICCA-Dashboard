package Page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Edit_Client {


	@FindBy(xpath = "//div[contains(text(),'ELRS_Testing_2')]//following::span[1]")
	public static WebElement Editicon;

	@FindBy(xpath = "//button[contains(text(),'Update Client')]")
	public static WebElement updateclient;

	@FindBy(xpath = "//span[contains(text(),'OK')]")
	public static WebElement Alert;

	@FindBy(xpath="//h5[contains(text(),'Client Management')]")
	public static WebElement back_button;

	@FindBy(xpath = "//div[contains(text(),'ELRS_Testing_2')]//following::span[3]")
	public static WebElement disablebutton;

	@FindBy(xpath = "//h3[contains(text(),'Edit Client')]")
	public static WebElement edittext;
}

