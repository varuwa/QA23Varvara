package com.qa.trello.tests;

import com.qa.trello.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTestsDataProvider extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
        if (!app.getBoard().isOnBoardsPage()) {
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @DataProvider
    public Iterator<Object[]> validBoardsEasy() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"hhhhhhhhhhhhhhh", "blue"});
        list.add(new Object[]{"h", "orange"});
        list.add(new Object[]{"11111111", "green"});
        return list.iterator();
    }

    @Test(enabled = false, dataProvider = "validBoardsEasy")
    public void testBoardCreationEasy(String boardName, String boardColor) throws InterruptedException {
        //Board board = new Board().withName(boardName).withColor(boardColor);

        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();

        app.getBoard().fillBoardForm(new Board().withName(boardName).withColor(boardColor));
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
        Thread.sleep(2000);
    }


    @DataProvider
    public Iterator<Object[]> validBoards() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new Board().withName(split[0]).withColor(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(enabled = false, dataProvider = "validBoards")
    public void testBoardCreation(Board board) throws InterruptedException {
        int before = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreation();

        app.getBoard().fillBoardForm(board);
        app.getBoard().confirmBoardCreation();
        app.getBoard().returnToHomePage();

        int after = app.getBoard().getBoardsCount();
        Assert.assertEquals(after, before + 1);
        System.out.println("was: " + before + " now: " + after);
        Thread.sleep(2000);
    }
}
