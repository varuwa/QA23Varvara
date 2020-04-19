package com.qa.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(getBoardsCount()==0){
            createBoard();
        }
    }

    @Test
    public void testChangeNameOfBoard(){
        openFirstPersonalBoard();
        initNameChange();
        returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToPhotos(){
        openFirstPersonalBoard();
        initChangeBackgroundToPhotos();
        clickOnFirstPhoto();
        returnToHomePage();
    }

    @Test
    public void testChangeBackgroundToColors(){
        openFirstPersonalBoard();
        initChangeBackgroundToColor();
        clickOnChosenColor("[style='background-color: rgb(137, 96, 158);']");
        returnToHomePage();
    }

    @Test
    public void testAddList() {
        openFirstPersonalBoard();
        clickOnAddListButton();
        putNameOfList("NewList");
        clickOnConfirmButton();
        returnToHomePage();
    }

    @Test
    public void testListDeletion(){
        openFirstPersonalBoard();
        initListDeletion();
        returnToHomePage();
    }

}
