package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
WebDriver wd;

private void click(By locator) {
        wd.findElement(locator).click();
    }

@BeforeClass
public void setUp(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("http://jira.tel-ran.net/login.jsp");
}

@Test
    public void loginJira() throws InterruptedException {
    click(By.id("login-form-username"));
    wd.findElement(By.id("login-form-username")).clear();
    wd.findElement(By.id("login-form-username")).sendKeys("varuwa");
    click(By.id("login-form-password"));
    wd.findElement(By.id("login-form-password")).clear();
    wd.findElement(By.id("login-form-password")).sendKeys("8888");
    click(By.id("login-form-submit"));

    Thread.sleep(3000);
}

@AfterClass
    public void tearDown(){
    wd.quit();
    }
}