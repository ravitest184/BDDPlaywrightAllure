package stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.microsoft.playwright.Page;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.PlaywrightManager;

public class LoginSteps {

    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Initialize the LoginPage with Playwright's Page
        Page page = PlaywrightManager.getPage(); // This will fetch the initialized Page
        loginPage = new LoginPage(page); // Initialize the LoginPage with the correct page instance
        loginPage.navigateToLoginPage();  // Navigating to the login page
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        loginPage.login("student", "Password123");  // Assuming "student" and "Password123" are valid credentials
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        boolean isLoggedIn = loginPage.isLoggedIn();  // Check if login was successful
        assertTrue("Login failed", isLoggedIn);  // Assert login success
    }
}
