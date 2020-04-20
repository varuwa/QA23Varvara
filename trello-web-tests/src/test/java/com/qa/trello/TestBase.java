package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        init();
    }



    @AfterMethod
    public void tearDown() {
        stop();
    }

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.navigate().to("https://trello.com/");
        login("varuwa@gmail.com", "trellobarbara");
    }

    public void stop() {
        wd.quit();
    }


    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToHomePage() {
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
        click(By.cssSelector("[class='_2BQG4yPMt5s_hu _2hgn5meZL7bJdx _1ctYJ9-gOV_hrm _3Xj1tqB73NcWn3']"));
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0; //тру или фолс, элемент есть или нет
    }

    //Login
    public void login(String userEmail, String password) {
        initLogin();
        fillLoginForm(userEmail, password);
        confirmLogin();
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void confirm() {
        click(By.cssSelector(".js-confirm"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size() - 1;
        //получает количество досок, минус один, так как последняя не доска
    }

    public int getTeamsCount() {
        return wd.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public boolean isOnBoardsPage() {
        String url = wd.getCurrentUrl();
        return url.contains("boards"); //url содержит boards
    }

    //TeamCreation
    public void initTeamCreation() {
        click(By.cssSelector("[class='icon-add icon-sm _2aV_KY1gTq1qWc']"));
    }

    public void fillForm(String nameOfTeam) {
        type(By.cssSelector("[class='_1CLyNodCAa-vQi']"), nameOfTeam);
        click(By.id("teamTypeSelect"));
        click(By.cssSelector("[class='_38pq5NbRWAG39y']")); //"[data-test-id^=header-create-team-type-input] li"
    }

    public void confirmTeamCreation() {
        click(By.cssSelector("[type='submit']"));
        click(By.cssSelector("[class='eg0KI5SqghoOFd']"));
    }

    public void inviteTeamLater() {
        if (isElementPresent(By.cssSelector("[data-test-id=show-later-button]"))) { //если тру кликни
            click(By.cssSelector("[data-test-id=show-later-button]"));
        }
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

    //Team Deletion
    public void openFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

    public void clickOnSettings() {
        click(By.cssSelector(".icon-gear"));
    }

    public void initTeamDeletion() {
        click(By.cssSelector(".quiet-button"));
        confirm();
    }

    //testChangeBackgroundToPhotos
    public void initChangeBackgroundToPhotos() {
        click(By.cssSelector(".js-change-background"));
        click(By.cssSelector(".js-bg-photos"));
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
    public void initListDeletion() {
        click(By.cssSelector(".js-open-list-menu"));
        click(By.cssSelector(".js-close-list"));
    }

    //testChangeNameOfBoard
    public void initNameChange() {
        wd.findElement(By.cssSelector(".js-rename-board")).click();
        wd.findElement(By.cssSelector("input.js-board-name-input")).sendKeys("NewName" + Keys.ENTER); //нажать энтер
    }

    //testChangeNameOfTeam
    public void confirmNameChange() {
        click(By.cssSelector("[type='submit']"));
    }

    public void changeNameOfTeam() {
        type(By.cssSelector("[id='displayName']"), "NewTeamName");
    }

    public void editTeamProfile() {
        click(By.cssSelector("[name='edit']"));
    }

    public void openSettings() {
        click(By.cssSelector(".icon-gear"));
    }


    public void createBoard() {
        initBoardCreation();
        fillBoardForm("TestNewBoard");
        confirmBoardCreation();
        returnToHomePage();
    }

    public void createTeam() throws InterruptedException {
        initTeamCreation();
        fillForm("TestNewTeam");
        confirmTeamCreation();
        Thread.sleep(3000);
        returnToHomePage();
    }
}
