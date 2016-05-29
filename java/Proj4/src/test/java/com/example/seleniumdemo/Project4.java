package com.example.seleniumdemo;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Project4 {

	private static WebDriver driver;
	WebElement element;

	@Before
	public void driverSetup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		Ankieta wyslana = new Ankieta(driver);

		assertNotNull(wyslana.repeatButton);
		assertNotNull(wyslana.responseMessage);
		assertEquals("Twoja odpowiedź została zapisana.", wyslana.responseMessage.getText());
	}

	@Test
	public void testSendPoll_WithoutMaska() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutNick() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		driver.findElement(By.tagName("body")).click();
		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutSprawdzilo() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutEfekt() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		Ankieta wyslana = new Ankieta(driver);

		assertNotNull(wyslana.repeatButton);
		assertNotNull(wyslana.responseMessage);
		assertEquals("Twoja odpowiedź została zapisana.", wyslana.responseMessage.getText());
	}

	@Test
	public void testSendPoll_WithoutTypWlosow() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutPoprawnosc() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.wlosyg_srednie.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutWlosyGrubosc() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.additional_info.sendKeys("Nic nowego");

		ankieta.sendButton.click();

		assertTrue(driver.findElement(By.tagName("body")).getText().contains("Odpowiedź na to pytanie jest wymagana"));
	}

	@Test
	public void testSendPoll_WithoutAdditionalInfoMaska() {
		driver.get("https://docs.google.com/forms/d/1Uf2LJbpk3kxNaWWWuqsGwY3PRO1XBatlm6Vjx5wi72k/viewform");

		Ankieta ankieta = new Ankieta(driver);

		ankieta.maska_1.click();
		ankieta.nick.sendKeys("Test");
		ankieta.sprawdzilo_tak.click();
		ankieta.efekt_wygladzenia.click();
		ankieta.wlosy_krecone.click();
		ankieta.porpwatosc_srednia.click();
		ankieta.wlosyg_srednie.click();

		ankieta.sendButton.click();

		Ankieta wyslana = new Ankieta(driver);

		assertNotNull(wyslana.repeatButton);
		assertNotNull(wyslana.responseMessage);
		assertEquals("Twoja odpowiedź została zapisana.", wyslana.responseMessage.getText());
	}

	@After
	public void cleanp() {
		driver.quit();
	}
}
