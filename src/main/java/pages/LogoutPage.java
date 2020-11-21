package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends PageBase {

	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="button.mat-menu-trigger")
	WebElement logOutGroup;
	
	@FindBy(css="button.mat-menu-item.ng-tns-c72-0")
	List<WebElement> logOutButtonList;
		
	public void userLogOut() throws InterruptedException{
		clickButton(logOutGroup);
		Thread.sleep(2000);
		clickButton(logOutButtonList.get(2));
	}
}