package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class Search extends BaseClass {
	public Search() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//select[@class='search_combobox'])[1]")
	private WebElement location;
	@FindBy(id = "hotels")
	private WebElement hotel;
	@FindBy(xpath = "(//select[@class='search_combobox'])[3]")
	private WebElement roomType;
	@FindBy(id = "room_nos")
	private WebElement noRoom;
	@FindBy(id = "datepick_in")
	private WebElement dateIn;
	@FindBy(id="datepick_out")
	private WebElement dateOut;
	@FindBy(name="adult_room")
	private WebElement adultRoom;
	@FindBy(id="Submit")
	private WebElement btnSearch;
	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNoRoom() {
		return noRoom;
	}
	public WebElement getDateIn() {
		return dateIn;
	}
	public WebElement getDateOut() {
		return dateOut;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getBtnSearch() {
		return btnSearch;
	}

}
