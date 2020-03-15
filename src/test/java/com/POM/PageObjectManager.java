package com.POM;

import com.pages.BookHotel;
import com.pages.ConfirmBooking;
import com.pages.Login;
import com.pages.Search;
import com.pages.SelectHotel;

public class PageObjectManager {
	private Login loginPage;
	private Search search;
	private SelectHotel select;
	private BookHotel bookHotel;
	private ConfirmBooking confirmBooking;
	public Login getLoginPage() {
		return (loginPage==null)?loginPage=new Login():loginPage;
	}
	public Search getSearch() {
		return (search==null)?search=new Search():search;
	}
	public SelectHotel getSelect() {
		return (select==null)?select=new SelectHotel():select;
	}
	public BookHotel getBookHotel() {
		return (bookHotel==null)?bookHotel=new BookHotel():bookHotel;
	}
	public ConfirmBooking getConfirmBooking() {
		return (confirmBooking==null)?confirmBooking=new ConfirmBooking():confirmBooking;
	}
	

}
