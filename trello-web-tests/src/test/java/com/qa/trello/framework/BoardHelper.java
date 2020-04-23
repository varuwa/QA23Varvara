package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        //получает количество досок, минус один, так как последняя не доска
    }
    public void openMenu(){
        if(isElementPresent(By.cssSelector("[class='board-menu js-fill-board-menu hide']"))){
            waitForElementLocatedAndClick(By.cssSelector(".js-show-sidebar"), 20);
        }
    }

    public void closeBoardMenu(){
        waitForElementLocatedAndClick(By.cssSelector(".js-hide-sidebar"), 20);
    }

    //Board Creation
    public void initBoardCreation() {
        waitForElementLocatedAndClick(By.name("add"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-board-button']"), 20);
    }
    public void fillBoardForm(String nameOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        waitForElementLocatedAndClick(By.cssSelector("._1vk4y48RR5OmqE"), 20);
        waitForElementLocatedAndClick(By.cssSelector("._1uK2vQ_aMRS2NU"), 20); // //li[1]/button[@class='_2jR0BZMM5cBReR']
    }
    public void confirmBoardCreation() {
        waitForElementLocatedAndClick(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"), 20);
    }

    //Board Deletion
    public void openFirstPersonalBoard() {
        waitForElementClickableAndClick(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"), 40);
    }
    public void clickMoreButton() {
        waitForElementLocatedAndClick(By.cssSelector(".js-open-more"), 30);
    }
    public void initBoardDeletion() {
        clickOnCloseBoardInMoreMenu();
        confirm();
    }
    public void clickOnCloseBoardInMoreMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".js-close-board"), 20);
    }
    public void PermanentlyDeleteBoard() {
        waitForElementLocatedAndClick(By.cssSelector(".js-delete"), 20);
        confirm();
    }

    //testChangeBackgroundToPhotos
    public void initChangeBackgroundToPhotos() {
        waitForElementLocatedAndClick(By.cssSelector(".js-change-background"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[class='board-backgrounds-section-tile board-backgrounds-photos-tile js-bg-photos']"), 20);
    }
    public void clickOnFirstPhoto() {
        waitForElementClickableAndClick(By.cssSelector(".background-box"), 20);
    }

    //testChangeBackgroundToColors
    public void initChangeBackgroundToColor() {
        waitForElementLocatedAndClick(By.cssSelector(".js-change-background"), 20);
        waitForElementLocatedAndClick(By.cssSelector(".js-bg-colors"), 20);
    }
    public void clickOnChosenColor(String chosenColor) {
        waitForElementLocatedAndClick(By.cssSelector(chosenColor), 20);
    }

    //testChangeNameOfBoard
    public void initNameChange() {
        wd.findElement(By.cssSelector(".js-rename-board")).click();
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("NewName" + Keys.ENTER); //нажать энтер
    }

    //testAddList
    public void clickOnAddListButton() {
        waitForElementLocatedAndClick(By.cssSelector(".placeholder"), 20);
    }
    public void putNameOfList(String nameOfList) {
        type(By.cssSelector(".list-name-input"), nameOfList);
    }
    public void clickOnConfirmButton() {
        waitForElementLocatedAndClick(By.cssSelector(".js-save-edit"), 20);
    }

    //testListDeletion
//    public void isListPresent(){
//        if(!isElementPresent(By.cssSelector(".js-list-content"))){
//            clickOnAddListButton();
//            putNameOfList("NewList");
//            clickOnConfirmButton();;
//        }
//    }
    public void initListDeletion() {
        waitForElementLocatedAndClick(By.cssSelector(".js-open-list-menu"), 20);
        waitForElementLocatedAndClick(By.cssSelector(".js-close-list"), 20);
    }


    public void createBoard() {
        initBoardCreation();
        fillBoardForm("TestNewBoard");
        confirmBoardCreation();
        returnToHomePage();
    }

}
