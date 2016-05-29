/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author mklem
 */
public class LoginPage {

	@FindBy(id = "loginform-username")
	private WebElement loginField;

	@FindBy(id = "loginform-password")
	private WebElement passwordField;

	@FindBy(id = "loginform-rememberme")
	private WebElement rememberCheckbox;

	@FindBy(className = "btn-primary")
	private WebElement loginButton;

	@FindBy(css = ".field-loginform-username.has-error .help-block")
	public WebElement loginFieldError;

	@FindBy(css = ".field-loginform-password.has-error .help-block")
	public WebElement passwordFieldError;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login(String login, String password, Boolean remember) {
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		if (rememberCheckbox.isSelected() != remember) {
			rememberCheckbox.click();
		}
		loginButton.click();
	}

}
