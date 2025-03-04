package utils;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

    @BeforeAll
    public static void globalSetup() {
        PlaywrightManager.resetState();
    }

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
        PlaywrightManager.launchBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = PlaywrightManager.getPage().screenshot(
                    new com.microsoft.playwright.Page.ScreenshotOptions()
                        .setFullPage(true));
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                System.err.println("Failed to capture screenshot: " + e.getMessage());
            }
        }
        PlaywrightManager.closeBrowser();
    }

    @AfterAll
    public static void globalTearDown() {
        PlaywrightManager.resetState();
    }
}

