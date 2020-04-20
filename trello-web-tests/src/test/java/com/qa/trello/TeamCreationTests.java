package com.qa.trello;


import org.testng.Assert;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @Test
    public void testTeamCreation() throws InterruptedException {
        int before = app.getTeam().getTeamsCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillForm("TestNewTeam");
        app.getTeam().inviteTeamLater();
        app.getTeam().confirmTeamCreation();
        Thread.sleep(2000);
        app.getTeam().returnToHomePage();
        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
    }

}
