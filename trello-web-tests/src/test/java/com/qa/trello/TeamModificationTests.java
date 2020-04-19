package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(getTeamsCount()==0){
            createTeam();
        }
    }

    @Test
    public void testChangeNameOfTeam(){
        openFirstTeam();
        openSettings();
        editTeamProfile();
        changeNameOfTeam();
        confirmNameChange();
        returnToHomePage();
    }


}
