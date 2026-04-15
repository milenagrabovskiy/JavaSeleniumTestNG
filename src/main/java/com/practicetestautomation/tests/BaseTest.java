package com.practicetestautomation.tests;

import com.practicetestautomation.tests.exceptions.ExceptionsTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseTest {
    protected WebDriver driver;
    protected Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger = Logger.getLogger(ExceptionsTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running test in: " + browser);
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");

                // Only headless when system property is passed
                if (System.getProperty("headless") != null) {
                    options.addArguments("--headless=new");
                    options.addArguments("--disable-gpu");
                }

                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if (System.getProperty("headless") != null) {
                    firefoxOptions.addArguments("--headless");
                }

                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                logger.warning("Configuration for " + browser + " is missing. Running tests in chrome by default");
                driver = new ChromeDriver();
                break;
        }
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // implicit wait in setup

        // Open page
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Quitting driver...");
        if (driver != null) {
            driver.quit();
        }
    }

}
