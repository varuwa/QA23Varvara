package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
//        if(isOnBoardsPage()){
//            click(By.cssSelector("[href$=boards]"));
//        }
        if (app.getBoardsCount() == 0) {
            app.createBoard();
        }
    }

    @Test
    public void testChangeNameOfBoard() {
        app.openFirstPersonalBoard();
        app.initNameChange();
        app.returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToPhotos() {
        app.openFirstPersonalBoard();
        app.initChangeBackgroundToPhotos();
        app.clickOnFirstPhoto();
        app.returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToColors() {
        app.openFirstPersonalBoard();
        app.initChangeBackgroundToColor();
        app.clickOnChosenColor("[style='background-color: rgb(137, 96, 158);']");
        app.returnToHomePage();
    }

    @Test
    public void testAddList() {
        app.openFirstPersonalBoard();
        app.clickOnAddListButton();
        app.putNameOfList("NewList");
        app.clickOnConfirmButton();
        app.returnToHomePage();
    }

    @Test
    public void testListDeletion() {
        app.openFirstPersonalBoard();
        app.initListDeletion();
        app.returnToHomePage();
    }

}
