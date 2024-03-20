package Test_case;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common_function.Base_function;
import Page_object.Home_page;
import Page_object.Login_page_objects;

public class Login_with_invalid_credential extends Base_function {

	public void invalid_userid() throws InterruptedException
	{

		Login_page_objects.userid_Textfield.sendKeys(properties.getProperty("invalid_username"));
		Login_page_objects.password_Textfield.sendKeys(properties.getProperty("valid_password"));
		Login_page_objects.login_button.click();
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(Login_page_objects.Error_message));
		String Invalid_error_message= Login_page_objects.Error_message.getText();
		// System.out.println(Invalid_error_message);
		Assert.assertEquals("Incorrect Username or Password", Invalid_error_message);
		Thread.sleep(2000);
		Login_page_objects.userid_Textfield.clear();
		Login_page_objects.password_Textfield.clear();

	}

	public void invalid_password() throws InterruptedException
	{
		Login_page_objects.userid_Textfield.sendKeys(properties.getProperty("valid_username"));
		Login_page_objects.password_Textfield.sendKeys(properties.getProperty("invalid_password"));
		Login_page_objects.login_button.click();
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(Login_page_objects.Error_message));
		String Invalid_error_message= Login_page_objects.Error_message.getText();
		// System.out.println(Invalid_error_message);
		Assert.assertEquals("Incorrect Username or Password", Invalid_error_message);
		Thread.sleep(2000);
		Login_page_objects.userid_Textfield.clear();
		Login_page_objects.password_Textfield.clear();

	}
	public void Invalid_username_password() throws InterruptedException
	{
		Login_page_objects.userid_Textfield.sendKeys(properties.getProperty("valid_username"));
		Login_page_objects.password_Textfield.sendKeys(properties.getProperty("invalid_password"));
		Login_page_objects.login_button.click();
		Thread.sleep(2000);
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(Login_page_objects.Error_message));
		String Invalid_error_message= Login_page_objects.Error_message.getText();
		// System.out.println(Invalid_error_message);
		Assert.assertEquals("Incorrect Username or Password", Invalid_error_message);

	}
	@Test(priority = 2)
	public void Invalid_inputs() throws InterruptedException
	{
		PageFactory.initElements(driver,Login_page_objects.class);
		invalid_userid();
		Thread.sleep(2000);
		invalid_password();
		Thread.sleep(2000);
		Invalid_username_password();
	}

}
