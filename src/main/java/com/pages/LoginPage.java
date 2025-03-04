package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    
    public LoginPage(Page page) {
        this.page = page;
    }
    
    public void navigateToLoginPage() {
        page.navigate("https://practicetestautomation.com/practice-test-login/");
    }
    
    public void login(String username, String password) {
        page.fill("#username", username);
        page.fill("#password", password);
        page.click("#loginButton");
    }
    
    public boolean isLoggedIn() {
        return page.isVisible("#userProfile");
    }
}