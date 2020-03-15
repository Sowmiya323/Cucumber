package com.base;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {
	public static void generateJvmReport(String jsonFile) {
		File loc=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Report");
		Configuration con=new Configuration(loc, "Adactin");
		con.addClassifications("OS", "Windows 10");
		con.addClassifications("BrowserName", "Chrome");
		con.addClassifications("Version", "79");
		con.addClassifications("Sprint", "23");
		List<String> jsonFiles=new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder builder=new ReportBuilder(jsonFiles, con);
		builder.generateReports();
	}

}
