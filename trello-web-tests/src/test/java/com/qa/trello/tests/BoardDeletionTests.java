package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class BoardDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
            if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }


        int boardsCount = app.getBoard().getBoardsCount();

        while(boardsCount > 4){
            app.getBoard().deleteBoard();
            boardsCount = app.getBoard().getBoardsCount();
        }
    }


    @Test
    public void testBoardDeletion() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().PermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before - 1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before + " now: " + after);
        Thread.sleep(3000);
    }

    @Test
    public void testBoardDeletionList() throws InterruptedException {

        List<Board> before = app.getBoard().getBoardsList();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().PermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();

        List<Board> after = app.getBoard().getBoardsList();
        Assert.assertEquals(after.size(), before.size() - 1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before.size() + " now: " + after.size());


        before.remove(0);
        Assert.assertEquals(before, after);

        Thread.sleep(3000);
    }

    @Test
    public void testBoardDeletionSet() throws InterruptedException {

        Set<Board> before = app.getBoard().getBoardsSet();
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickMoreButton();
        app.getBoard().initBoardDeletion();
        app.getBoard().PermanentlyDeleteBoard();
        app.getBoard().returnToHomePage();

        Set<Board> after = app.getBoard().getBoardsSet();

        Assert.assertEquals(after.size(), before.size() - 1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: " + before.size() + " now: " + after.size());


        before.remove(0);

        Assert.assertEquals(before, after);

        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void test3BoardsDeletion() throws InterruptedException {
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
