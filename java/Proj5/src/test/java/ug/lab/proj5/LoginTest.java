/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj5;

import java.io.File;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ug.lab.proj5.pages.HomePage;

/**
 *
 * @author mklem
 */
public class LoginTest {

	private WebDriver driver;
	WebElement element;

	@Test
	public void testOpenHomePage() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);

		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
	}

	@Test
	public void testWithTryLoginEmpty() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);

		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
	}

	@Test
	public void testWithTryLoginWithWrongPassword() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);

		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
	}

	@Test
	public void testWithCorrectPassword() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);

		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
	}

	@Before
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		File file = new File("../libs/operadriver_64.exe");
		System.setProperty("webdriver.opera.driver", file.getAbsolutePath());

		OperaOptions options = new OperaOptions();
		options.setBinary("E:/Data/PortableApps/OperaPortable/App/Opera/36.0.2130.32/Opera.exe");
		//options.setBinary("E:/Data/PortableApps/OperaPortable/OperaPortable.exe");

		driver = new OperaDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@After
	public void cleanp() {
		driver.close();
		driver.quit();
	}

}
