/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj5.opera;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import ug.lab.proj5.InfoTypeTest;

/**
 *
 * @author mklem
 */
public class OperaInfoTypeTest extends InfoTypeTest {

	@Before
	@Override
	public void driverSetup() {
		File file = new File("../libs/operadriver_64.exe");
		System.setProperty("webdriver.opera.driver", file.getAbsolutePath());

		OperaOptions options = new OperaOptions();
		options.setBinary("E:/Data/PortableApps/OperaPortable/App/Opera/36.0.2130.32/Opera.exe");
		//options.setBinary("E:/Data/PortableApps/OperaPortable/OperaPortable.exe");

		driver = new OperaDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
