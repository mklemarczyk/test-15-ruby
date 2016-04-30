package com.example.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(name="text1")
	private WebElement emailField;
	
	@FindBy(name="text2")
	private WebElement passwordField;
	
	@FindBy(name="button1")
	private WebElement loginButton;
	
	public Login(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
	  emailField.sendKeys(email);
	  passwordField.sendKeys(password);
	  loginButton.click();
	}
	
}
