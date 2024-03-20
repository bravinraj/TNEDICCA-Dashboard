package Test_case;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.Health_check;
import Page_object.Home_page;
import Page_object.Login_page_objects;
import Page_object.Monitoring;

public class To_verify_requestid extends Base_function {

	public void login()
	{
		Login_page_objects.userid_Textfield.sendKeys(properties.getProperty("valid_username"));
		Login_page_objects.password_Textfield.sendKeys(properties.getProperty("valid_password"));
		Login_page_objects.login_button.click();
	}
	public void Verify_server_dropdown() throws InterruptedException
	{
		PageFactory.initElements(driver,Home_page.class);
		Thread.sleep(2000);
		Home_page.dropdown.click();
		Thread.sleep(2000);
		Home_page.select_option.click();
	}
	
	public void RequestID() throws InterruptedException
	{
		Monitoring.Monitoring.click();
		Health_check.RequestID.click();
		Thread.sleep(1000);
		Health_check.search_field.sendKeys(properties.getProperty("request_id"));
		Thread.sleep(1000);
		Health_check.search_button.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Maximum wait time of 30 seconds
        wait.until(ExpectedConditions.invisibilityOf(Health_check.Loading));
		Health_check.Expand_button.click();
	}
	
	@Test
	public void Verify_RequestID() throws InterruptedException
	{
		PageFactory.initElements(driver,Login_page_objects.class);
		PageFactory.initElements(driver,Monitoring.class);
		PageFactory.initElements(driver,Health_check.class);
		login();
		Verify_server_dropdown();
		RequestID();
	}
}
