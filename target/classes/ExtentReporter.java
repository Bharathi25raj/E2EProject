package com.maven.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	public static ExtentReports report;

	public static ExtentReports getExtentReport() {

		// ExtentReports, ExtentSparkReports

		String path = System.getProperty("user.dir") + "\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automaton Results");
		reporter.config().setDocumentTitle("Extent Report of Web Automation Test");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Bharathi Rajkumar");
		
		return report;

	}

}
