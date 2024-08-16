package com.devexperts.applitools;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.devexperts.AbstractTest;
import com.devexperts.pages.HeaderPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

@DisplayName("Localization Eyes testing")
public class LocalizationApplitoolsEyesTests extends AbstractTest {
    private WebDriver driver;
    private Eyes eyes;
    private final String apiKey = "z1BnizTwXwcIG1111ZaqstoRA5cRVqhG9u994EKzi80sX0110";
    private static ClassicRunner runner;
    private Configuration testConfig;
    private HeaderPage headerPage;

    @BeforeEach
    public void goToApplication() throws IOException {
        runner = new ClassicRunner();
        driver = goTo("https://toslc.thinkorswim.com/center");
        headerPage = new HeaderPage(driver);
        eyes = new Eyes();
        eyes.setApiKey(apiKey);
        eyes.setForceFullPageScreenshot(true);
        eyes.setAppName("LocalizationTest");
        testConfig = eyes.getConfiguration();
    }

    @Test
    public void changeLanguageToChineseSimplifiedTest() {
        testConfig.setTestName("Chinese(simplified)");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        headerPage.changeLanguage(2);
        eyes.checkWindow();
    }

    @Test
    public void changeLanguageToChineseTraditionalTest() {
        testConfig.setTestName("Chinese - Traditional");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        headerPage.changeLanguage(3);
        eyes.checkWindow();
    }

    @Test
    public void changeLanguageToEnglishTest() {
        testConfig.setTestName("English");
        eyes.setConfiguration(testConfig);
        eyes.open(driver);
        headerPage.changeLanguage(1);
        eyes.checkWindow();
    }
    @AfterEach
    public void tearDown(){
        eyes.closeAsync();
        eyes.abortIfNotClosed();
        driver.quit();
    }
    @AfterAll
    public static void printResults() {
        // Close the batch and report visual differences to the console.
        // Note that it forces JUnit to wait synchronously for all visual checkpoints to complete.
        TestResultsSummary allTestResults = runner.getAllTestResults(false);
        System.out.println(allTestResults);
    }
}