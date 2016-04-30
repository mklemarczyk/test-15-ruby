package com.example.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ankieta {

	@FindBy(id="group_2034949255_1")
	public WebElement maska_1;
	
	@FindBy(id="group_2034949255_2")
	public WebElement maska_2;
	
	@FindBy(id="group_2034949255_3")
	public WebElement maska_3;
	
	@FindBy(id="group_2034949255_4")
	public WebElement maska_4;
	
	@FindBy(id="entry_575490584")
	public WebElement nick;
	
	@FindBy(id="group_861106498_1")
	public WebElement sprawdzilo_tak;

	@FindBy(id="group_861106498_2")
	public WebElement sprawdzilo_nie;
	
	@FindBy(id="group_861106498_3")
	public WebElement sprawdzilo_czesciowo;

	@FindBy(id="group_1445990544_1")
	public WebElement efekt_zwiekszony_blask;
	
	@FindBy(id="group_1445990544_2")
	public WebElement efekt_wygladzenia;
	
	@FindBy(id="group_857233705_1")
	public WebElement wlosy_proste;
	
	@FindBy(id="group_857233705_2")
	public WebElement wlosy_falowane;
	
	@FindBy(id="group_857233705_3")
	public WebElement wlosy_krecone;
	
	@FindBy(id="group_34589461_1")
	public WebElement porpwatosc_niska;
	
	@FindBy(id="group_34589461_2")
	public WebElement porpwatosc_srednia;
	
	@FindBy(id="group_34589461_3")
	public WebElement porpwatosc_wysoka;
	
	@FindBy(id="group_587933030_1")
	public WebElement wlosyg_cienkie;
	
	@FindBy(id="group_587933030_2")
	public WebElement wlosyg_grube;
	
	@FindBy(id="group_587933030_3")
	public WebElement wlosyg_srednie;
	
	@FindBy(id="entry_931872272")
	public WebElement additional_info;
	
	@FindBy(id="ss-submit")
	public WebElement sendButton;
	
	@FindBy(className="ss-bottom-link")
	public WebElement repeatButton;
	
	@FindBy(className="ss-resp-message")
	public WebElement responseMessage;
	
	public Ankieta(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}
	
}
