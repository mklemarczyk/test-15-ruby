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
public class InfoTypeFormPage {

	@FindBy(id = "infotype-name")
	private WebElement nameField;

	@FindBy(className = "btn-success")
	private WebElement createButton;

	@FindBy(className = "btn-primary")
	private WebElement updateButton;

	@FindBy(css = ".field-infotype-name.has-error .help-block")
	public WebElement nameFieldError;

	public InfoTypeFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void create(String name) {
		nameField.sendKeys(name);
		createButton.click();
	}

	public void update(String name) {
		nameField.clear();
		nameField.sendKeys(name);
		updateButton.click();
	}

}
