/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj6;

import ug.lab.proj6.pages.InfoTypeDetailPage;
import ug.lab.proj6.pages.InfoTypeRow;
import ug.lab.proj6.pages.LoginPage;
import ug.lab.proj6.pages.InfoTypeFormPage;
import ug.lab.proj6.pages.InfoTypeIndexPage;
import ug.lab.proj6.pages.HomePage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author mklem
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InfoTypeTest {

	protected WebDriver driver;

	@Test
	public void tc01_testOpenIndexPage() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);

		assertEquals("No results found.", indexPage.tableEntries.get(1).getText());
	}

	@Test
	public void tc02_testAddItem_Empty() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		indexPage.createButton.click();

		InfoTypeFormPage formPage = new InfoTypeFormPage(driver);
		formPage.create("");

		assertEquals("Name cannot be blank.", formPage.nameFieldError.getText());
	}

	@Test
	public void tc03_testAddItem_Valid() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		indexPage.createButton.click();

		InfoTypeFormPage formPage = new InfoTypeFormPage(driver);
		formPage.create("Procesor speed");

		InfoTypeDetailPage detailPage = new InfoTypeDetailPage(driver);
		assertEquals("Procesor speed", detailPage.headerText.getText());
	}

	@Test
	public void tc04_testUpdateItem_Empty() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		InfoTypeRow row = new InfoTypeRow(indexPage.tableEntries.get(0));
		row.updateButton.click();

		InfoTypeFormPage formPage = new InfoTypeFormPage(driver);
		formPage.update("");

		assertEquals("Name cannot be blank.", formPage.nameFieldError.getText());
	}

	@Test
	public void tc05_testUpdateItem_Valid() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		InfoTypeRow row = new InfoTypeRow(indexPage.tableEntries.get(0));
		row.updateButton.click();

		InfoTypeFormPage formPage = new InfoTypeFormPage(driver);
		formPage.update("Processor speed");

		InfoTypeDetailPage afterDetailPage = new InfoTypeDetailPage(driver);
		assertEquals("Processor speed", afterDetailPage.headerText.getText());
	}

	@Test
	public void tc06_testDeleteItem_Deny() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		InfoTypeRow row = new InfoTypeRow(indexPage.tableEntries.get(1));
		row.deleteButton.click();

		Alert alert = driver.switchTo().alert();
		alert.dismiss();

		InfoTypeIndexPage indexPageAfter = new InfoTypeIndexPage(driver);
		InfoTypeRow rowAfter = new InfoTypeRow(indexPageAfter.tableEntries.get(1));

		assertEquals("Processor speed", rowAfter.nameText.getText());
	}

	@Test
	public void tc07_testDeleteItem_Confirm() {
		driver.get("http://zsm-eq.azurewebsites.net/");

		HomePage homePage = new HomePage(driver);
		homePage.loginButton.click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin", "admin", false);

		HomePage homePageAfter = new HomePage(driver);
		homePageAfter.equipmentButton.click();
		homePageAfter.infoTypesButton.click();

		InfoTypeIndexPage indexPage = new InfoTypeIndexPage(driver);
		InfoTypeRow row = new InfoTypeRow(indexPage.tableEntries.get(0));
		row.deleteButton.click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		InfoTypeIndexPage indexPageAfter = new InfoTypeIndexPage(driver);

		assertEquals("No results found.", indexPageAfter.tableEntries.get(1).getText());
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
