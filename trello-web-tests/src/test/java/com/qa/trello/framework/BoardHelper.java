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
            click(By.cssSelector(".js-show-sidebar"));
        }
    }

    public void closeBoardMenu(){
        click(By.cssSelector(".js-hide-sidebar"));
    }

    //Board Creation
    public void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }
    public void fillBoardForm(String nameOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        click(By.cssSelector("._1vk4y48RR5OmqE"));
        click(By.cssSelector("._1uK2vQ_aMRS2NU")); // //li[1]/button[@class='_2jR0BZMM5cBReR']
    }
    public void confirmBoardCreation() {
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    //Board Deletion
    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }
    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }
    public void initBoardDeletion() {
        clickOnCloseBoardInMoreMenu();
        confirm();
    }
    public void clickOnCloseBoardInMoreMenu() {
        click(By.cssSelector(".js-close-board"));
    }
    public void PermanentlyDeleteBoard() {
        click(By.cssSelector(".js-delete"));
        confirm();
    }

    //testChangeBackgroundToPhotos
    public void initChangeBackgroundToPhotos() {
        click(By.cssSelector(".js-change-background"));
        click(By.cssSelector("[class='board-backgrounds-section-tile board-backgrounds-photos-tile js-bg-photos']"));
    }
    public void clickOnFirstPhoto() {
        click(By.cssSelector(".background-box"));
    }

    //testChangeBackgroundToColors
    public void initChangeBackgroundToColor() {
        click(By.cssSelector(".js-change-background"));
        click(By.cssSelector(".js-bg-colors"));
    }
    public void clickOnChosenColor(String chosenColor) {
        click(By.cssSelector(chosenColor));
    }

    //testChangeNameOfBoard
    public void initNameChange() {
        wd.findElement(By.cssSelector(".js-rename-board")).click();
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("NewName" + Keys.ENTER); //нажать энтер
    }

    //testAddList
    public void clickOnAddListButton() {
        click(By.cssSelector(".placeholder"));
    }
    public void putNameOfList(String nameOfList) {
        type(By.cssSelector(".list-name-input"), nameOfList);
    }
    public void clickOnConfirmButton() {
        click(By.cssSelector(".js-save-edit"));
    }

    //testListDeletion
    public void isListPresent() throws InterruptedException {
        if(!isElementPresent(By.cssSelector(".js-list-content"))){
            clickOnAddListButton();
            putNameOfList("NewList");
            clickOnConfirmButton();;
        }
        Thread.sleep(2000);
    }
    public void initListDeletion() {
        click(By.cssSelector(".js-open-list-menu"));
        click(By.cssSelector(".js-close-list"));
    }


    public void createBoard() {
        initBoardCreation();
        fillBoardForm("TestNewBoard");
        confirmBoardCreation();
        returnToHomePage();
    }

}
