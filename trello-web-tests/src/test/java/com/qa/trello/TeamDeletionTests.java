package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getTeamsCount()==0){
            app.createTeam();
        }
    }

    @Test
    public void testTeamDeletion() {
        int before = app.getTeamsCount();
        app.openFirstTeam();
        app.clickOnSettings();
        app.initTeamDeletion();
        int after = app.getTeamsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("was: " + before + " now: " + after);
    }
}
