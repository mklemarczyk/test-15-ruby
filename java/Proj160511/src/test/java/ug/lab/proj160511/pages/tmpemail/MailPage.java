/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj160511.pages.tmpemail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author mklem
 */
public class MailPage {

	public MailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
