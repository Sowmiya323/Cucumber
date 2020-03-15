package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources" }, glue = { "com.stepdefn" }, monochrome = true, plugin = {
		"json:src\\test\\resources\\Report\\Cucumber.json" })
public class RunnerClass {
	@AfterClass
	public static void afterClass() {
		JvmReport.generateJvmReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Report\\Cucumber.json");
	}

}
