package stepDefinitions;

import java.io.IOException;

import com.maven.E2EProject.HomePageObjRepo;
import com.maven.E2EProject.LogInPageObjRepo;
import com.maven.resources.Base;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base {

	@Given("Initialize the browser with chrome")
	public void initialize_the_browser_with_chrome() throws IOException {
		driver = initializeDriver();
	}

	@Given("navigate to {string} site")
	public void navigate_to_site(String string) {
		driver.get(string);
	}

	@Given("Click on login home page to land on secure sign in page")
	public void click_on_login_home_page_to_land_on_secure_sign_in_page() {

		HomePageObjRepo hp = new HomePageObjRepo(driver);

		if (hp.getPopUpSize() > 0) {
			hp.getPopUp().click();
		}

		hp.getLogIn();
	}

//	@When("user enters {string} and {string} and logs in")
//	public void user_enters_and_and_logs_in(String string, String string2) {
//		LogInPageObjRepo lp = new LogInPageObjRepo(driver);
//		lp.getEmailId().sendKeys(string);
//		lp.getPassword().sendKeys(string2);
//		lp.getLogIn().click();
//	    
//	}

	@When("^user enters (.+) and (.+) and logs in$")
	public void user_enters_and_and_logs_in(String username, String password) {
		LogInPageObjRepo lp = new LogInPageObjRepo(driver);
		lp.getEmailId().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogIn().click();
	}

	@Then("verify that user is logged in successfully")
	public void verify_that_user_is_logged_in_successfully() {
		LogInPageObjRepo lp = new LogInPageObjRepo(driver);
		System.out.println(lp.getInvalidPWD().getText());
	}
	
	@And("^close the browser$")
    public void close_the_browser() {
		driver.quit();
    }

	
	

}
