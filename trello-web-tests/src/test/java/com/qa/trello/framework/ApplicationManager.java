package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    ProfileHelper profile;
    String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");

        session = new SessionHelper(wd);
        session.login("varuwa@gmail.com", "trellobarbara");

        new WebDriverWait(wd, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test-id=header-member-menu-button]")));

        board = new BoardHelper(wd);
        team = new TeamHelper(wd);
        profile = new ProfileHelper(wd);

    }

    public void stop() {
        wd.quit();
    }


    public BoardHelper getBoard() {
        return board;
    }

    public TeamHelper getTeam() {
        return team;
    }

    public SessionHelper getSession() {
        return session;
    }

    public ProfileHelper getProfile(){ return profile;}

}
