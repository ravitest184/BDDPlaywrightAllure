package utils;

import com.microsoft.playwright.*;

public class PlaywrightManager {
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static synchronized void launchBrowser() {
        try {
            Playwright playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
            context = browser.newContext();
            page = context.newPage();
        } catch (Exception e) {
            throw new RuntimeException("Failed to launch browser", e);
        }
    }

    public static synchronized Page getPage() {
        if (page == null) {
            launchBrowser();
        }
        return page;
    }

    public static synchronized void closeContext() {
        if (page != null) {
            page.close();
            page = null;
        }
        if (context != null) {
            context.close();
            context = null;
        }
    }

    public static synchronized void closeBrowser() {
        closeContext();
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

    public static synchronized void resetState() {
        closeBrowser();
    }
}
