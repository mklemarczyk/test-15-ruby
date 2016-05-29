/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj160511.pages.tmpemail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author mklem
 */
public class MailRow {

	public WebElement fromText;

	public WebElement subjectLink;

	public MailRow(WebElement element) {
		fromText = element.findElement(By.xpath("//td[2]"));
		subjectLink = element.findElement(By.xpath("//td[3]/a"));
	}

}
