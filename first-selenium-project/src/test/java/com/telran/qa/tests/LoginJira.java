package com.telran.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginJira {
    WebDriver wd;


    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        //wd.get("http://jira.tel-ran.net/login.jsp");
        wd.navigate().to("http://jira.tel-ran.net/login.jsp");
    }

    @Test
    public void testLoginJira() throws InterruptedException {
        type(By.id("login-form-username"), "varuwa");
        type(By.id("login-form-password"), "8888");
        click(By.id("login-form-submit"));

        Assert.assertFalse(isElementPresent(By.className("aui-message-error")));

        Thread.sleep(3000);
    }

    @Test
    public void testLoginJiraNeg() throws InterruptedException {
        type(By.id("login-form-username"), "aruwa");
        type(By.id("login-form-password"), "888");
        click(By.id("login-form-submit"));

        Assert.assertTrue(isElementPresent(By.className("aui-message-error")));
        String errorMessage = wd.findElement(By.className("aui-message-error")).getText();
        Assert.assertEquals(errorMessage, "Sorry, your username and password are incorrect - please try again.");

        Thread.sleep(3000);
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
        return wd.findElements(locator).size() > 0;
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
}