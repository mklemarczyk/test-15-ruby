package ug.lab.proj6.steps;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj6.pages.HomePage;
import ug.lab.proj6.pages.LoginPage;

public class MySteps {

	protected WebDriver driver;

	protected Dictionary<String, String> variables;

	@BeforeScenario
	public void beforeEachScenario() {
		variables = new Hashtable<>();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterScenario
	public void afterAnyScenario() {
		driver.quit();
	}

	@When("open home page")
	public void whenOpenHomePage() {
		driver.get("http://zsm-eq.azurewebsites.net");
	}

	@Then("home page is shown")
	public void thenHomePageIsShown() {
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Manadżer sprzętu"));
	}

	@When("open login page")
	public void whenOpenLoginPage() {
		driver.get("http://zsm-eq.azurewebsites.net/index.php?r=site%2Flogin");
	}

	@Then("login page is shown")
	public void thenLoginPageIsShown() {
		LoginPage loginPage = new LoginPage(driver);

		assertNotNull(loginPage.loginField);
		assertNotNull(loginPage.passwordField);
		assertNotNull(loginPage.rememberCheckbox);
		assertNotNull(loginPage.loginButton);
	}

	@When("$name is empty")
	public void whenNameIsEmpty(@Named("name") String name) {
		variables.put(name, "");
	}

	@When("login button pressed")
	public void whenLoginButtonPressed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(variables.get("username"),
				variables.get("password"),
				false
		);

	}

	@Then("blank $name error shown")
	public void thenBlankNameErrorShown(@Named("name") String name) {
		LoginPage loginPage = new LoginPage(driver);
		if ("username".equals(name)) {
			assertEquals("Username cannot be blank.", loginPage.loginFieldError.getText());
		} else if ("password".equals(name)) {
			assertEquals("Password cannot be blank.", loginPage.passwordFieldError.getText());
		}
	}

	@When("$name is given $value")
	public void whenNameIsGivenValue(@Named("name") String name, @Named("value") String value) {
		variables.put(name, value);
	}

	@Then("invalid username or password error shown")
	public void thenInvalidUsernameOrPasswordErrorShown() {
		LoginPage loginPageAfter = new LoginPage(driver);
		assertEquals("Incorrect username or password.", loginPageAfter.passwordFieldError.getText());
	}

	@Then("user is logged")
	public void thenUserIsLogged() {
		HomePage homePage = new HomePage(driver);
		assertNotNull(homePage.logoutButton);
	}
}
