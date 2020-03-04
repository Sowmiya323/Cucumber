package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotel extends BaseClass {
	public BookHotel() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="first_name")
	private WebElement fName;
	@FindBy(name="last_name")
	private WebElement lName;
	@FindBy(id="address")
	private WebElement address;
	@FindBy(id="cc_num")
	private WebElement creditNo;
	@FindBy(id="cc_type")
	private WebElement creditType;
	@FindBy(id="cc_exp_month")
	private WebElement expMonth;
	@FindBy(id="cc_exp_year")
	private WebElement expYear;
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	@FindBy(id="book_now")
	private WebElement btnBooknow;
	public WebElement getfName() {
		return fName;
	}
	public WebElement getlName() {
		return lName;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getCreditNo() {
		return creditNo;
	}
	public WebElement getCreditType() {
		return creditType;
	}
	public WebElement getExpMonth() {
		return expMonth;
	}
	public WebElement getExpYear() {
		return expYear;
	}
	public WebElement getCvv() {
		return cvv;
	}
	public WebElement getBtnBooknow() {
		return btnBooknow;
	}

}
