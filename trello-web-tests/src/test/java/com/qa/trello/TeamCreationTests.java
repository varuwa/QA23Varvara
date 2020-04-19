package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = getTeamsCount();
        initTeamCreation();
        fillForm("TestNewTeam", By.cssSelector("[class='_38pq5NbRWAG39y']"));
        confirmTeamCreation();
        Thread.sleep(3000);
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
    }
}
