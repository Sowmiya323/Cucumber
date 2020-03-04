package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotel extends BaseClass {
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='radio']")
	private WebElement select;
	@FindBy(id="continue")
	private WebElement cnte;
	public WebElement getSelect() {
		return select;
	}
	public WebElement getCnte() {
		return cnte;
	}
	
}
