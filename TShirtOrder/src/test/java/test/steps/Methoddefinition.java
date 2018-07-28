package test.steps;

import org.apache.struts.action.Action;
import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Methoddefinition {
	public WebDriver driver;
	public Methoddefinition() {
	}
	public Methoddefinition(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean validatewebsite()
	{
		WebElement logoelement=driver.findElement(By.xpath("//img[contains(@src,'logo.jpg')]"));
		boolean status=logoelement.isDisplayed();
		System.out.println("Status"+status);
		if(status=true){
			Log.info("Website Exist");
		}else{
			Log.info("No Such Website");
		}
		return status;
	}
	
	public boolean ClickBtn(WebElement element) throws ElementNotFoundException
	{
		boolean status=element.isDisplayed();
		System.out.println("Status"+status);
		if(status=true){
			Log.info("Element Exist");
			element.click();
		}else{
			Log.info("No Such Element");
		}
		return status;
	}
	public boolean enterText(WebElement element, String value) throws ElementNotFoundException
	{
		boolean status=element.isDisplayed();
		System.out.println("Status"+status);
		if(status=true){
			Log.info("Element Exist");
			element.sendKeys(value);
		}else{
			Log.info("No Such Element");
		}
		
		return status;
	}
	
	public void validatePage(WebElement element) throws ElementNotFoundException
	{
		boolean status=element.isDisplayed();
		System.out.println("Status"+status);
		if(status=true){
			Log.info("Page Validation Successful");
		}else{
			Log.info("Page Validation Failed");
		}
		
	}
	
	public void tshirtoptions(String size, String color) throws ElementNotFoundException
	{
		WebElement smallsize=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_1']"));
		WebElement mediumsize=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_2']"));
		WebElement largesize=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_3']"));
		
		WebElement orangecolor=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_13']"));
		WebElement bluecolor=driver.findElement(By.xpath("//input[@id='layered_id_attribute_group_14']"));
		
		if(size.equalsIgnoreCase("small")){
			if(smallsize.isSelected()){
				Log.info("Already Selected");
			}else{
				smallsize.click();
			}
			
		}if(size.equalsIgnoreCase("medium")){
			if(mediumsize.isSelected()){
				Log.info("Already Selected");
			}else{
				mediumsize.click();
			}
		}if(size.equalsIgnoreCase("large")){
			if(largesize.isSelected()){
				Log.info("Already Selected");
			}else{
				largesize.click();
			}
		}
		if(color.equalsIgnoreCase("Orange")){
			if(orangecolor.isSelected()){
				Log.info("Already Selected");
			}else{
				orangecolor.click();
			}
			
		}if(color.equalsIgnoreCase("Blue")){
			if(bluecolor.isSelected()){
				Log.info("Already Selected");
			}else{
				bluecolor.click();
			}
		}
	}
		public void orderhistory() throws ElementNotFoundException
		{
		WebElement instock=driver.findElement(By.xpath("//div[@class='product-container']//following::*[@class='availability']"));
		WebElement addtocart=driver.findElement(By.xpath("//*[text()='Add to cart']"));
		Actions act=new Actions(driver);
		act.moveToElement(instock).perform();
		addtocart.click();
		
		WebElement successmsg=driver.findElement(By.xpath("//div[@id='layer_cart']//following::*[@class='icon-ok']"));
		driver.switchTo().activeElement();
		if(successmsg.isDisplayed()){
			Log.info("T-Shirt added to cart");
		}else{
			Log.info("Functionality failed");
		}
		
	}
	public void updatefield() throws ElementNotFoundException
		{
			WebElement fname=driver.findElement(By.xpath("//*[@id='firstname']"));
			WebElement currpassword=driver.findElement(By.xpath("//*[@id='old_passwd']"));
			
			fname.clear();
			fname.sendKeys("Rajaram_Edited");
			
			currpassword.clear();
			currpassword.sendKeys("Rajaram_Edited");
		}	
		public void savePersonalInfo() throws ElementNotFoundException
		{
			WebElement saveelement=driver.findElement(By.xpath("//*[text()='Save']"));
			saveelement.click();
			WebElement msg=driver.findElement(By.xpath("//*[contains(@class,'alert-success')]"));
			if(msg.isDisplayed()){
				Log.info("Personal information update successful");
			}else{
				System.out.println(msg.getText());
				Log.info(msg.getText(),"Make appropriate corrections");
			}
		}
}
