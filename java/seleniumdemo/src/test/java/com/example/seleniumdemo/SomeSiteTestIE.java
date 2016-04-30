package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class SomeSiteTestIE {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		File file = new File("D:/Selen/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void homePage() throws InterruptedException{
		driver.get("http://www.yahoo.com/");
		element = driver.findElement(By.id("uh-search-button"));
		assertNotNull(element);
	}
	
	@Test
	public void czySaPiersiPage() throws InterruptedException{
		driver.get("http://www.yahoo.com/");
		element = driver.findElement(By.id("uh-search-box"));
		element.sendKeys("piersi site:mf.gov.pl");
		driver.findElement(By.id("uh-search-button")).click();
		
		element = driver.findElement(By.id("web"));
		
		assertNotNull(element);
		assertTrue(element.getText().contains("We did not find results for") == false);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/tu_sa_piersi.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void czySaCyckiPage() throws InterruptedException{
		driver.get("http://www.yahoo.com/");
		element = driver.findElement(By.id("uh-search-box"));
		element.sendKeys("cycki site:mf.gov.pl");
		driver.findElement(By.id("uh-search-button")).click();
		
		element = driver.findElement(By.id("web"));
		
		assertNotNull(element);
		assertTrue(element.getText().contains("We did not find results for"));
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/nie_ma_cyckow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@Test
	public void getFilePage() throws InterruptedException{
		driver.get("https://www.nuget.org/packages/WebDriver.IEDriverServer.win32");
		element = driver.findElement(By.linkText("Download"));
		element.click();

		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("test/resources/nie_ma_cyckow.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertTrue(true);
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
