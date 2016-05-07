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
import ug.lab.proj5.pages.LoginPage;

/**
 *
 * @author mklem
 */
public class LoginTest {

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
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("", "", false);

		LoginPage loginPageAfter = new LoginPage(driver);
		assertEquals("Username cannot be blank.", loginPageAfter.loginFieldError.getText());
		assertEquals("Password cannot be blank.", loginPageAfter.passwordFieldError.getText());
	}

	@Test
	public void testWithTryLoginWithWrongPassword() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "qwertyui", false);

		LoginPage loginPageAfter = new LoginPage(driver);
		assertEquals("Incorrect username or password.", loginPageAfter.passwordFieldError.getText());
	}

	@Test
	public void testWithCorrectPassword() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		assertNotNull(homePageAfter.logoutButton);
	}

	@Before
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@After
	public void cleanp() {
		driver.quit();
	}

}
