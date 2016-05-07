/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj5;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj5.pages.HomePage;

/**
 *
 * @author mklem
 */
public class DeviceTypeTest {

	protected WebDriver driver;

	@Test
	public void testOpenHomePage() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);

		assertNotNull(homePage.homeButton);
		assertNotNull(homePage.loginButton);
		assertNotNull(homePage.aboutButton);
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void cleanp() {
		driver.quit();
	}

}
