package Test_case;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.ApplicationMonitoring;
import Page_object.Home_page;
import Page_object.Login_page_objects;
import Page_object.Monitoring;

public class To_verify_GatewayMonitoring extends Base_function {
	
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
	public void TE_Application() throws InterruptedException
	{
	 Monitoring.Monitoring.click();
     ApplicationMonitoring.GatewayMonitoring.click();
    // ApplicationMonitoring.Refresh_button.click();
    // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
    // WebElement element = wait.until(ExpectedConditions.visibilityOf(ApplicationMonitoring.Client_dropdown));
     ApplicationMonitoring.Client_dropdown.click();
     ApplicationMonitoring.Alluser.click();
     ApplicationMonitoring.datedropdowm.click();
     ApplicationMonitoring.Today.click();
     Thread.sleep(1000);
     ApplicationMonitoring.Search.click();
     Thread.sleep(1000);
	}
	
	public void Gateway_Date() throws InterruptedException
	{
		ApplicationMonitoring.datedropdowm.click();
		ApplicationMonitoring.Date.click();
		Thread.sleep(1000);
		//ApplicationMonitoring.StartDate.sendKeys(properties.getProperty("start_date"));
		ApplicationMonitoring.Search.click();
		Thread.sleep(1000);
	}
	
	public void Gateway_Daterange() throws InterruptedException
	{
		ApplicationMonitoring.datedropdowm.click();
		ApplicationMonitoring.DateRange.click();
		Thread.sleep(3000);
		ApplicationMonitoring.StartDate.sendKeys(properties.getProperty("start_date_1"));
		Thread.sleep(3000);
		ApplicationMonitoring.Enddate.sendKeys(properties.getProperty("End_date_1"));
		Thread.sleep(1000);
		ApplicationMonitoring.Search.click();
		Thread.sleep(1000);
		Actions action=new Actions(driver);
		action.moveToElement(ApplicationMonitoring.Successpercentage).perform();
		 try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		String Successpercentage= ApplicationMonitoring.Suc_tooltip.getText();
		System.out.println(Successpercentage);
		
	}
	
	public void Gateway_Success_Error() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", ApplicationMonitoring.Error);
		Thread.sleep(1000);
		ApplicationMonitoring.Error.click();
		ApplicationMonitoring.Success.click();
		Thread.sleep(1000);
	}
	@Test
	public void Gateway_monitoring() throws InterruptedException
	{
		PageFactory.initElements(driver,Login_page_objects.class);
		PageFactory.initElements(driver,Home_page.class);
		PageFactory.initElements(driver,ApplicationMonitoring.class);
		PageFactory.initElements(driver, Monitoring.class);
		login();
		Verify_server_dropdown();
		TE_Application();
		Gateway_Date();
		Gateway_Daterange();
		Gateway_Success_Error();
	}

}
