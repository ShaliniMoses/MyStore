package test.steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductOrderTest {

	public WebDriver driver;
	Methoddefinition methoddef = new Methoddefinition(driver);
	Properties prop = new Properties();
	
	@Given("^I open the browser$")
	public void Open_Browser() throws Throwable {
//			DesiredCapabilities capability = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver");
			driver = new ChromeDriver();
			driver.get("http://automationpractice.com/index.php");
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}
	@And("^automation website exist$")
	public void automation_website_exist() throws Throwable {
		
		boolean elementpresent=methoddef.validatewebsite();
		System.out.println(elementpresent);
		if(elementpresent=true){
			Log.info("Website Exist");
		}else{
			Log.info("No Such Website");
			driver.close();
		}
	}

	@Then("^I click on signin button$")
	public void i_click_on_signin_button() throws Throwable {
		WebElement signin=driver.findElement(By.xpath("//a[@class='login']"));
		methoddef.ClickBtn(signin);
	}

	@When("^I enter the username \"([^\"]*)\"$")
	public void i_enter_the_username(String UserName) throws Throwable {
		WebElement uname=driver.findElement(By.xpath("//*[@id='email']"));
		methoddef.enterText(uname,UserName);
	}

	@When("^I enter the password  \"([^\"]*)\"$")
	public void i_enter_the_password(String password) throws Throwable {
		WebElement pwd=driver.findElement(By.xpath("//*[@id='passwd']"));
		methoddef.enterText(pwd,password);
	}

	@When("^Click on Login button$")
	public void click_on_Login_button() throws Throwable {
		WebElement login=driver.findElement(By.xpath("//*[contains(text(),'Sign in')]"));
		methoddef.ClickBtn(login);
	}

	@Then("^I validate the logged in page$")
	public void i_validate_the_logged_in_page() throws Throwable {
		WebElement signoutelement=driver.findElement(By.xpath("//*[contains(text(),'Sign out')]"));
		methoddef.validatePage(signoutelement);
		
	}
	@Then("^I click on Personal Information$")
	public void i_click_on_Personal_Information() throws Throwable {
		WebElement personalinfoelement=driver.findElement(By.xpath("//*[text()='My personal information']"));
		personalinfoelement.click();
	}
	
	@Then("^Update Personal Information$")
	public void Update_Personal_Information() throws Throwable {
		methoddef.updatefield();
	}
	@Then("^Click save button$")
	public void click_save_button() throws Throwable {
		methoddef.savePersonalInfo();
	}
	@Then("^I click T-Shirts$")
	public void i_click_T_Shirts() throws Throwable {
		WebElement tshirtoption=driver.findElement(By.xpath("//a[text()='T-shirts']"));
		methoddef.ClickBtn(tshirtoption);
		
	}
	@Then("^I select T-Shirts properties \"([^\"]*)\",\"([^\"]*)\"$")
	public void i_select_T_Shirts_properties(String size, String color) throws Throwable {
		WebElement tshirtoption=driver.findElement(By.xpath("//a[text()='T-shirts']"));
		methoddef.ClickBtn(tshirtoption);
		methoddef.tshirtoptions(size, color);
	}
	
	@Then("^I Validate the order History$")
	public void i_Validate_the_order_History() throws Throwable {
		methoddef.orderhistory();
	}
	@Then("^I click on signout button$")
	public void i_click_on_signout_button() throws Throwable {
		WebElement signoutelement=driver.findElement(By.xpath("//*[contains(text(),'Sign out')]"));
		methoddef.ClickBtn(signoutelement);
		
	}
	@Then("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.close();
	}
	
}


