package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManager {

    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static final ThreadLocal<Page> page = new ThreadLocal<>();

    // Launch the browser
    public static void launchBrowser() {
        if (playwright.get() == null) {
            playwright.set(Playwright.create());  // Initialize Playwright
        }

        if (browser.get() == null) {
            browser.set(playwright.get().chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)  // Run the browser in non-headless mode
                    .setSlowMo(100)));   // Slow down the actions for visibility
        }

        if (page.get() == null) {
            page.set(browser.get().newPage());  // Create a new page for each test
        }
    }

    // Get the current page instance for interacting with the browser
    public static Page getPage() {
        return page.get();
    }

    // Close the browser and cleanup
    public static void closeBrowser() {
        if (page.get() != null) {
            page.get().close();  // Close the page
            page.remove();  // Remove the page from ThreadLocal
        }
        if (browser.get() != null) {
            browser.get().close();  // Close the browser
            browser.remove();  // Remove the browser from ThreadLocal
        }
        if (playwright.get() != null) {
            playwright.get().close();  // Close Playwright
            playwright.remove();  // Remove the Playwright instance from ThreadLocal
        }
    }
}
