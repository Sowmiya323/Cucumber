package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ConfirmBooking extends BaseClass {
	public ConfirmBooking() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="my_itinerary")
	private WebElement btnItinerary;
	@FindBy(name="cancelall")
	private WebElement cancel;
	public WebElement getBtnItinerary() {
		return btnItinerary;
	}
	public WebElement getCancel() {
		return cancel;
	}
	
}
