package com.devexperts;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Page initBrowser(String browserName, String navigate) {
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                break;

            default:
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(navigate);
        return page;
    }
}
