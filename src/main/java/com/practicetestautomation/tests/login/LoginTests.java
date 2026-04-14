package com.practicetestautomation.tests.login;
import com.practicetestautomation.pageobjects.LoginPage;
import com.practicetestautomation.pageobjects.SuccessfulLoginPage;
import com.practicetestautomation.tests.BaseTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginTests extends BaseTest {
    @Test(groups = {"positive", "regression", "smoke"})
    public void testLoginFunctionality() {

        logger.info("Starting testLoginFunctionality...");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visitLoginPage();
        SuccessfulLoginPage successfulLoginPage = loginPage.executeLogin("student", "Password123");
        successfulLoginPage.load();
        logger.info("verifying login functionality");
        Assert.assertEquals(successfulLoginPage.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        Assert.assertTrue(successfulLoginPage.getPageSource().contains("Congratulations student. You successfully logged in!"));
    }

    @Parameters({"username", "password", "expectedErrorMessage"})
    @Test(groups = {"negative", "regression"})
    public void testNegativeLogin(String username, String password, String expectedErrorMessage) {

        logger.info("Starting testNegativeLogin");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visitLoginPage();
        loginPage.executeLogin(username, password);
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }
}
