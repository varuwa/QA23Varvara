package com.qa.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
            if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @Test
    public void testBoardDeletion() {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().PermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before + " now: " + after);
    }

    @Test(enabled = false)
    public void test3BoardsDeletion() {
        int before = app.getBoard().getBoardsCount();
        int count = 0;
        do {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().PermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        count++;
        }
        while(count< 3);

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 3); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before + " now: " + after);
    }


}
