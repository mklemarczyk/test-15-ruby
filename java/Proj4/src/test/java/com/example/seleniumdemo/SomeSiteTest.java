package com.example.seleniumdemo;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SomeSiteTest {

    private static WebDriver driver;
    WebElement element;

    @Before
    public void driverSetup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testWithGetToWindow() {
        String parentWindow;
        String childWindow;
        driver.get("https://inf.ug.edu.pl/");
        parentWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Poczta")).click();

        Set<String> windows = driver.getWindowHandles();
        windows.remove(parentWindow);
        childWindow = windows.iterator().next();

        driver.switchTo().window(parentWindow);
        driver.close();
        driver.switchTo().window(childWindow);

        assertEquals("Poczta inf.ug.edu.pl - Logowanie", driver.getTitle());
    }

    @Test
    public void testWithTryLoginEmpty() {
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
