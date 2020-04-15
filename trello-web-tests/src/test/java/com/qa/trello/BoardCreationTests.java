package com.qa.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BoardCreationTests {
    WebDriver wd;
    WebDriverWait wait; //класс ждать, если нужно подождать подгрузку на странице принудительно

    @BeforeMethod //аннотация
    public void setUp() { //
        wd = new ChromeDriver(); // какой браузер запусткаем
        wait = new WebDriverWait(wd,20); //инициализация класса ожидания, 20 секунд
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// сколько времени селениум будет ждать на странице припоиске элемента
        wd.manage().window().maximize();//растянуть экран на все окно
        wd.navigate().to("https://trello.com/");//открыть браузер и сайт
    }

    @Test
    public void testBoardCreation() {
        initLogin();
        fillLoginForm("varuwa@gmail.com", "trellobarbara");
        confirmLogin();
        initBoardCreation();
        fillBoardForm("Test", "[title='blue']");
        confirmBoardCreation();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.name("house"));
    }

    private void initBoardCreation() {
        click(By.name("add"));
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    private void confirmBoardCreation() {
        click(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    private void fillBoardForm(String nameOfBoard, String colorOfBoard) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"), nameOfBoard);
        click(By.cssSelector(colorOfBoard));
    }

    private void confirmLogin() {
       //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login"))); //жди жо тех пор пока элемент не появится
        click(By.id("login"));
    }

    private void fillLoginForm(String userEmail, String password) {
        type(By.name("user"), userEmail);
        type(By.name("password"), password);
    }

    private void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    @AfterMethod
    public void tearDown() { //закрывает тест
        wd.quit(); //закрыть браузер
    }
}
