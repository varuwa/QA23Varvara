package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if(app.getTeam().getTeamsCount()==0){
            app.getTeam().createTeam();
        }
        if(!app.getBoard().isOnBoardsPage()){
                app.getBoard().goToBoardsPageUrl("varuwa");
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

    @Test
    public void testCreateTeamBoard() throws InterruptedException {
        app.getTeam().openFirstTeam();
        app.getTeam().initBoardOfTeamCreation();
        app.getTeam().fillBoardTeamForm("NewTeamBoard");
        app.getTeam().confirmBoardTeamCreation();
        app.getTeam().returnToHomePage();
    }


}
