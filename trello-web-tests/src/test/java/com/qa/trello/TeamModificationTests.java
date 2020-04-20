package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getTeam().getTeamsCount()==0){
            app.getTeam().createTeam();
        }
    }

    @Test
    public void testChangeNameOfTeam(){
        app.getTeam().openFirstTeam();
        app.getTeam().openSettings();
        app.getTeam().editTeamProfile();
        app.getTeam().changeNameOfTeam();
        app.getTeam().confirmNameChange();
        app.getTeam().returnToHomePage();
    }


}
