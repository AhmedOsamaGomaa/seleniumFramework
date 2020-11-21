package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		//object from javaScript to scroll down in the page 
		javaScriptExecutor = (JavascriptExecutor) driver;
	}

	@FindBy(id="mat-input-0")
	WebElement emailTextBox;

	@FindBy(id="mat-input-1")
	WebElement passwordTextBox;

	@FindBy(xpath="//button")
	WebElement logInButton;
	
	@FindBy(css="div.snackBar-content")
	public WebElement errorMessage; //Invalid Login Credentials

	@FindBy(className="bold")
	public WebElement logInPageMessage;
	
	@FindBy(linkText="Forgot Password")
	WebElement forgotPasswordLink;
	
	public void userLogIn(String email, String password){
		
		setTextElementText(emailTextBox, email);
		setTextElementText(passwordTextBox, password);
		clickButton(logInButton);
	}
		
	public void openForgotPasswordPage(){
		clickButton(forgotPasswordLink);
	}
}