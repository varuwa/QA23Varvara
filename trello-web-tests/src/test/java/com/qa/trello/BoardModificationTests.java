package com.qa.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
//        if(isOnBoardsPage()){
//            click(By.cssSelector("[href$=boards]"));
//        }
        if (app.getBoard().getBoardsCount() == 0) {
            app.getBoard().createBoard();
        }
    }

    @Test
    public void testChangeNameOfBoard() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().initNameChange();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToPhotos() {
        app.getBoard().openFirstPersonalBoard();
        boardMenuIsOpen();
        app.getBoard().isElementPresent();
        app.getBoard().initChangeBackgroundToPhotos();
        app.getBoard().clickOnFirstPhoto();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToColors() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().initChangeBackgroundToColor();
        app.getBoard().clickOnChosenColor("[style='background-color: rgb(137, 96, 158);']");
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testAddList() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().clickOnAddListButton();
        app.getBoard().putNameOfList("NewList");
        app.getBoard().clickOnConfirmButton();
        app.getBoard().returnToHomePage();
    }

    @Test
    public void testListDeletion() {
        app.getBoard().openFirstPersonalBoard();
        app.getBoard().initListDeletion();
        app.getBoard().returnToHomePage();
    }



}
