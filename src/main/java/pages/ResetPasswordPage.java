package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends PageBase{

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="mat-input-0")
	WebElement emailTextBox;
	
	@FindBy(id="mat-input-1")
	WebElement newPasswordTextBox;
	
	@FindBy(id="mat-input-2")
	WebElement confirmNewPasswordTextBox;
	
	@FindBy(css="button.btn.btn-primary.send-btn")
	WebElement resetButton;
	
	@FindBy(css="body")
	WebElement bodyTab;
	
	public void resetPassword(String email, String newPassword, String confirmNewPassword){
		
		setTextElementText(emailTextBox, email);
		setTextElementText(newPasswordTextBox, newPassword);
		setTextElementText(confirmNewPasswordTextBox, confirmNewPassword);
		clickButton(resetButton);
	}
	
	public void switchTabs(WebDriver driver){
		
		switchBetweenTabs(bodyTab,driver);
	}
}