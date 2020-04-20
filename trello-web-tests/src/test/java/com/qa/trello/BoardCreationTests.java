package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation() {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm("TestNewBoard");
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before+1);
        System.out.println("was: "+ before + " now: " + after);
    }

}
