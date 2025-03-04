package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        PlaywrightManager.launchBrowser(); // Initialize browser before each test
    }

    @After
    public void tearDown() {
        PlaywrightManager.closeBrowser(); // Clean up browser after each test
    }
}

