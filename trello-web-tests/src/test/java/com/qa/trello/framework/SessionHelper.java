package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String userEmail, String password) {
        initLogin();
        fillLoginForm(userEmail, password);
        confirmLogin();

    }
    public void initLogin() {
        waitForElementLocatedAndClick(By.cssSelector("[href='/login']"), 20);
    }
    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }
    public void confirmLogin() {
        waitForElementClickableAndClick(By.id("login"), 30);
    }
}
