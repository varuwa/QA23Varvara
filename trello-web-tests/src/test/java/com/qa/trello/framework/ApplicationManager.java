package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    BoardHelper board;
    TeamHelper team;
    SessionHelper session;
    ProfileHelper profile;
    String browser;
    Properties properties;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws IOException {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }
        if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();


        properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


        wd.navigate().to(properties.getProperty("web.baseURL"));

        session = new SessionHelper(wd);
        session.login(properties.getProperty("web.user"), properties.getProperty("web.password"));

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
