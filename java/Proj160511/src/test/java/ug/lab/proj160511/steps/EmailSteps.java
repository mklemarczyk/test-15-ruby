package ug.lab.proj160511.steps;

import static java.lang.Thread.sleep;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj160511.pages.email.*;
import ug.lab.proj160511.pages.tmpemail.HomePage;
import ug.lab.proj160511.pages.tmpemail.MailPage;

/**
 *
 * @author mklem
 */
public class EmailSteps {

	protected WebDriver driver;

	protected Dictionary<String, String> variables;

	@BeforeStory
	public void beforeEachScenario() {
		variables = new Hashtable<>();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterStory
	public void afterAnyScenario() {
		driver.quit();
	}

	@When("open login page")
	public void whenOpenLoginPage() {
		driver.get("https://inf.ug.edu.pl/sq/src/login.php");
	}

	@Then("login page is shown")
	public void thenLoginPageIsShown() {
		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
	}

	@When("open temp mail page")
	public void whenOpenTempMailPage() {
		if (variables.get("tmpPage") != null) {
			driver.get(variables.get("tmpPage"));
		} else {
			driver.get("http://10minutemail.com/10MinuteMail/index.html");
		}
		HomePage homePage = new HomePage(driver);
		variables.put("tmpPage", driver.getCurrentUrl());
		variables.put("to", homePage.addressField.getAttribute("value"));
	}

	@Then("$n {messages|message} {are|is} present")
	public void thenMessagesArePresent(@Named("n") int n) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		if (homePage.emails.size() != n + 1) {
			sleep(100000);
		}
		assertEquals(n + 1, homePage.emails.size());

	}

	@When("login button pressed")
	public void whenLoginButtonPressed() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(variables.get("username"),
				variables.get("password")
		);
		variables.remove("username");
		variables.remove("password");
	}

	@When("$name is given $value")
	public void whenNameIsGivenValue(@Named("name") String name, @Named("value") String value) {
		variables.put(name, value);
	}

	@Then("user is logged")
	public void thenUserIsLogged() {
		IndexPage indexPage = new IndexPage(driver);
		assertNotNull(indexPage.logoutButton);
	}

	@When("open new mail page")
	public void whenOpenNewMailPage() {
		driver.get("https://inf.ug.edu.pl/sq/src/compose.php?mailbox=INBOX&startMessage=1");
	}

	@When("send button pressed")
	public void whenSendButtonPressed() {
		NewMailPage newMailPage = new NewMailPage(driver);
		newMailPage.sendMail(
				variables.get("to"),
				variables.get("subject"),
				variables.get("body")
		);
		variables.remove("to");
		variables.remove("subject");
		variables.remove("body");
	}

	@Then("email is send")
	public void thenEmailIsSend() {
		assertFalse(driver.getCurrentUrl().contains("https://inf.ug.edu.pl/sq/src/compose.php"));
	}

	@Then("email subject is $subject")
	public void thenEmailSubjectIs(@Named("subject") String subject) {
		MailPage mailPage = new MailPage(driver);
		assertTrue(false);
	}

	@Then("email body contains $body")
	public void thenEmailBodyContains(@Named("body") String body) {
		MailPage mailPage = new MailPage(driver);
		assertTrue(false);
	}
}
