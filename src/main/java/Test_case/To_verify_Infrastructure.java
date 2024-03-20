package Test_case;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.Home_page;
import Page_object.Login_page_objects;
import Page_object.Monitoring;

public class To_verify_Infrastructure extends Base_function {

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
	public void Infrastrcture() throws InterruptedException
	{
		Monitoring.Monitoring.click();
		Monitoring.Infrastructure.click();
		Thread.sleep(1000);
		Monitoring.year.click();
		Monitoring.select_year.click();
		Actions dropdown=new Actions(driver);
		//dropdown.click(Monitoring.select_year).build().perform();
		Thread.sleep(1000);
		dropdown.keyDown(Keys.CONTROL).click(Monitoring.select_year).keyUp(Keys.CONTROL).build().perform();

		//Monitoring.select_year_1.click();
		//dropdown.click(Monitoring.select_year_1).build().perform();
        Monitoring.Month.click();
        dropdown.doubleClick(Monitoring.select_month).build().perform();
		//Monitoring.select_month.click();
		Thread.sleep(1000);
		//Monitoring.select_month_1.click();
		//Thread.sleep(1000);
	}
    public void Expiring() throws InterruptedException
    {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", Monitoring.Expiring_this_week);
		Thread.sleep(2000);
		Monitoring.Expiring_this_month.click();
		Thread.sleep(1000);
		//new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Monitoring.Expiring_this_week));
		Monitoring.Expiring_this_week.click();
    }
	@Test
	public void Monitoring_Infrasture() throws InterruptedException
	{
		PageFactory.initElements(driver,Login_page_objects.class);
		PageFactory.initElements(driver,Home_page.class);
		PageFactory.initElements(driver,Monitoring.class);
		login();
		Verify_server_dropdown();
		Infrastrcture();
		Expiring();

	}
}
