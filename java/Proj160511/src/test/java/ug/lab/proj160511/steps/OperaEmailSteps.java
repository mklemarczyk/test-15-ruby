package ug.lab.proj160511.steps;

import java.io.File;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 *
 * @author mklem
 */
public class OperaEmailSteps extends EmailSteps {

	@BeforeScenario
	@Override
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

}
