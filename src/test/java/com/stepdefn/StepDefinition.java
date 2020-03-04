package com.stepdefn;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseClass;
import com.pages.BookHotel;
import com.pages.ConfirmBooking;
import com.pages.Login;
import com.pages.Search;
import com.pages.SelectHotel;

import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass {
	Login l;
	Search s;
	BookHotel bh;
	SelectHotel sh;
	ConfirmBooking cb;
	@Given("User is on adactin page")
	public void user_is_on_adactin_page() {
		driver = getDriver();
		loadUrl("https://adactin.com/HotelApp/");
	}

	@When("User enter username and password")
	public void user_enter_username_and_password(io.cucumber.datatable.DataTable dataTable) {
		l=new Login();
		List<Map<String, String>> li = dataTable.asMaps();
		txtUser(l.getTxtUserName(), li.get(0).get("userName"));
		txtUser(l.getTxtPassword(), li.get(0).get("password"));
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		click(l.getBtnLogin());
	}

	@When("User shuold enter all the details for search hotel")
	public void user_shuold_enter_all_the_details_for_search_hotel(io.cucumber.datatable.DataTable dataTable) {
		s=new Search();
		List<Map<String, String>> li = dataTable.asMaps();
		selectByVisibleText(s.getLocation(), li.get(1).get("location"));
		selectByVisibleText(s.getHotel(),  li.get(3).get("hotels"));
		selectByVisibleText(s.getRoomType(),  li.get(2).get("roomType"));
		selectByVisibleText(s.getNoRoom(),  li.get(1).get("noOfRooms"));
		txtUser(s.getDateIn(),  li.get(0).get("checkInDate"));
		txtUser(s.getDateOut(),  li.get(0).get("checkOutDate"));
		selectByVisibleText(s.getAdultRoom(),  li.get(2).get("adultsPerRoom"));
		click(s.getBtnSearch());
	}

	@When("User should select any one of the available hotel")
	public void user_should_select_any_one_of_the_available_hotel() {
		sh=new SelectHotel();
		click(sh.getSelect());
		click(sh.getCnte());
	}

	@When("User should enter First name, Last name, Address and Payment details")
	public void user_should_enter_First_name_Last_name_Address_and_Payment_details(io.cucumber.datatable.DataTable dataTable) {
		bh=new BookHotel();
		List<Map<String, String>> li = dataTable.asMaps();
		txtUser(bh.getfName(), "Sowmiya");
		txtUser(bh.getlName(), "M");
		txtUser(bh.getAddress(), "Sarathi Nagar, Pallavaram, Chennai");
		txtUser(bh.getCreditNo(), "4567890123456789");
		selectByVisibleText(bh.getCreditType(),  li.get(2).get("creditCardType"));
		selectByVisibleText(bh.getExpMonth(), "May");
		selectByVisibleText(bh.getExpYear(), "2021");
	}

	@When("User click Booknow button")
	public void user_click_Booknow_button() {
		txtUser(bh.getCvv(), "456");
		click(bh.getBtnBooknow());
	}

	@When("User click My itinerary")
	public void user_click_My_itinerary() throws InterruptedException {
		
		cb=new ConfirmBooking();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaScript();
		screenShot();
		String order = driver.findElement(By.name("order_no")).getAttribute("value");
		click(cb.getBtnItinerary());
		screenShot();
		WebElement orderId=driver.findElement(By.xpath("//input[@value='"+order+"']/parent::td/preceding-sibling::td"));
		click(orderId);
		click(cb.getCancel());
		
		Thread.sleep(3000);
		Alert a=driver.switchTo().alert();
		a.accept();
	screenShot();
	}

	@Then("User select the order ID to Cancel and finally click Cancel Selected")
	public void user_select_the_order_ID_to_Cancel_and_finally_click_Cancel_Selected() {
		
	}

}
