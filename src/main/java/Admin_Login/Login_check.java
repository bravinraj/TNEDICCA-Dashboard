package Admin_Login;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Login_check extends Client_Management
{
	ConfigReader config;
    WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;
   // Client_Management cli=new Client_Management();
    
	@BeforeClass
	public void lunchbrowser()
	{
		// Set the path to your ChromeDriver executable
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\10155\\eclipse\\java-2022-12\\eclipse\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\10155\\eclipse\\java-2022-12\\eclipse\\geckodriver-v0.33.0-win32\\geckodriver.exe");
		 // Initialize the WebDriver
		 //driver = new ChromeDriver();
		 driver=new FirefoxDriver();
		  //driver=new FirefoxDriver();
		 
		//Maximize windows page
		driver.manage().window().maximize();
		
		 // Initialize ExtentReports
        extent = new ExtentReports();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
        config=new ConfigReader();
		
	}
	
	@Test
	public void login() throws InterruptedException
	{ 
		// Navigate to the login page	
				driver.get(config.getUrl());
				String loginpage_url=driver.getCurrentUrl();
				System.out.println(loginpage_url);
				Assert.assertEquals(loginpage_url, "https://dashboard.dev.tnedicca-api.com/login");
				test=extent.createTest("loginpage_URL",loginpage_url);
		
		// Find the username and password fields and enter your credentials
		 WebElement usernametextfield=driver.findElement(By.id("username"));
		 WebElement passwordtextfield=driver.findElement(By.id("password"));
		 //Verify password visible
		 WebElement loginbutton= driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		 WebElement eye_button=driver.findElement(By.xpath("//input[@id='password']//following::span[2]"));
		 String title= driver.getTitle();
		 Assert.assertEquals(title, "TNEDICCA Billing and Monitoring Dashboard");
		 test=extent.createTest("Home Page Title",title);
		
		 usernametextfield.sendKeys(config.getUsername());
		 passwordtextfield.sendKeys(config.getPassword());
		 Thread.sleep(3000);
	    String password_eye=passwordtextfield.getText();
	    System.out.println(password_eye);
	    Assert.assertEquals(password_eye,"");
	    test=extent.createTest("Verify Password is not visible",password_eye);
	     //verify eye icon button
		 eye_button.click();
	     password_eye=passwordtextfield.getAttribute("value"); 
	     System.out.println(password_eye);
	     Assert.assertEquals(password_eye,"AdMiN@123");
	     test=extent.createTest("Verify Password is visible",password_eye);
	     
	     //Verify login button
	     
	    loginbutton.click();
	    Thread.sleep(5000);
	    String Homepage= driver.findElement(By.xpath("//h3[contains(text(),'Client Management')]")).getText();
	    Assert.assertEquals(Homepage, "Client Management");
	    test=extent.createTest("Verify client mangement page display or Not",Homepage);
	    
	    //cli.Select_server();
	    //logout 
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement logout_dropdown= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"top-navbar_dropDownContainer__jeglI m-3\"]")));
	    //WebElement logout_dropdown=	driver.findElement(By.cssSelector("div[class=\\\"top-navbar_dropDownContainer__jeglI m-3\\"));
	    //WebElement logout_button=driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
	    WebElement logout_button= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"top-navbar_dropDown__GeGR3\"]")));
	    
	    //Verify logout
	    logout_dropdown.click();
	    
	    logout_button.click();

	}
	@Test
	public void Invalidusername() throws InterruptedException
	{
		 for (int i = 1; i <=3; i++)
		 {
			
			 if(i==1)
			 {
		       driver.get(config.getUrl());
		       
		     //Verify that the user is able to login with invalid Email
				  WebElement Invalidusernametextfield=driver.findElement(By.id("username"));
			      WebElement Validpasswordtextfield=driver.findElement(By.id("password"));
			      WebElement loginbutton1= driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		     
		       Invalidusernametextfield.sendKeys(config.getInvalidUsername());
		       Validpasswordtextfield.sendKeys(config.getPassword());
		       
		       loginbutton1.click();
		       
		       Thread.sleep(2000);
		       // Wait for the element to be present and visible
		        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']//following::p[1]")));
		       String errormessage=driver.findElement(By.xpath("//input[@id='password']//following::p[1]")).getText();
		   
		       System.out.println(errormessage);
		       Assert.assertEquals(errormessage,"Incorrect Username or Password");
		       test=extent.createTest("Invalid Username" ,errormessage);
		      
		    		  
		       
			 }
			 else if(i==2)
			 {
				 driver.get(config.getUrl());
				 WebElement validusernametextfield=driver.findElement(By.id("username"));
				 WebElement InValidpasswordtextfield=driver.findElement(By.id("password"));
				 WebElement loginbutton2= driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
				 
				 validusernametextfield.sendKeys(config.getUsername());
				 InValidpasswordtextfield.sendKeys(config.getinvalidPassword());
				 loginbutton2.click();
				 
			 }
			 else
			 {
				 driver.get(config.getUrl());
				 WebElement INvalidusernametextfield=driver.findElement(By.id("username"));
				 WebElement INValidpasswordtextfield=driver.findElement(By.id("password"));
				 WebElement loginbutton3= driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
				 
				 INvalidusernametextfield.sendKeys(config.getInvalidUsername());
				 INValidpasswordtextfield.sendKeys(config.getinvalidPassword());
				 loginbutton3.click();
				 
			 }
		
		 }
		
	}
	
    
	/*@Test
	public void logout() throws InterruptedException 
	{
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 WebElement logout_dropdown= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"top-navbar_dropDownContainer__jeglI m-3\"]")));
	    //WebElement logout_dropdown=	driver.findElement(By.cssSelector("div[class=\\\"top-navbar_dropDownContainer__jeglI m-3\\"));
	    //WebElement logout_button=driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
	    WebElement logout_button= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"top-navbar_dropDown__GeGR3\"]")));
	    
	    //Verify logout
	    logout_dropdown.click();
	    
	    logout_button.click();
	}*/
	
	
       @AfterClass
      public void teardown()
     {
      // Close the WebDriver
	     driver.quit();
	  // Flush the ExtentReports
	        extent.flush();
     }
}
