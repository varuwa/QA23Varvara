package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getTeamsCount()==0){
            app.createTeam();
        }
    }

    @Test
    public void testChangeNameOfTeam(){
        app.openFirstTeam();
        app.openSettings();
        app.editTeamProfile();
        app.changeNameOfTeam();
        app.confirmNameChange();
        app.returnToHomePage();
    }


}
