package ug.lab.proj160511.steps;

import static java.lang.Thread.sleep;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj160511.pages.email.*;
import ug.lab.proj160511.pages.tmpemail.*;

/**
 *
 * @author mklem
 */
public class EmailSteps {

	protected WebDriver driverOne;
	protected WebDriver driverTwo;

	protected Dictionary<String, String> variables;

	@BeforeStory
	public void beforeEachScenario() {
		variables = new Hashtable<>();
		driverOne = new FirefoxDriver();
		driverOne.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driverTwo = new FirefoxDriver();
		driverTwo.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterStory
	public void afterAnyScenario() {
		driverOne.quit();
		driverTwo.quit();
	}

	@When("open login page")
	public void whenOpenLoginPage() {
		driverOne.get("https://inf.ug.edu.pl/sq/src/login.php");
	}

	@Then("login page is shown")
	public void thenLoginPageIsShown() {
		assertEquals("Poczta inf.ug.edu.pl - Logowanie", driverOne.getTitle());
	}

	@When("open temp mail page")
	public void whenOpenTempMailPage() {
		if (variables.get("tmpPage") != null) {
			driverTwo.get(variables.get("tmpPage"));
		} else {
			driverTwo.get("http://10minutemail.com/10MinuteMail/index.html");
		}
		HomePage homePage = new HomePage(driverTwo);
		variables.put("tmpPage", driverTwo.getCurrentUrl());
		variables.put("to", homePage.addressField.getAttribute("value"));
	}

	@Then("$n {messages|message} {are|is} present")
	public void thenMessagesArePresent(@Named("n") int n) throws InterruptedException {
		HomePage homePage = new HomePage(driverTwo);
		int i = 10;
		while (i > 0 && homePage.emails.size() != n + 1) {
			sleep(10 * 1000);
		}
		assertEquals(n + 1, homePage.emails.size());
	}

	@When("login button pressed")
	public void whenLoginButtonPressed() {
		LoginPage loginPage = new LoginPage(driverOne);
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
		IndexPage indexPage = new IndexPage(driverOne);
		assertNotNull(indexPage.logoutButton);
	}

	@When("open new mail page")
	public void whenOpenNewMailPage() {
		driverOne.get("https://inf.ug.edu.pl/sq/src/compose.php?mailbox=INBOX&startMessage=1");
	}

	@When("send button pressed")
	public void whenSendButtonPressed() {
		NewMailPage newMailPage = new NewMailPage(driverOne);
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
		assertFalse(driverOne.getCurrentUrl().contains("https://inf.ug.edu.pl/sq/src/compose.php"));
	}

	@Then("email subject is $subject")
	public void thenEmailSubjectIs(@Named("subject") String subject) {
		HomePage homePage = new HomePage(driverTwo);
		List<WebElement> list = homePage.emails;
		WebElement element = list.get(0);
		MailRow row = new MailRow(element);
		assertEquals(subject, row.subjectLink.getText());

		row.subjectLink.click();
	}

	@Then("email body contains $body")
	public void thenEmailBodyContains(@Named("body") String body) {
		MailPage mailPage = new MailPage(driverTwo);
		assertEquals(body, mailPage.bodyText.getText());
	}
}
