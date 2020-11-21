package tests;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.ResetPasswordPage;

public class ForgotPasswordTest extends TestBase{

	LoginPage loginObject;
	ForgotPasswordPage forgotPasswordObject;
	EmailPage emailObject;
	ResetPasswordPage resetPasswordObject;

	@Test
	public void userForgotPassword() throws InterruptedException{

		//Forgot Password Page
		loginObject = new LoginPage(driver);
		loginObject.openForgotPasswordPage();
		forgotPasswordObject = new ForgotPasswordPage(driver);
		Thread.sleep(2000);
		forgotPasswordObject.sendRestorationLink("ahmadosamagom3a@gmail.com");
		Thread.sleep(2000);
		Assert.assertTrue(forgotPasswordObject.approvedMessage.getText().contains("Check Your Email !"));

		//Email Page
		driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
		emailObject = new EmailPage(driver);
		emailObject.userLogIn("ahmadosamagom3a@gmail.com","@AboOsama98@");

		//Switch tabs
		resetPasswordObject = new ResetPasswordPage(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		resetPasswordObject.switchTabs(driver);
		
		//Reset Password Page
		//Thread.sleep(3000);
		resetPasswordObject.resetPassword("osama@admin.com", "133421", "133421");
		Thread.sleep(3000);
		loginObject.userLogIn("osama@admin.com", "133421");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getCurrentUrl(), "http://138.68.58.187/dashboard/students");
	}
	
	@Test(enabled=false)
	public void failureUserForgotPassword() throws InterruptedException{
		
		loginObject = new LoginPage(driver);
		loginObject.openForgotPasswordPage();
		forgotPasswordObject = new ForgotPasswordPage(driver);
		forgotPasswordObject.sendRestorationLink("ahmadosam@gmail.com");
		Thread.sleep(2000);
		Assert.assertTrue(forgotPasswordObject.errorMessage.getText().contains("We Can't Find A User With That E-Mail Address"));
	}
}