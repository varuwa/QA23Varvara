package com.qa.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if(getBoardsCount()==0){
            createBoard();
        }
    }

    @Test
    public void testBoardDeletion(){
        int before = getBoardsCount();
        openFirstPersonalBoard();
        clickMoreButton();
        initBoardDeletion();
        PermanentlyDeleteBoard();
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before-1); //проверка, что актуальное соотвествует полученному минус 1
        System.out.println("was: "+ before + " now: " + after);
    }


}
