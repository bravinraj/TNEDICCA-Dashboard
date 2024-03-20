package Test_case;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Common_function.Base_function;
import Page_object.Login_page_objects;

public class To_Verify_login_page extends Base_function {

		//Verify login functionality with valid inputs
	
	public void login()
	{
		Login_page_objects.userid_Textfield.sendKeys(properties.getProperty("valid_username"));
		Login_page_objects.password_Textfield.sendKeys(properties.getProperty("valid_password"));
		Login_page_objects.login_button.click();
	}
	//verify Home page Titlle
	
	public void verify_Home_page()
	{
		String verify_tittle=Login_page_objects.CLient_management_headers.getText();
		System.out.println(verify_tittle);
		Assert.assertEquals("Client Management", verify_tittle);
		//Test=extent.createTest("Verify Home page Tittle",verify_tittle);
	}
	
	public void logout() throws InterruptedException
	{
		Login_page_objects.logout_arrow.click();
		Thread.sleep(2000);
		Login_page_objects.logout_button.click();
		Thread.sleep(2000);
		String loginpage_url= driver.getCurrentUrl();
		Assert.assertEquals("https://dashboard.dev.tnedicca-api.com/login", loginpage_url);

	}
	@Test
	public void loginpage() throws InterruptedException
	{
		PageFactory.initElements(driver,Login_page_objects.class);
		login();
		Thread.sleep(2000);
		verify_Home_page();
		Thread.sleep(2000);
		logout();


	}

}
