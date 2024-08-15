package com.devexperts.configuration;

import com.microsoft.playwright.Page;

public class CommonElements {
    private Page page;
    private String searchbarLocator = "//input[@name='keyword']";
    private String searchTitleLocator = "//div[@class='SearchListItem__title__text']";
    private String videoPlayIconLocator = "//button[@class='Overlay__playButton__icon']";
    private String videoTimerLocator = "//span[@class='VideoPlayerControls__controls__time']";

    public CommonElements(Page page) {
        this.page = page;
    }

    public void searchByKeyword(String keyword){
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

    public void clickOnVideoPlayIcon() {
        page.locator(videoPlayIconLocator).click();
    }

    public String getCurrentVideoTime() {
        return page.locator(videoTimerLocator).textContent();
    }
}
