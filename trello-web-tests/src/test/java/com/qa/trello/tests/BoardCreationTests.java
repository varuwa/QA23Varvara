package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BoardCreationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }
    @Test
    public void testBoardCreation() throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new Board().withName("Board" + System.currentTimeMillis())
                .withTeam("No team").withColor("green"));
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();
        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
        Thread.sleep(3000);
    }

    @Test
    public void testBoardCreationTwo() throws InterruptedException {
     //   int before = app.getBoard().getBoardsCountFromList();
     List<Board> before = app.getBoard().getBoardsList();
        app.getBoard().initBoardCreation();
        app.getBoard().fillBoardForm(new Board().withName("Board" + System.currentTimeMillis())
                .withTeam("No team").withColor("green"));
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();

        // int after = app.getBoard().getBoardsCount();
        List<Board> after = app.getBoard().getBoardsList();
        Assert.assertEquals(after.size(), before.size() + 1);
       // System.out.println("was: " + before + " now: " + after);
       // Thread.sleep(3000);


    }

    @Test
    public void getBoardsNames(){
        app.getBoard().getBoardsList();
    }

}
