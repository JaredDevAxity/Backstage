package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.BasePage;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "step_definitions", monochrome = true,
		plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"json:target/cucumber-reports.json" },
		//tags = "@Test1")
		tags = "@Test")


public class Runner {

	@AfterClass
	public static void cleanDriver() {
		BasePage.closeBrowser();
		System.out.println("***********Browser closes***********");
	}
}