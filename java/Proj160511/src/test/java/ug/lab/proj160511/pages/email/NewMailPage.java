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
public class NewMailPage {

	@FindBy(id = "send_to")
	private WebElement sendToField;

	@FindBy(id = "subject")
	private WebElement subjectField;

	@FindBy(id = "body")
	private WebElement bodyField;

	@FindBy(id = "send")
	private WebElement sendButton;

	public NewMailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void sendMail(String to, String subject, String body) {
		sendToField.clear();
		sendToField.sendKeys(to);
		subjectField.clear();
		subjectField.sendKeys(subject);
		bodyField.clear();
		bodyField.sendKeys(body);
		sendButton.click();
	}

}
