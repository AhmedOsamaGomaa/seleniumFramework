package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//Method to take screenshot when the test case fails 
	public static void captureScreenshot(WebDriver driver, String screenshotname){

		Path destination = Paths.get("./Screenshots",screenshotname+".png"); 
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream output = new FileOutputStream(destination.toString());
			output.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			output.close();

		} catch (IOException e){
			System.out.println("Exception while taking screenshot" + e.getMessage());
		}
	} 
}