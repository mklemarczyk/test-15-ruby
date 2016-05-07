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
public class HomePage {

	@FindBy(linkText = "Home")
	public WebElement homeButton;

	@FindBy(linkText = "Login")
	public WebElement loginButton;

	@FindBy(linkText = "About")
	public WebElement aboutButton;

	@FindBy(linkText = "Logout (admin)")
	public WebElement logoutButton;

	@FindBy(linkText = "Equipment")
	public WebElement equipmentButton;

	@FindBy(linkText = "Containers")
	public WebElement containersButton;

	@FindBy(linkText = "Container types")
	public WebElement containerTypesButton;

	@FindBy(linkText = "Devices")
	public WebElement devicesButton;

	@FindBy(linkText = "Device infos")
	public WebElement deviceInfosButton;

	@FindBy(linkText = "Device types")
	public WebElement deviceTypesButton;

	@FindBy(linkText = "Info types")
	public WebElement infoTypesButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
