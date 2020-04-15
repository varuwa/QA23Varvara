package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTests {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
    }

    @Test
    public void testTeamCreation() throws InterruptedException {
        initLogin();
        fillLoginForm("varuwa@gmail.com", "trellobarbara");
        confirmLogin();
        initTeamCreation();
        fillForm("Team_test", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
    }

    private void fillForm(String nameOfTeam, By locatorTeamType) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(locatorTeamType);
    }

    private void returnToHomePage() {
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
    }

    private void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }

    private void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    private void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    private void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    private void confirmLogin() {
        click(By.id("login"));
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
