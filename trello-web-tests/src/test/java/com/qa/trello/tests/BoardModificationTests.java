package com.qa.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
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
    public void testChangeBackgroundToColors() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().openMenu();
        app.getBoard().initChangeBackgroundToColor();
        app.getBoard().clickOnChosenColor("[style='background-color: rgb(137, 96, 158);']");
        app.getBoard().closeBoardMenu();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testChangeNameOfBoard() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().initNameChange();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testAddList() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickOnAddListButton();
        app.getBoard().putNameOfList("NewList");
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testListDeletion() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().isListPresent();
        app.getBoard().initListDeletion();
        app.getBoard().returnToHomePage();
    }
}
