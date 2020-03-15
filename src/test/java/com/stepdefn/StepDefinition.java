 package com.stepdefn;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.POM.PageObjectManager;
import com.base.BaseClass;
import io.cucumber.java.en.*;

public class StepDefinition extends BaseClass {
	PageObjectManager pageObjectManager= new PageObjectManager();
	
	@Given("User is on adactin page")
	public void user_is_on_adactin_page() {
		driver = getDriver();
		loadUrl("https://adactin.com/HotelApp/");
	}

	@When("User enter username and password")
	public void user_enter_username_and_password(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> li = dataTable.asMaps();
		txtUser(pageObjectManager.getLoginPage().getTxtUserName(), li.get(0).get("userName"));
		txtUser(pageObjectManager.getLoginPage().getTxtPassword(), li.get(0).get("password"));
	}

	@When("User click the login button")
	public void user_click_the_login_button() {
		click(pageObjectManager.getLoginPage().getBtnLogin());
	}

	@When("User shuold enter all the details for search hotel")
	public void user_shuold_enter_all_the_details_for_search_hotel(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> li = dataTable.asMaps();
		selectByVisibleText(pageObjectManager.getSearch().getLocation(), li.get(1).get("location"));
		selectByVisibleText(pageObjectManager.getSearch().getHotel(),  li.get(3).get("hotels"));
		selectByVisibleText(pageObjectManager.getSearch().getRoomType(),  li.get(2).get("roomType"));
		selectByVisibleText(pageObjectManager.getSearch().getNoRoom(),  li.get(1).get("noOfRooms"));
		txtUser(pageObjectManager.getSearch().getDateIn(),  li.get(0).get("checkInDate"));
		txtUser(pageObjectManager.getSearch().getDateOut(),  li.get(0).get("checkOutDate"));
		selectByVisibleText(pageObjectManager.getSearch().getAdultRoom(),  li.get(2).get("adultsPerRoom"));
		click(pageObjectManager.getSearch().getBtnSearch());
	}

	@When("User should select any one of the available hotel")
	public void user_should_select_any_one_of_the_available_hotel() {
		
		click(pageObjectManager.getSelect().getSelect());
		click(pageObjectManager.getSelect().getCnte());
	}
	@When("User should enter First name, Last name, Address and Payment details")
	public void user_should_enter_First_name_Last_name_Address_and_Payment_details(io.cucumber.datatable.DataTable dataTable) {
		
		List<Map<String, String>> li = dataTable.asMaps();
		txtUser(pageObjectManager.getBookHotel().getfName(), "Sowmiya");
		txtUser(pageObjectManager.getBookHotel().getlName(), "M");
		txtUser(pageObjectManager.getBookHotel().getAddress(), "Sarathi Nagar, Pallavaram, Chennai");
		txtUser(pageObjectManager.getBookHotel().getCreditNo(), "4567890123456789");
		selectByVisibleText(pageObjectManager.getBookHotel().getCreditType(),  li.get(2).get("creditCardType"));
		selectByVisibleText(pageObjectManager.getBookHotel().getExpMonth(), "May");
		selectByVisibleText(pageObjectManager.getBookHotel().getExpYear(), "2021");
	}
	@When("User click Booknow button")
	public void user_click_Booknow_button() {
		txtUser(pageObjectManager.getBookHotel().getCvv(), "456");
		click(pageObjectManager.getBookHotel().getBtnBooknow());
	}
	@When("User click My itinerary")
	public void user_click_My_itinerary() throws InterruptedException {
		
	
		Thread.sleep(5000);
		javaScript();
		//screenShot();
		String order = driver.findElement(By.name("order_no")).getAttribute("value");
		click(pageObjectManager.getConfirmBooking().getBtnItinerary());
		//screenShot();
		WebElement orderId=driver.findElement(By.xpath("//input[@value='"+order+"']/parent::td/preceding-sibling::td"));
		click(orderId);
		click(pageObjectManager.getConfirmBooking().getCancel());
		Thread.sleep(3000);
		Alert a=driver.switchTo().alert();
		a.accept();
		//screenshot1(null);
		}	
	
	

	@Then("User select the order ID to Cancel and finally click Cancel Selected")
	public void user_select_the_order_ID_to_Cancel_and_finally_click_Cancel_Selected() {
		
	}


}
