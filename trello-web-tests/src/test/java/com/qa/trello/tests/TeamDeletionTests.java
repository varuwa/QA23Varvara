package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getTeam().getTeamsCount()==0){
            app.getTeam().createTeam();
        }
    }

    @Test
    public void testTeamDeletion() {
        int before = app.getTeam().getTeamsCount();
        app.getTeam().openFirstTeam();
        app.getTeam().clickOnSettings();
        app.getTeam().initTeamDeletion();
        app.getTeam().returnToHomePage();
        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("was: " + before + " now: " + after);
    }
}
