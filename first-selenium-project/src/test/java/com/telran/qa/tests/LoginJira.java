package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginJira {
    WebDriver wd;



    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        //wd.get("http://jira.tel-ran.net/login.jsp");
        wd.navigate().to("http://jira.tel-ran.net/login.jsp");
    }

    @Test
    public void loginJira() throws InterruptedException {
        type(By.id("login-form-username"), "varuwa");
        type(By.id("login-form-password"), "8888");
        click(By.id("login-form-submit"));

        Assert.assertTrue(isElementPresent(By.id("usernameerror")));
        //String errorMessage = wd.findElement(By.id("usernameerror")).getText();
        //Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");

        Thread.sleep(3000);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    // public boolean isElementPresent() {
   //     return wd.findElements(By.id("usernameerror")).size() > 0;
   // }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }
}