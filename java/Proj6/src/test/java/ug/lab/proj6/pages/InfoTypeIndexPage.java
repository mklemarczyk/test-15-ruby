/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj6.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author mklem
 */
public class InfoTypeIndexPage {

	@FindBy(linkText = "Create Info Type")
	public WebElement createButton;

	@FindBy(css = "table tr")
	public List<WebElement> tableEntries;

	public InfoTypeIndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void view(String name) {

	}

}
