package ug.lab.proj160511.steps;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj160511.pages.HomePage;
import ug.lab.proj160511.pages.LoginPage;

public class LoginSteps {

	protected WebDriver driver;

	protected Dictionary<String, String> credentials;

	@BeforeScenario
	public void beforeEachScenario() {
		credentials = new Hashtable<>();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterScenario
	public void afterAnyScenario() {
		driver.quit();
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
		credentials.put(name, "");
	}

	@When("login button pressed")
	public void whenLoginButtonPressed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(
				credentials.get("username"),
				credentials.get("password"),
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
		credentials.put(name, value);
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
