package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
//        if (isOnBoardsPage()) {
//            click(By.cssSelector("[href$=boards]"));
//        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
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

}
