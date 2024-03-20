package Test_case;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.Edit_Client;
import Page_object.Home_page;
import Page_object.Login_page_objects;

public class To_Verify_Edit_Client extends Base_function
{
	//To_Verify_login_page loginpage=new To_Verify_login_page(driver);
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
	public void EditClient() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Edit_Client.Editicon);
		Thread.sleep(2000);
		Edit_Client.Editicon.click();
		String edit_page=	Edit_Client.edittext.getText();
		Assert.assertEquals("Edit Client", edit_page);
		Thread.sleep(2000);
		Home_page.Max_request_text_field.clear();
		Home_page.Max_request_text_field.sendKeys(properties.getProperty("Max_Requests_1"));

		Home_page.Allowed_QPS.clear();
		Home_page.Allowed_QPS.sendKeys(properties.getProperty("Allowed_QPS_1"));

		Home_page.Allowed_QPM.clear();
		Home_page.Allowed_QPM.sendKeys(properties.getProperty("Allowed_QPM_1"));

		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", Edit_Client.updateclient);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Edit_Client.updateclient));
		Thread.sleep(2000);
		Edit_Client.updateclient.click();
		Thread.sleep(7000);
		Edit_Client.Alert.click();
		js.executeScript("arguments[0].scrollIntoView();", Edit_Client.back_button);
		Thread.sleep(1000);
		Edit_Client.back_button.click();
	}
	public void disable() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Edit_Client.disablebutton);
		Thread.sleep(2000);
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(Edit_Client.disablebutton));
		Edit_Client.disablebutton.click();
		Thread.sleep(1000);
	}

	@Test
	public void Edit_Client_Feature() throws InterruptedException 
	{
		PageFactory.initElements(driver, Home_page.class);
		PageFactory.initElements(driver, Login_page_objects.class);
		PageFactory.initElements(driver,Edit_Client.class);
		login();
		Verify_server_dropdown();
		EditClient();
		disable();

	}



}
