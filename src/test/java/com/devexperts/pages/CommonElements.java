package com.devexperts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonElements {
    private Page page;
    private String searchbarLocator = "//input[@name='keyword']";
    private String videoPlayIconLocator = "//button[@aria-label='Play video']";
    private String videoTimerLocator = "//span[@class='VideoPlayerControls__controls__time']";
    private String headerElementsLocator = "//li[@class='MainMenu__item']";
    private String searchSuggestionListLocator = "//li[@class='AutocompleteMenuItem__item List-interop__item_level_0']";
    private String articleTitleLocator = "//div[@class='content__container MainContent__content']//h1";

    public CommonElements(Page page) {
        this.page = page;
    }

    public void typeKeywordInSearchbar(String keyword) {
        page.locator(searchbarLocator).click();
        page.locator(searchbarLocator).fill(keyword);
    }

    public String getArticleTitleText() {
        String titleText = page.locator(articleTitleLocator).innerText();
        return titleText;
    }

    public void clickOnListResult(int index) {
        Locator listResults = page.locator(searchSuggestionListLocator);
        listResults.nth(index).click();
    }

    public void clickOnTheHeaderElement(int index) {
        Locator headerLinks = page.locator(headerElementsLocator);
        headerLinks.nth(index).click();
    }

    public void clickOnVideoPlayIcon() {
        page.locator(videoPlayIconLocator).click();
    }

    public String getCurrentVideoTime() {
        return page.locator(videoTimerLocator).textContent();
    }
}
