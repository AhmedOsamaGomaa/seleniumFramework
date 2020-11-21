package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends PageBase{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(id="mat-input-2")
	WebElement emailField;

	@FindBy(xpath="/html/body/app-root/div/section/app-forgot-password/div/div[1]/div[2]/button")
	WebElement sendButton;

	@FindBy(tagName="label")
	public WebElement approvedMessage;

	@FindBy(id="mat-error-37")
	public WebElement errorMessage;
	
	public void sendRestorationLink(String email){

		setTextElementText(emailField, email);
		clickButton(sendButton);
	}
}