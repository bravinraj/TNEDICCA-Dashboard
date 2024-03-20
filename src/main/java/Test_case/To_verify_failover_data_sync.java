package Test_case;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.Fail_over_data_sync;
import Page_object.Home_page;
import Page_object.Login_page_objects;

public class To_verify_failover_data_sync extends Base_function {

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

	public void Verify_failover() throws InterruptedException
	{
		Fail_over_data_sync.failoverdata_button.click();
		Thread.sleep(1000);
		Fail_over_data_sync.Truncate.click();
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(Fail_over_data_sync.handle_alert));
		Fail_over_data_sync.handle_alert.click();

	}

	public void verify_Export() throws InterruptedException
	{
		Thread.sleep(1000);
		Fail_over_data_sync.start_date.sendKeys(properties.getProperty("start_date"));
		Thread.sleep(1000);
		Fail_over_data_sync.End_date.sendKeys(properties.getProperty("End_date"));
		Thread.sleep(1000);
		Fail_over_data_sync.Ok_button.click();
		//new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(Fail_over_data_sync.Export_button));
		Fail_over_data_sync.Export_button.click();
		Thread.sleep(3000);
		Fail_over_data_sync.Export.click();
		//Fail_over_data_sync.Cancel.click();
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Fail_over_data_sync.handle_alert));
		Fail_over_data_sync.handle_alert.click();
		Thread.sleep(1000);
	}

	public void Verify_Import() throws InterruptedException
	{
		Fail_over_data_sync.start_date.sendKeys(properties.getProperty("start_date"));
		Fail_over_data_sync.End_date.sendKeys(properties.getProperty("End_date"));
		Thread.sleep(1000);
		Fail_over_data_sync.Ok_button.click();
		Fail_over_data_sync.Import_button.click();
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Fail_over_data_sync.handle_alert));
		Fail_over_data_sync.handle_alert.click();
		Thread.sleep(1000);
	}
	public void QC_imported_data() throws InterruptedException
	{
		Fail_over_data_sync.QC_import.click();
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Fail_over_data_sync.handle_alert));
		Fail_over_data_sync.handle_alert.click();
	}
	public void merge_imported_data() throws InterruptedException
	{
		Fail_over_data_sync.Merge_import_data.click();
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Fail_over_data_sync.handle_alert));
		Fail_over_data_sync.handle_alert.click();
	}
	public void pages() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Fail_over_data_sync.Nextbutton);
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Fail_over_data_sync.Nextbutton));
		Fail_over_data_sync.Nextbutton.click();
		Thread.sleep(1000);
		Fail_over_data_sync.previousbutton.click();
		Thread.sleep(1000);
	}
	@Test
	public void Failover() throws InterruptedException
	{
		PageFactory.initElements(driver,Fail_over_data_sync.class);
		PageFactory.initElements(driver,Login_page_objects.class);
		PageFactory.initElements(driver,Home_page.class);
		login();
		Verify_server_dropdown();
		Verify_failover();
		verify_Export();
		Verify_Import();
		QC_imported_data();
		merge_imported_data();
		pages();

	}
}
