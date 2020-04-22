package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0; //тру или фолс, элемент есть или нет
    }

    public void returnToHomePage() {
        click(By.cssSelector("[name='house']"));
        click(By.cssSelector("[name='house']"));
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }
}
