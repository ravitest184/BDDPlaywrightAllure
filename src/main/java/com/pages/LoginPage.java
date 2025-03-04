package com.pages;

import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private final Page page;
    private static final String LOGIN_URL = "https://practicetestautomation.com/practice-test-login/";
    
    // Locators
    private static final String USERNAME_INPUT = "#username";
    private static final String PASSWORD_INPUT = "#password";
    private static final String SUBMIT_BUTTON = "#submit";
    private static final String POST_TITLE = ".post-title";
    private static final String ERROR_MESSAGE = "#error";
    
    public LoginPage(Page page) {
        this.page = page;
    }
    
    public void navigateToLoginPage() {
        page.navigate(LOGIN_URL);
        // Wait for the page to be ready
        page.waitForLoadState();
        // Ensure login form is visible
        page.waitForSelector(USERNAME_INPUT);
    }
    
    public void login(String username, String password) {
        page.fill(USERNAME_INPUT, username);
        page.fill(PASSWORD_INPUT, password);
        page.click(SUBMIT_BUTTON);
        // Wait for navigation
        page.waitForLoadState();
    }
    
    public boolean isLoggedIn() {
        try {
            return page.waitForSelector(POST_TITLE, new Page.WaitForSelectorOptions().setTimeout(5000)).isVisible();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getErrorMessage() {
        try {
            return page.waitForSelector(ERROR_MESSAGE, new Page.WaitForSelectorOptions().setTimeout(5000)).textContent();
        } catch (Exception e) {
            return "";
        }
    }
    
    public String getSuccessMessage() {
        try {
            return page.waitForSelector(POST_TITLE, new Page.WaitForSelectorOptions().setTimeout(5000)).textContent();
        } catch (Exception e) {
            return "";
        }
    }
}