package ug.lab.proj160511.steps;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ug.lab.proj160511.pages.CalcPage;

public class CalcSteps {

	protected WebDriver driver;

	@BeforeStory
	public void beforeEachScenario() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterStory
	public void afterAnyScenario() {
		driver.quit();
	}

	@When("open calc page")
	public void whenOpenCalcPage() throws InterruptedException {
		driver.get("http://web2.0calc.com/");
	}

	@Given("numbers $x to divide")
	public void givenNumbersxToDivide(@Named("x") List<String> x) throws InterruptedException {
		CalcPage calc = new CalcPage(driver);
		for (int i = 0, c = x.size(); i < c; i++) {
			if (i > 0) {
				calc.divButton.click();
			}
			String number = x.get(i);
			calc.inputField.sendKeys(number);
		}
	}

	@Then("result is $number")
	public void thenBlankNameErrorShown(@Named("number") String number) throws InterruptedException {
		CalcPage calc = new CalcPage(driver);

		calc.equalsButton.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeToBe(calc.inputField, "class", ""));

		assertEquals(number, calc.inputField.getAttribute("value"));
	}

}
