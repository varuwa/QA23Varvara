package com.qa.trello;


import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = app.getTeamsCount();
        app.initTeamCreation();
        app.fillForm("TestNewTeam");
        app.inviteTeamLater();
        app.confirmTeamCreation();
        Thread.sleep(2000);
        app.returnToHomePage();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
    }

}
