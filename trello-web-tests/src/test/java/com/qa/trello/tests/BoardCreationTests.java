package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @Test
    public void testBoardCreation() {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new Board().withName("Board" + System.currentTimeMillis()).withColor("green"));
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before+1);
        System.out.println("was: "+ before + " now: " + after);
    }

}
