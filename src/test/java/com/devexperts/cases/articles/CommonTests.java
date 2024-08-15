package com.devexperts.cases.articles;
import com.devexperts.PlaywrightFactory;
import com.devexperts.configuration.CommonElements;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CommonTests extends PlaywrightFactory {

    PlaywrightFactory playwrightFactory;
    Page page;
    CommonElements commonElements;

   @BeforeEach
   public void setup() {
       playwrightFactory = new PlaywrightFactory();
       page = playwrightFactory.initBrowser("chrome", "https://toslc.thinkorswim.com");
       commonElements = new CommonElements(page);
   }

    @Test
    public void landingPageSearchTest() {
        String expectedKeyword = "Order Statuses";
        commonElements.searchByKeyword(expectedKeyword);
        String actualKeyword = commonElements.getLandingPageTextTitle();
        Assertions.assertEquals(expectedKeyword, actualKeyword);
    }

    @Test
    public void articleVideoPlayTest() {
        String videoStartTime = "00:00/20:32";
        commonElements.clickOnLInk("thinkManual");
        commonElements.clickOnVideoPlayIcon();
        String currentVideoTime = commonElements.getCurrentVideoTime();
        Assertions.assertNotEquals(videoStartTime, currentVideoTime);
    }




   @AfterEach
   public void tearDown() {
       page.context().browser().close();
   }
}
