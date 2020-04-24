package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void waitForElementLocatedAndClick(By locator, int timeOut) {

        new WebDriverWait (wd, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator)).click();
//        wd.findElement(locator).click();
    }

    public void waitForElementClickableAndClick(By locator, int timeOut) {

        new WebDriverWait (wd, timeOut).until(ExpectedConditions.elementToBeClickable(locator)).click();
//        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        waitForElementLocatedAndClick(locator, 30);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean checkPageUrl(String pageName){
        return new WebDriverWait(wd, 20).until(ExpectedConditions.urlContains(pageName));
    }





    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0; //тру или фолс, элемент есть или нет
    }

    public void returnToHomePage() {
        waitForElementClickableAndClick(By.cssSelector("[name='house']"), 20);
    }

    public void confirm() {
        waitForElementLocatedAndClick(By.cssSelector(".js-confirm"), 20);
    }
}
