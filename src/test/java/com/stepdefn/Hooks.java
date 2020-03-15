package com.stepdefn;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends BaseClass{
@After
public void screenshot1(Scenario sc) {
	TakesScreenshot tk = (TakesScreenshot) driver;
	byte[] b1 = tk.getScreenshotAs(OutputType.BYTES);
	System.out.println(b1);
	sc.embed(b1, "images/png");
}

}
