package Test_case;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Common_function.Base_function;
import Page_object.Home_page;
import Page_object.Login_page_objects;

public class To_verify_Home_page extends Base_function{
	ExtentTest test;
	ExtentReports extent;
	//To_Verify_login_page loginpage=new To_Verify_login_page(driver);
	SoftAssert softassert=new SoftAssert();
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
	public void Verify_expand_button() throws InterruptedException
	{
		PageFactory.initElements(driver,Home_page.class);
		Dimension beforexpandsize=Home_page.expandersize.getSize();
		System.out.println(beforexpandsize);
		Thread.sleep(2000);
		Home_page.Expand_button.click();
		Dimension afterexpandsize=Home_page.expandersize.getSize();
		System.out.println(afterexpandsize);
		//softassert.assertEquals("(1088, 365)", afterexpandsize);
		//softassert.assertAll();
	}
	public void Verify_add_client_button() throws InterruptedException
	{
		Home_page.Add_client_button.click();
		String addclientbutton=Home_page.addclientpage.getText();
		Thread.sleep(2000);
		Assert.assertEquals("Add New Client", addclientbutton);
	}
	public void Verify_add_client() throws InterruptedException, AWTException
	{
		//Client Name Text field
		Home_page.Client_name_text_field.sendKeys(properties.getProperty("Client_Name"));
		//Max request text field
		Home_page.Max_request_text_field.sendKeys(properties.getProperty("Max_Requests"));
		//Thread.sleep(2000);
		//Home_page.Valid_until_text_field.sendKeys(properties.getProperty("Valid_until"));
		Thread.sleep(2000);
		//Valid Until date picker
		Home_page.date_picker.click();
		//Thread.sleep(2000);
		new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(Home_page.current_year_month));
		String monthyear=Home_page.current_year_month.getText();
		System.out.println(monthyear);//October 2023
		String month= monthyear.split(" ")[0].trim();
		String year= monthyear.split(" ")[1].trim();

		while(!(month.equals("March")) && year.equals("2024"))
		{
			Home_page.Next_button.click();
			Thread.sleep(2000);
			monthyear=Home_page.current_year_month.getText();
			System.out.println(monthyear);
			month= monthyear.split(" ")[0].trim();
			year= monthyear.split(" ")[1].trim();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView();", Home_page.Select_date);
		Home_page.Select_date.click();
		//carfax key Text filed

		new WebDriverWait(driver,Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfAllElements(Home_page.carfax_key_text_field));
		Home_page.carfax_key_text_field.sendKeys(properties.getProperty("Carfax_key"));
		//Customer Type ELRS 
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 js.executeScript("arguments[0].scrollIntoView();", Home_page.submit_button);
		 Home_page.ELRS_customerType.click();
		 Home_page.carfax_access.click();
		 Home_page.carfax_response.click();
		 Home_page.ELRS_response.click();
		 Thread.sleep(3000);
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 js.executeScript("arguments[0].scrollIntoView();", Home_page.LRS_response);
		 Thread.sleep(1000);
		 Home_page.LRS_response.click();
		//Home_page.carfax_access.click();
		 
		 //Customer Type LRS
		 Home_page.LRS_customerType.click();
		 Home_page.LRS_response.click();
		 
		 //Customer Type LBRS
		 Home_page.LBRS_customerType.click();

		//carfax Response 
		//Home_page.Show_carfax_response.click();

		//ELRS Response
		//Home_page.Show_ELRS_Response.click();
		Thread.sleep(2000);
		//scroll down 
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("arguments[0].scrollIntoView();", Home_page.submit_button);

		//LRS Response
		//Home_page.Show_LRS_Response.click();
		//Fields_dropdown
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();", Home_page.Fields);
		Thread.sleep(3000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Home_page.Fields));
		Home_page.Fields.click();
		Thread.sleep(2000);
		Home_page.Fileds_dropdown.click();
		Thread.sleep(2000);
		//Address Text field
		Home_page.Address.sendKeys(properties.getProperty("Address"));

		Thread.sleep(2000);
		//Version access dropdown
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Home_page.Version_access)).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Home_page.version_dropdown)).click();
		Thread.sleep(2000);
		//Allowed QPS Text field
		Home_page.Allowed_QPS.clear();
		Home_page.Allowed_QPS.sendKeys(properties.getProperty("Allowed_QPS"));
		//Allowed QPM Text field
		Home_page.Allowed_QPM.clear();
		Home_page.Allowed_QPM.sendKeys(properties.getProperty("Allowed_QPM"));
		//Allowed WhitelistIp Textfield
		Home_page.Whitelist_Ip.sendKeys(properties.getProperty("ip_address"));
		Home_page.state_version_access.click();
		Home_page.Statewise_version.click();
		Thread.sleep(1000);
		Home_page.version_change.click();
		js.executeScript("arguments[0].scrollIntoView();", Home_page.save);
		Thread.sleep(2000);
		Home_page.save.click();
		//Home_page.Cancel.click();
		js.executeScript("arguments[0].scrollIntoView();", Home_page.submit_button);
		Thread.sleep(2000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Home_page.submit_button));
		Home_page.Cancel_button.click();
		Thread.sleep(2000);
		//Home_page.submit_button.click();

	}
	public void search_box() throws InterruptedException
	{
		Thread.sleep(20000);
		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(Home_page.searchbox));
		Home_page.searchbox.sendKeys(properties.getProperty("Client_Name"));
		Home_page.search_button.click();
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void Homepage() throws InterruptedException, AWTException
	{
		PageFactory.initElements(driver,Home_page.class);
		PageFactory.initElements(driver, Login_page_objects.class);
		login();
		Thread.sleep(2000);
		Verify_server_dropdown();
		Thread.sleep(1000);
		Verify_expand_button();
		Thread.sleep(2000);
		Verify_add_client_button();
		Verify_add_client();
		search_box();
	}


}
