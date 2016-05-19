package ug.lab.proj6.steps;

import java.io.File;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ug.lab.proj6.pages.HomePage;
import ug.lab.proj6.pages.LoginPage;

public class OperaStepsPl {

	protected WebDriver driver;

	protected Dictionary<String, String> variables;

	@BeforeScenario
	public void beforeEachScenario() {
		variables = new Hashtable<>();

		File file = new File("../libs/operadriver_64.exe");
		System.setProperty("webdriver.opera.driver", file.getAbsolutePath());

		OperaOptions options = new OperaOptions();
		options.setBinary("E:/Data/PortableApps/OperaPortable/App/Opera/36.0.2130.32/Opera.exe");
		//options.setBinary("E:/Data/PortableApps/OperaPortable/OperaPortable.exe");

		driver = new OperaDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterScenario
	public void afterAnyScenario() {
		variables = null;
		driver.quit();
	}

	@When("otwarto stronę główną")
	public void whenOpenHomePage() {
		driver.get("http://zsm-eq.azurewebsites.net");
	}

	@Then("strona główna jest wyświetlona")
	public void thenHomePageIsShown() {
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Manadżer sprzętu"));
	}

	@When("otwarto stronę logowania")
	public void whenOpenLoginPage() {
		driver.get("http://zsm-eq.azurewebsites.net/index.php?r=site%2Flogin");
	}

	@When("$name jest pusty")
	public void whenNameIsEmpty(@Named("name") String name) {
		variables.put(name, "");
	}

	@When("naciśnięto przycisk login")
	public void whenLoginButtonPressed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(variables.get("username"),
				variables.get("password"),
				false
		);

	}

	@Then("komunikat pusty $name wyświetlono")
	public void thenBlankNameErrorShown(@Named("name") String name) {
		LoginPage loginPage = new LoginPage(driver);
		if ("username".equals(name)) {
			assertEquals("Username cannot be blank.", loginPage.loginFieldError.getText());
		} else if ("password".equals(name)) {
			assertEquals("Password cannot be blank.", loginPage.passwordFieldError.getText());
		}
	}

	@When("$name podano jako $value")
	public void whenNameIsGivenValue(@Named("name") String name, @Named("value") String value) {
		variables.put(name, value);
	}

	@Then("komunikat niepoprawne username lub password wyświetlono")
	public void thenInvalidUsernameOrPasswordErrorShown() {
		LoginPage loginPageAfter = new LoginPage(driver);
		assertEquals("Incorrect username or password.", loginPageAfter.passwordFieldError.getText());
	}

	@Then("użytkownika zalogowano")
	public void thenUserIsLogged() {
		HomePage homePage = new HomePage(driver);
		assertNotNull(homePage.logoutButton);
	}

}
