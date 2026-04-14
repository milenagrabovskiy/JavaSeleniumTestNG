package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SuccessfulLoginPage extends BasePage{
    // class variables
    private By logOutBtnLocator = By.linkText("Log out");

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutBtnDisplayed() {
        return isDisplayed(logOutBtnLocator);
    }

    public void load() {
        waitForElement(logOutBtnLocator);
    }
}
