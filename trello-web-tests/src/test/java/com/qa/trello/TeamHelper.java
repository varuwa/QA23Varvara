package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
    }
    public int getTeamsCount() {
        return wd.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    //TeamCreation
    public void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void fillForm(String nameOfTeam) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[class='_38pq5NbRWAG39y']")); //"[data-test-id^=header-create-team-type-input] li"
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) { //если тру кликни
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
    }

    //Team Deletion
    public void openFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

    public void clickOnSettings() {
        click(By.cssSelector(".icon-gear"));
    }

    public void initTeamDeletion() {
        click(By.cssSelector(".quiet-button"));
        confirm();
    }



    public void changeNameOfTeam() {
        type(By.cssSelector("[id='displayName']"), "NewTeamName");
    }

    public void editTeamProfile() {
        click(By.cssSelector("[name='edit']"));
    }

    public void openSettings() {
        click(By.cssSelector(".icon-gear"));
    }

    //testChangeNameOfTeam
    public void confirmNameChange() {
        click(By.cssSelector("[type='submit']"));
    }

    public void createTeam() throws InterruptedException {
        initTeamCreation();
        fillForm("TestNewTeam");
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
    }
}
