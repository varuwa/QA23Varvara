package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(getTeamsCount()==0){
            createTeam();
        }
    }

    @Test
    public void testTeamDeletion() {
        int before = getTeamsCount();
        openFirstTeam();
        clickOnSettings();
        initTeamDeletion();
        int after = getTeamsCount();
        Assert.assertEquals(after, before - 1);
        System.out.println("was: " + before + " now: " + after);
    }
}
