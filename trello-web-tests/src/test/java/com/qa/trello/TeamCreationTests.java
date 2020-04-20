package com.qa.trello;


import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = getTeamsCount();
        initTeamCreation();
        fillForm("TestNewTeam");
        inviteTeamLater();
        confirmTeamCreation();
        Thread.sleep(2000);
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
    }

}
