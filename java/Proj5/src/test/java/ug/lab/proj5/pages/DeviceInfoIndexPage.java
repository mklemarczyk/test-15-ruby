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
public class DeviceInfoIndexPage {

	@FindBy(linkText = "Create Device Info")
	public WebElement createButton;

	public DeviceInfoIndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void edit(String name) {

	}

	public void delete(String name) {

	}

}
