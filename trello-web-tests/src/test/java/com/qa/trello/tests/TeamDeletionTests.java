package com.qa.trello.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getTeam().getTeamsCount() == 0) {
            app.getTeam().createTeam();
        }
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @Test
    public void testTeamDeletion() throws InterruptedException {
        int before = app.getTeam().getTeamsCount();
        app.getTeam().openFirstTeam();
        app.getTeam().clickOnSettings();
        app.getTeam().initTeamDeletion();
        app.getTeam().returnToHomePage();
        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("was: " + before + " now: " + after);
    }

    @Test(enabled = false)
    public void test2TeamDeletion() throws InterruptedException {
        int before = app.getTeam().getTeamsCount();
        int count = 1;
        do {
            app.getTeam().openFirstTeam();
            app.getTeam().clickOnSettings();
            app.getTeam().initTeamDeletion();
            app.getTeam().returnToHomePage();
            count++;
        }
        while (count < 3);

        int after = app.getTeam().getTeamsCount();
        Assert.assertEquals(after, before - 2);
        System.out.println("was: " + before + " now: " + after);

    }
}
