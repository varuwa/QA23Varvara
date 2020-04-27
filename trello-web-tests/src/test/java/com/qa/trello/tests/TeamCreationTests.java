package com.qa.trello.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @Test
    public void testTeamCreation(){
        int before = app.getTeam().getTeamsCount();
        app.getTeam().initTeamCreation();
        app.getTeam().fillForm("TestNewTeam");
        app.getTeam().confirmTeamCreation();
        app.getTeam().inviteTeamLater();
        app.getTeam().returnToHomePage();

        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
    }

}
