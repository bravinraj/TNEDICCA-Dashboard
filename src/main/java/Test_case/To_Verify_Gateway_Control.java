package Test_case;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_function.Base_function;
import Page_object.Gateway_Control;
import Page_object.Home_page;
import Page_object.Login_page_objects;

public class To_Verify_Gateway_Control extends Base_function {


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
	public void AddIp() throws InterruptedException
	{
		Gateway_Control.Gatewaycontrol.click();
		String Gatewaycontrolpage=Gateway_Control.Ipbutton.getText();
		System.out.println(Gatewaycontrolpage);
		Assert.assertEquals("Blacklist", Gatewaycontrolpage);
		String BlacklistIP=	properties.getProperty("ip_address1");
		Gateway_Control.IPblacklist.sendKeys(BlacklistIP);
		Gateway_Control.Ipbutton.click();
		Thread.sleep(10000);
		String Alertmessage=Gateway_Control.ipaddmessage.getText();
		String successmessage= properties.getProperty("ipadd_success_message");
		String errormessage=properties.getProperty("ipadd_error_message");

		if (Alertmessage.equals(successmessage)) {
			Assert.assertEquals(Alertmessage, successmessage);
			System.out.println("Alertmessage="+Alertmessage);
		} else if (Alertmessage.equals(errormessage)) {
			Assert.assertEquals(Alertmessage, errormessage);
			System.out.println("Alertmessage="+Alertmessage);
		}else
		{
			System.out.println("Error Message");
		}

		Gateway_Control.messagehandle.click();
		driver.navigate().refresh();
		// String  ActualIP= Gateway_Control.IPaddress.getText();
		//System.out.println(ActualIP);
		// Assert.assertEquals(ActualIP, BlacklistIP);

	}

	public void Removeblacklist() throws InterruptedException
	{ 
		driver.navigate().refresh();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Gateway_Control.Ipremove);
		Gateway_Control.Ipremove.click();
		Thread.sleep(1000);
		String removemessage=properties.getProperty("ipremove_message");
		String removeipmessage=	Gateway_Control.ipaddmessage.getText();
		Assert.assertEquals(removeipmessage, removemessage);
		Gateway_Control.messagehandle.click();
		driver.navigate().refresh();
	}

	public void nextpagepreviouspage() throws InterruptedException
	{
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Gateway_Control.Nextbutton);
		Thread.sleep(1000);
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(Gateway_Control.Nextbutton));
		Gateway_Control.Nextbutton.click();
		Thread.sleep(1000);
		String nextpageSNO=	Gateway_Control.Nextpageassertion.getText();
		Assert.assertTrue(nextpageSNO.equals("11"), "page moved to next page");
		Gateway_Control.previouspage.click();
		Thread.sleep(1000);
		String prviouspageSNO=Gateway_Control.previouspageassertion.getText();
		Assert.assertTrue(prviouspageSNO.equals("1"), "page moved to next page");
	}
	public void Reloadserver() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Gateway_Control.Reloadbutton);
		Thread.sleep(2000);
		new WebDriverWait(driver,Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(Gateway_Control.Reloadbutton));
		Thread.sleep(2000);
		Gateway_Control.Reloadbutton.click();
		Thread.sleep(1000);
		String reloadalert=	Gateway_Control.Reloadalert.getText();
		String reloadservermessage= properties.getProperty("reloadserver_message");
		Assert.assertEquals(reloadalert, reloadservermessage);
		Gateway_Control.alertok.click();
		//Gateway_Control.alertcancel.click();
	}

	@Test
	public void GatewayControl() throws InterruptedException
	{
		PageFactory.initElements(driver, Gateway_Control.class);
		PageFactory.initElements(driver, Home_page.class);
		PageFactory.initElements(driver, Login_page_objects.class);
		login();
		Verify_server_dropdown();
		AddIp();
		nextpagepreviouspage();
		Removeblacklist();
		Reloadserver();
		nextpagepreviouspage();
	}

}
