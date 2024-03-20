package Page_object;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page {

	@FindBy(id="demo-simple-select")
	public static WebElement dropdown;

	@FindBy(xpath = "//li[contains(text(),'RDS Development Database ELRS')]")
	public static WebElement select_option;

	@FindBy(xpath = "//div[@id='resizeIcon']//following::img[1]")
	public static WebElement Expand_button;

	@FindBy(xpath = "//button[contains(text(),'Add new client')]")
	public static WebElement Add_client_button;

	@FindBy(xpath = "//h6[contains(text(),'Client Name')]//following::input[1]")
	public static WebElement Client_name_text_field;

	@FindBy(xpath = "//h6[contains(text(),'Max Requests')]//following::input[1]")
	public static WebElement Max_request_text_field;

	@FindBy(xpath = "//label[contains(text(),'Validity')]//following::input[1]")
	public static WebElement Valid_until_text_field;

	@FindBy(xpath = "//label[contains(text(),'Validity')]//following::button[1]")
	public static WebElement date_picker;

	@FindBy(xpath = "//div[@id='mui-4-grid-label']")
	public static WebElement current_year_month;

	@FindBy(xpath = "//div[contains(text(),'2024')]//following::button[3]")
	public static WebElement Next_button;

	@FindBy(xpath = "//button[contains(text(),'27')]")
	public static WebElement Select_date;

	@FindBy(xpath = "//label[contains(text(),'Carfax Key')]//following::input[1]")
	public static WebElement carfax_key_text_field;

	//@FindBy(xpath = "//h6[contains(text(),'Enable Carfax Access')]//following::span[2]")
	//public static WebElement carfax_access;

	//@FindBy(xpath = "//h6[contains(text(),'Show Carfax Response')]//following::span[2]")
	//public static WebElement Show_carfax_response;

	//@FindBy(xpath = "//h6[contains(text(),'Show LRS Response')]//following::span[1]")
	//public static WebElement Show_LRS_Response;

	//@FindBy(xpath = "//h6[contains(text(),'Show ELRS Response')]//following::span[2]")
	//public static WebElement Show_ELRS_Response;

	@FindBy(xpath = "//div[@id='mui-component-select-fieldsOutput']")
	public static WebElement Fields;

	@FindBy(xpath = "//li[contains(text(),'status')]")
	public static WebElement Fileds_dropdown;

	@FindBy(xpath = "//h6[contains(text(),'Address')]//following::textarea[1]")
	public static WebElement Address;

	@FindBy(xpath = "//label[contains(text(),'Not Required')]//following::span[1]")
	public static WebElement certificate_checkbox;

	@FindBy(id = "mui-2")
	public static WebElement start_date;

	@FindBy(id = "mui-3")
	public static WebElement End_date;

	@FindBy(xpath = "//div[@id='mui-component-select-versionAccess']")
	public static WebElement Version_access;

	@FindBy(xpath = "//h6[contains(text(),'Version Access')]//following::li[1]")
	public static WebElement version_dropdown;

	@FindBy(xpath = "//label[contains(text(),'Allowed QPS')]//following::input[1]")
	public static WebElement Allowed_QPS;

	@FindBy(xpath = "//label[contains(text(),'Allowed QPM')]//following::input[1]")
	public static WebElement Allowed_QPM;

	@FindBy(name ="whiteListedIps")
	public static WebElement Whitelist_Ip;

	@FindBy(xpath = "//button[contains(text(),'Add Client')]")
	public static WebElement submit_button;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	public static WebElement Cancel_button;

	@FindBy(xpath = "//input[contains(@placeholder,'Filter by entering the search text')]")
	public static WebElement searchbox;

	@FindBy(xpath = "//*[text()='Search']")
	public static WebElement search_button;

	@FindBy(xpath = "//h3[contains(text(),'Client Management')]//following::div[3]")
	public static WebElement expandersize;

	@FindBy(xpath = "//h3[contains(text(),'Add New Client')]")
	public static WebElement addclientpage;
     
	@FindBy(xpath = "//h6[contains(text(),'Customer Type')]//following::input[1]")
	public static WebElement ELRS_customerType;
	
	@FindBy(xpath = "//h6[contains(text(),'Customer Type')]//following::input[2]")
	public static WebElement LRS_customerType;
	
	@FindBy(xpath="//h6[contains(text(),'Customer Type')]//following::input[3]")
	public static WebElement LBRS_customerType;
	
	@FindBy(xpath = "//h6[contains(text(),'Customer Access')]//following::input[1]")
    public static WebElement carfax_access;
	
	@FindBy(xpath = "//h6[contains(text(),'Customer Access')]//following::input[2]")
	public static WebElement carfax_response;
	
	@FindBy(xpath = "//h6[contains(text(),'Customer Access')]//following::input[3]")
	public static WebElement ELRS_response;
	
	@FindBy(xpath = "//h6[contains(text(),'Customer Access')]//following::input[4]")
	public static WebElement LRS_response;
	
	@FindBy(xpath = "//a[contains(text(),'State Version Access')]")
	public static WebElement state_version_access;
	
	@FindBy(xpath = "//div[@id='state-select=3']")
	public static WebElement Statewise_version;
	
	@FindBy(xpath = "//li[contains(text(),'2')]")
	public static WebElement version_change;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]")
	public static WebElement save;
	
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	public static WebElement Cancel;
}
