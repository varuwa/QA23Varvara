package com.qa.trello.framework;

import com.qa.trello.model.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardHelper extends HelperBase {

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        //получает количество досок, минус один, так как последняя не доска
    }

    public void openMenu() {
        if (isElementPresent(By.cssSelector("[class='board-menu js-fill-board-menu hide']"))) {
            waitForElementLocatedAndClick(By.cssSelector(".js-show-sidebar"), 20);
        }
    }

    public void closeBoardMenu() {
        waitForElementLocatedAndClick(By.cssSelector(".js-hide-sidebar"), 20);
    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards");
    }

    public void goToBoardsPageUrl(String username) {
        wd.navigate().to("https://trello.com/" + username + "/boards");
    }

    //Board Creation
    public void initBoardCreation() {
        waitForElementLocatedAndClick(By.name("add"), 20);
        waitForElementLocatedAndClick(By.cssSelector("[data-test-id='header-create-board-button']"), 20);
    }

    public void fillBoardForm(Board board) {
        typeBoardName(board.getName());
        selectTeamFromBoardCreationForm(board.getTeam());
        //waitForElementLocatedAndClick(By.cssSelector("._1vk4y48RR5OmqE"), 20); //по умолчанию группа
        //waitForElementLocatedAndClick(By.cssSelector("._1uK2vQ_aMRS2NU"), 20); // //li[1]/button[@class='_2jR0BZMM5cBReR']
        selectColorFromBoardCreationForm(board.getColor());
    }

    private void selectColorFromBoardCreationForm(String color) {
        if (color != null) {
            click(By.cssSelector("[title='" + color + "']"));
        }
    }

    private void typeBoardName(String nameOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
    }

    private void selectTeamFromBoardCreationForm(String team) {
        if (team != null) {
            click(By.cssSelector("button.W6rMLOx8U0MrPx"));
            click(By.xpath("//span[contains(text(), '" + team + "')]"));
        }
    }

    public void confirmBoardCreation() throws InterruptedException {
        waitForElementLocatedAndClick(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"), 20);
        Thread.sleep(3000);
    }

    //Board Deletion
    public void openFirstPersonalBoard() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void clickMoreButton() {
        WebElement moreButton = new WebDriverWait(wd, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".js-open-more")));
        if (!moreButton.isDisplayed()) {
            wd.findElement(By.cssSelector(".board-header-btn.mod-show-menu.js-show-sidebar")).click();
        }
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
        click(By.xpath("//*[@class='open-add-list js-open-add-list']//../span"));
    }

    public void putNameOfList(String nameOfList) {
        wd.findElement(By.cssSelector(".list-name-input")).sendKeys(nameOfList + Keys.ENTER);
    }

    //testListDeletion
    public void isListPresent() {
        if (!isElementPresent(By.cssSelector(".js-list-content"))) {
            clickOnAddListButton();
            putNameOfList("NewList");
        }
    }

    public void initListDeletion() {
        click(By.cssSelector(".list-header-extras-menu"));
        click(By.cssSelector(".js-close-list"));
    }


    public void createBoard() throws InterruptedException {
        initBoardCreation();
        fillBoardForm(new Board().withName("TestNewBoard").withColor("orange"));
        confirmBoardCreation();
        returnToHomePage();
    }

    public List<Board> getBoardsList() {
        List<Board> boards = new ArrayList<>();

        List<WebElement> elements = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
        for (WebElement element : elements) {
            String name = element.getText();
            System.out.println(name);
            boards.add(new Board().withName(name));
        }
        return boards;
    }

    public Set<Board> getBoardsSet() {
        Set<Board> boards = new HashSet<>();

        List<WebElement> elements = wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
        for (WebElement element : elements) {
            String name = element.getText();
            System.out.println(name);
            Board board = new Board().withName(name);
            boards.add(board);
        }
        return boards;
    }

    public void deleteBoard() throws InterruptedException {
        clickMoreButton();
        initBoardDeletion();
        PermanentlyDeleteBoard();
        returnToHomePage();
    }

    //  public void test() {
//    //go to needed page
//    List<WebElement> cards = wd.findElements(By.cssSelector("      "));
//    for (WebElement card : cards) {
//      WebElement button = wd.findElement(By.cssSelector("      "));
//      button.click();
//      wd.navigate().back();
//
//    }
//  }

}
