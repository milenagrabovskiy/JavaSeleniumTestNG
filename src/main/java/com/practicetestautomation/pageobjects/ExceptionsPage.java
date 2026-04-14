package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionsPage extends BasePage{
    private By addBtnLocator = By.id("add_btn");
    private By editBtnLocator = By.id("edit_btn");
    private By saveBtn = By.name("Save");
    private By rowOneInputFieldLocator = By.cssSelector("input.input-field");
    private By rowTwoInputFieldLocator = By.cssSelector("input.input-field");
    private By confirmationMsgLocator = By.id("confirmation");
    private By instructionsLocator = By.id("instructions");


    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visitExceptionsPAge() {
        visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddBtn() {
        driver.findElement(addBtnLocator).click();
    }

    public void clickEditBtn() {
        driver.findElement(editBtnLocator).click();
    }

    public void clickSaveBtn() {
        driver.findElement(saveBtn).click();
    }

    public boolean isRowTwoDisplayedAfterWait() {
        return waitForIsDisplayed(rowTwoInputFieldLocator);
    }

    public void enterTextInRowOne(String name) {
        driver.findElement(rowOneInputFieldLocator).sendKeys(name);
    }

    public void enterTextInRowTwo(String name) {
        WebElement row1Input = driver.findElement(rowTwoInputFieldLocator);
        row1Input.clear();
        row1Input.sendKeys(name);
    }

    public String getSuccessMessage() {
        return waitForElement(confirmationMsgLocator).getText();
    }

    public boolean isInstructionsElemHiddenAfterWait() {
        return waitForIsHidden(instructionsLocator);
    }

}
