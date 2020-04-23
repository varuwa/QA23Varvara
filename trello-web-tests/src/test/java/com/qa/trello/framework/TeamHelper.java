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
        waitForElementClickableAndClick(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"), 20);
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
            waitForElementLocatedAndClick(By.cssSelector("[data-test-id=show-later-button]"), 20);
        }
    }


    //Team Deletion
    public void clickOnSettings() {
        waitForElementLocatedAndClick(By.cssSelector(".icon-gear"), 20);
    }

    public void initTeamDeletion() {
        waitForElementLocatedAndClick(By.cssSelector(".quiet-button"), 20);
        confirm();
    }


    public void changeNameOfTeam() {
        type(By.cssSelector("[id='displayName']"), "NewTeamName");
    }

    public void editTeamProfile() {
        waitForElementClickableAndClick(By.cssSelector("[name='edit']"), 20);
    }

    public void openSettings() {
        waitForElementLocatedAndClick(By.cssSelector(".icon-gear"), 20);
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
