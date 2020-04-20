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
        if (app.getBoardsCount() == 0) {
            app.createBoard();
        }
    }

    @Test
    public void testBoardDeletion() {
        int before = app.getBoardsCount();
        app.openFirstPersonalBoard();
        app.clickMoreButton();
        app.initBoardDeletion();
        app.PermanentlyDeleteBoard();
        app.returnToHomePage();
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before - 1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before + " now: " + after);
    }

}
