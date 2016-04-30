package com.example.seleniumdemo;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Project4 {

	private static WebDriver driver;
	WebElement element;

	@Before
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testOpenPoll_IsValid() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		assertEquals("Testujemy Biovaxy - ankieta dla uczestników akcji", driver.getTitle());
		assertNotNull(ankieta.additional_info);
		assertNotNull(ankieta.efekt_wygladzenia);
		assertNotNull(ankieta.efekt_zwiekszony_blask);
		assertNotNull(ankieta.maska_1);
		assertNotNull(ankieta.maska_2);
		assertNotNull(ankieta.maska_3);
		assertNotNull(ankieta.maska_4);
		assertNotNull(ankieta.nick);
		assertNotNull(ankieta.porpwatosc_niska);
		assertNotNull(ankieta.porpwatosc_srednia);
		assertNotNull(ankieta.porpwatosc_wysoka);
		assertNotNull(ankieta.sendButton);
		assertNotNull(ankieta.sprawdzilo_czesciowo);
		assertNotNull(ankieta.sprawdzilo_nie);
		assertNotNull(ankieta.sprawdzilo_tak);
		assertNotNull(ankieta.wlosy_falowane);
		assertNotNull(ankieta.wlosy_proste);
		assertNotNull(ankieta.wlosy_krecone);
		assertNotNull(ankieta.wlosyg_cienkie);
		assertNotNull(ankieta.wlosyg_grube);
		assertNotNull(ankieta.wlosyg_srednie);
	}

	@Test
	public void testSendValidPoll() {
		String parentWindow;
		String childWindow;
		driver.get("https://inf.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Poczta")).click();

		Set<String> windows = driver.getWindowHandles();
		windows.remove(parentWindow);
		childWindow = windows.iterator().next();
		driver.switchTo().window(childWindow);

		Login login = new Login(driver);
		login.login("", "");
		assertEquals("BŁĄD:\nBŁĄD: Połączenie pominięte przez serwer IMAP.\nQuery: LOGOUT", driver.findElement(By.tagName("body")).getText());
	}

	@Test
	public void testWithTryLoginWithWrongPassword() {
		String parentWindow;
		String childWindow;
		driver.get("https://inf.ug.edu.pl/");
		parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Poczta")).click();

		Set<String> windows = driver.getWindowHandles();
		windows.remove(parentWindow);

		assertEquals(1, windows.size());

		childWindow = windows.iterator().next();
		driver.switchTo().window(childWindow);

		Login login = new Login(driver);
		login.login("mkleamrczyk", "qwertyuiop");
		assertEquals("BŁĄD:\nBŁĄD: Połączenie pominięte przez serwer IMAP.\nQuery: LOGOUT", driver.findElement(By.tagName("body")).getText());
	}

	@After
	public void cleanp() {
		driver.quit();
	}
}
