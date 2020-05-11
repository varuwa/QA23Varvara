package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
        if(!app.getBoard().isOnBoardsPage()){
            app.getBoard().goToBoardsPageUrl("varuwa");
        }
    }

    @Test
    public void testChangeBackgroundToColors() throws InterruptedException {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().openMenu();
        app.getBoard().initChangeBackgroundToColor();
        app.getBoard().clickOnChosenColor("[style='background-color: rgb(137, 96, 158);']");
        app.getBoard().closeBoardMenu();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testChangeNameOfBoard() throws InterruptedException {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().initNameChange();
        app.getBoard().returnToHomePage();
    }

    @Test(enabled = false)
    public void testAddList() throws InterruptedException {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickOnAddListButton();
        app.getBoard().putNameOfList("NewList");
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testListDeletion() throws InterruptedException {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().isListPresent();
        app.getBoard().initListDeletion();
        app.getBoard().returnToHomePage();
    }
}
