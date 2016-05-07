/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author mklem
 */
public class InfoTypeRow {

	public WebElement viewButton;

	public WebElement updateButton;

	public WebElement deleteButton;

	public InfoTypeRow(WebElement element) {
		viewButton = element.findElement(By.xpath("//a[@title='View']"));
		updateButton = element.findElement(By.xpath("//a[@title='Update']"));
		deleteButton = element.findElement(By.xpath("//a[@title='Delete']"));
	}

}
