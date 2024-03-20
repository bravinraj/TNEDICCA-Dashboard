package Test_case;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.ApplicationMonitoring;
import Page_object.Health_check;
import Page_object.Home_page;
import Page_object.Login_page_objects;
import Page_object.Monitoring;

public class To_verify_HealthCheck extends Base_function {
	
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
	public void Verify_heathcheck() throws InterruptedException
	{
		Monitoring.Monitoring.click();
		Health_check.HealthCheck.click();
		boolean report=Health_check.Viewreport.isDisplayed();
		System.out.println(report);
		if(report==true)
		{
			Health_check.Viewreport.click();
			Thread.sleep(10000);
		}
		else
		{
			Health_check.Generate_report.click();
		}
		
	}
	
	@Test
	public void Health_RequestID() throws InterruptedException
	{
		PageFactory.initElements(driver,Health_check.class);
		PageFactory.initElements(driver,Monitoring.class);
		PageFactory.initElements(driver,Login_page_objects.class);
		login();
		Verify_server_dropdown();
		Verify_heathcheck();
	}

}
