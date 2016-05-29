/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.lab.proj160511.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author mklem
 */
public class CalcPage {

	@FindBy(id = "input")
	public WebElement inputField;

	@FindBy(id = "BtnCalc")
	public WebElement equalsButton;

	@FindBy(id = "BtnPlus")
	public WebElement addButton;

	@FindBy(id = "BtnMinus")
	public WebElement subButton;

	@FindBy(id = "BtnDiv")
	public WebElement divButton;

	@FindBy(id = "BtnMult")
	public WebElement multButton;

	@FindBy(id = "BtnClear")
	public WebElement clearButton;

	@FindBy(id = "Btn0")
	public WebElement num0Button;

	@FindBy(id = "Btn1")
	public WebElement num1Button;

	@FindBy(id = "Btn2")
	public WebElement num2Button;

	@FindBy(id = "Btn3")
	public WebElement num3Button;

	@FindBy(id = "Btn4")
	public WebElement num4Button;

	@FindBy(id = "Btn5")
	public WebElement num5Button;

	@FindBy(id = "Btn6")
	public WebElement num6Button;

	@FindBy(id = "Btn7")
	public WebElement num7Button;

	@FindBy(id = "Btn8")
	public WebElement num8Button;

	@FindBy(id = "Btn9")
	public WebElement num9Button;

	public CalcPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
