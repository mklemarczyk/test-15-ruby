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
public class InfoTypeDetailPage {

	@FindBy(linkText = "Update")
	public WebElement updateButton;

	@FindBy(linkText = "Delete")
	public WebElement deleteButton;

	@FindBy(css = ".info-type-view h1")
	public WebElement headerText;

	public InfoTypeDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
