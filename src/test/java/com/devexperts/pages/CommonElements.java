package com.devexperts.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CommonElements {
    private Page page;
    private String searchbarLocator = "//input[@name='keyword']";
    private String searchTitleLocator = "//div[@class='SearchListItem__title__text']";
    private String videoPlayIconLocator = "//button[@aria-label='Play video']";
    private String videoTimerLocator = "//span[@class='VideoPlayerControls__controls__time']";
    private String headerElementsLocator = "//li[@class='MainMenu__item']";

    public CommonElements(Page page) {
        this.page = page;
    }

    public void searchByKeyword(String keyword) {
        page.locator(searchbarLocator).click();
        page.locator(searchbarLocator).fill(keyword);
        page.locator(searchbarLocator).press("Enter");
    }

    public String getLandingPageTextTitle() {
        String textTitle = page.locator(searchTitleLocator).first().innerText();
        return textTitle;
    }

    public void clickOnLInk(String linkText) {
        page.getByText(linkText).click();
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
