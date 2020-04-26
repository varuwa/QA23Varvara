package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void openFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }


    //TeamCreation
    public void initTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"), 20);
    }

    public void fillForm(String nameOfTeam) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
        waitForElementLocatedAndClick(By.id("teamTypeSelect"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[class='_38pq5NbRWAG39y']"), 20); //"[data-test-id^=header-create-team-type-input] li"
    }

    public void confirmTeamCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[type='submit']"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[class='eg0KI5SqghoOFd']"), 20);
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) { //если тру кликни
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }


    //Team Deletion
    public void clickOnSettings() {
        click(By.cssSelector(".icon-gear"));
    }

    public void initTeamDeletion() {
        waitForElementLocatedAndClick(By.cssSelector(".quiet-button"), 20);
        confirm();
    }


    public void changeNameOfTeam() {
        type(By.cssSelector("[id='displayName']"), "NewTeamName");
    }

    public void editTeamProfile() {
        waitForElementLocatedAndClick(By.cssSelector("[name='edit']"), 20);
    }

    public void openSettings() {
        waitForElementLocatedAndClick(By.cssSelector("[class='icon-gear icon-sm _2aV_KY1gTq1qWc']"), 30);
    }

    //testChangeNameOfTeam
    public void confirmNameChange() {
        waitForElementLocatedAndClick(By.cssSelector("[type='submit']"), 20);
    }

    public void createTeam() throws InterruptedException {
        initTeamCreation();
        fillForm("TestNewTeam");
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
    }

    //testCreateTeamBoard
    public void initBoardOfTeamCreation() throws InterruptedException {
        Thread.sleep(1000);
        waitForElementLocatedAndClick(By.cssSelector(".mod-add"), 20);
    }

    public void fillBoardTeamForm(String nameOfBoardTeam) {
        wd.findElement(By.cssSelector("[data-test-id='create-board-title-input']")).sendKeys(nameOfBoardTeam);

    }

    public void confirmBoardTeamCreation() throws InterruptedException {
        waitForElementLocatedAndClick(By.cssSelector("[class='button primary']"), 20);
        Thread.sleep(5000);
    }

}
