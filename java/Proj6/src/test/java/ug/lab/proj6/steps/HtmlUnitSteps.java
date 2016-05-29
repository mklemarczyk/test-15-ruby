package ug.lab.proj6.steps;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class HtmlUnitSteps extends MySteps {

	@BeforeScenario
	@Override
	public void beforeEachScenario() {
		variables = new Hashtable<>();

		//File file = new File("E:/Data/PortableApps/PhantomjsPortable/bin/phantomjs.exe");
		//System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		//driver = new PhantomJSDriver();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver = new HtmlUnitDriver(true);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterScenario
	@Override
	public void afterAnyScenario() {
		variables = null;
		//System.clearProperty("phantomjs.binary.path");
		driver.quit();
	}

}
