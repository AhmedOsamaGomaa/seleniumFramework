package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTest extends TestBase{

	LoginPage loginObject;
	LogoutPage logoutObject;
	
	@DataProvider(name="testRightData")
	public static Object [][] userRightData(){
		return new Object[][] {
			{"osama@admin.com","123456"},
			{"hennawyadmin@gmail.com","123456"},
			};
	}
	
	@DataProvider(name="testWrongData")
	public static Object [][] userWrongData(){
		return new Object[][] {
			//Wrong email -- Right Password
			{"odsgvxz@gj.com","123456"},
			//Right email -- Wrong password
			{"osama@admin.com","187564"},
			//Wrong email -- Wrong password
			{"odsjoh@fjngsjs.com","215487"}
			};
	}
	
	@Test(alwaysRun=true, dataProvider="testRightData")
	public void userLoginSuccessfully(String email, String password) throws InterruptedException{
		loginObject = new LoginPage(driver);
		loginObject.userLogIn(email, password);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://138.68.58.187/dashboard/students");
		driver.navigate().refresh();
		logoutObject = new LogoutPage(driver);
		logoutObject.userLogOut();
		Assert.assertTrue(loginObject.logInPageMessage.getText().contains("Increase Responsibilities .."));
		driver.navigate().refresh();
	}
	
	@Test(dataProvider="testWrongData")
	public void userFailToLogin(String name, String password){
		loginObject = new LoginPage(driver);
		loginObject.userLogIn(name, password);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Assert.assertTrue(loginObject.errorMessage.getText().contains("Invalid Login Credentials"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
}