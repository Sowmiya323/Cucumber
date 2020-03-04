package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\\\Sowmiya\\\\My PROGRAMS\\\\CucumberDay2\\\\driver\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void loadUrl(String url) {
		driver.get(url);
	}

	public void txtUser(WebElement e, String name) {
		e.sendKeys(name);
	}

	public void click(WebElement e) {
		try {
		e.click();
		}
		catch(Exception e1)
		{
		System.out.println("click not success");
		}
	}

	public void selectByVisibleText(WebElement e, String slt) {
		new Select(e).selectByVisibleText(slt);
	}
	public void javaScript() {
		JavascriptExecutor j=(JavascriptExecutor)driver;
				j.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.name("order_no")));

	}
	private String generateRandonData() {
		return new SimpleDateFormat("EEE_MMM_dd_yyyy_hhmmss").format(new Date());

	}

	public void screenShot() {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File loc = new File("D:\\Sowmiya\\My PROGRAMS\\Cucumber43\\Screenshot\\" + generateRandonData() + ".png");
		try {
			FileUtils.copyFile(f, loc);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

}
