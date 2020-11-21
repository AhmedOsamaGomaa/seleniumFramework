package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
		javaScriptExecutor = (JavascriptExecutor) driver;
	}
	
	@FindBy(id ="identifierId")
	WebElement emailTextBox;

	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button")
	WebElement nextButton;

	@FindBy(css="input.whsOnd.zHQkBf")
	WebElement passwordTextBox;
	
	@FindBy(css="button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc")
	WebElement nextButton2;	
	
	@FindBy(id=":2f")
	WebElement BlueRideEmail;
	
	@FindBy(linkText="Reset Password")
	WebElement resetPasswordButton;
	
	public void userLogIn(String email, String password) throws InterruptedException{

		setTextElementText(emailTextBox, email);
		clickButton(nextButton);
		Thread.sleep(2500);
		setTextElementText(passwordTextBox, password);
		clickButton(nextButton2);
		Thread.sleep(2500);
		clickButton(BlueRideEmail);
		scrollToBottom();
		Thread.sleep(2000);
		clickButton(resetPasswordButton);
	}	
}