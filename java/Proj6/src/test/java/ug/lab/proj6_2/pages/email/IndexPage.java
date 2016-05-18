/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj160511.pages.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author mklem
 */
public class IndexPage {

	@FindBy(linkText = "Kliknij tutaj, aby się wylogować")
	public WebElement logoutButton;

	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
