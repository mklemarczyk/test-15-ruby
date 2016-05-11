package ug.lab.proj160511.steps;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ug.lab.proj160511.pages.CalcPage;

public class CalcSteps {

	protected WebDriver driver;

	@BeforeScenario
	public void beforeEachScenario() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterScenario
	public void afterAnyScenario() {
		driver.quit();
	}

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@When("open calc page")
	public void whenOpenCalcPage() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://web2.0calc.com/");

		CalcPage calc = new CalcPage(driver);
		//calc.num2Button.click();
		//calc.addButton.click();
		//calc.num5Button.click();
		//calc.equalsButton.click();
		// sleep(5000);
		calc.inputField.sendKeys("2+5");
		calc.equalsButton.click();

		sleep(5000);

		String tt = calc.inputField.getAttribute("value");
		assertEquals("1", calc.inputField.getAttribute("value"));

		driver.quit();
	}

	@When("numbers $x to insert")
	public void whenNameIsEmpty(@Named("x") List<Integer> x) throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		CalcPage calc = new CalcPage(driver);
		calc.num2Button.click();
		calc.addButton.click();
		calc.num5Button.click();
		calc.equalsButton.click();
		sleep(1000);
		assertEquals("1", calc.inputField.getText());
	}

	@Then("result is $number")
	public void thenBlankNameErrorShown(@Named("name") String name) {

	}

}
