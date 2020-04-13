package testngFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestBase {
	public WebDriver driver = null;
@Test
public void Login() throws IOException{
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\Enthuons-Testing\\workspace\\Testng_ude\\src\\testngFiles\\datadriven.properties");
	prop.load(fis);
	//System.out.println(prop.getProperty("username"));
	if (prop.getProperty("browser").contains("chrome")) {
		System.setProperty("webdriver.chrome.driver","./exe/chromedriver.exe" );
		driver = new ChromeDriver();
	}
	else if (prop.getProperty("browser").contains("firefox")) {
		System.setProperty("webdriver.gecko.driver","./exe/geckodriver.exe" );
		driver = new FirefoxDriver();
	}
	else{
		driver = new InternetExplorerDriver();
	}
	driver.get(prop.getProperty("url"));
	
}
@Test
public void software(){
	System.out.println("I am the test");
}
@AfterTest
public void deinstallsoftware(){
	System.out.println("I am the last");
	System.out.println("New edits");
}
}
