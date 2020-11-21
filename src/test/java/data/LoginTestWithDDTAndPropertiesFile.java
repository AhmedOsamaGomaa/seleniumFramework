package data;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;

public class LoginTestWithDDTAndPropertiesFile extends TestBase {

	LoginPage loginObject;
	String email = LoadProperties.userData.getProperty("email");
	String password = LoadProperties.userData.getProperty("password");

	@Test
	public void userLoginSuccessfully() throws InterruptedException{
		loginObject = new LoginPage(driver);
		loginObject.userLogIn(email, password);
		Thread.sleep(3000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://138.68.58.187/dashboard/students");
	}

}