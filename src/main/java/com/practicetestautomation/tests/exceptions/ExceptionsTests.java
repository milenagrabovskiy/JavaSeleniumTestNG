package com.practicetestautomation.tests.exceptions;
import com.practicetestautomation.pageobjects.ExceptionsPage;
import com.practicetestautomation.tests.BaseTest;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsTests extends BaseTest {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ExceptionsTests.class);
    // make driver class level variable

    @Test(groups = {"debug", "regression"})
    public void noSuchElementTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visitExceptionsPAge();
        exceptionsPage.clickAddBtn();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test(groups = {"debug", "regression"})
    public void timeOUtExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visitExceptionsPAge();
        exceptionsPage.clickAddBtn();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test(groups = {"debug", "regression"})
    public void elementNotInteractable() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visitExceptionsPAge();
        exceptionsPage.clickAddBtn();
        exceptionsPage.isRowTwoDisplayedAfterWait();
        exceptionsPage.enterTextInRowTwo("soup");
        exceptionsPage.clickSaveBtn();
        Assert.assertEquals(exceptionsPage.getSuccessMessage(), "Row 2 was saved", "Message is not as expected");
    }

    @Test
    public void invalidElementStateException() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visitExceptionsPAge();
        exceptionsPage.clickEditBtn();
        exceptionsPage.enterTextInRowOne("gbdsh");
        exceptionsPage.clickSaveBtn();
        Assert.assertEquals(exceptionsPage.getSuccessMessage(), "Row 1 was saved", "Message not as expected");
    }

    @Test
    public void staleElementTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visitExceptionsPAge();
        exceptionsPage.clickAddBtn();
        Assert.assertTrue(exceptionsPage.isInstructionsElemHiddenAfterWait(), "Instructions should be hidden after clicking add btn");
    }

 }
