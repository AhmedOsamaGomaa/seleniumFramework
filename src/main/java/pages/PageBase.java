package pages;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver chromeDriver;
	protected WebDriver edgeDriver;
	protected WebDriver fireFoxDriver;
	public JavascriptExecutor javaScriptExecutor;
	
	//create constructor
	public PageBase(WebDriver driver){

		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button){

		button.click();
	}

	protected static void setTextElementText(WebElement textElement, String value){
		
		textElement.clear();
		textElement.sendKeys(value);
	}
	
	protected void switchBetweenTabs(WebElement tabBody, WebDriver driver){
		
		tabBody.sendKeys(Keys.CONTROL+"\t");
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	}
	
	
	public void scrollToBottom(){
		
		javaScriptExecutor.executeScript("scrollBy(0,2500)");
	}
}