package com.example.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(id="login_username")
	private WebElement loginField;
	
	@FindBy(id="secretkey")
	private WebElement passwordField;
	
	@FindBy(id="smsubmit")
	private WebElement loginButton;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String login, String password) {
	  loginField.sendKeys(login);
	  passwordField.sendKeys(password);
	  loginButton.click();
	}
	
}
