package com.devexperts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    WebDriver driver;
    public HeaderPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    private By languageSelector = By.cssSelector("span[class='LanguageSelector__label']");

    public void changeLanguage(int index) {

        driver.findElement(languageSelector).click();
        driver.findElement(By.cssSelector("ul[class*='LanguageSelector__menu']>li:nth-child("+ index +")")).click();
    }
}