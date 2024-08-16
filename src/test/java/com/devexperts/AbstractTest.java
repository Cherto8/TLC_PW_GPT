package com.devexperts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class AbstractTest {
    WebDriver driver;

    public WebDriver goTo(String url) throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/java/Resources/GlobalData.properties");
        prop.load(fis);
        String browser = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browser.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("headless");
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen

        } else if (browser.contains("edge")) {
            EdgeOptions options = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            options.addArguments("headless");
            driver = new EdgeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen

        } else if (browser.contains("firefox")) {

            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            options.addArguments("headless");
            driver = new FirefoxDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));//full screen
        }
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        return driver;
    }
}