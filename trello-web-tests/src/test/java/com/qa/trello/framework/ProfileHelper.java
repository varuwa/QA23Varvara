package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase{

    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnAvatar() {
        click(By.cssSelector("[data-test-id=header-member-menu-button]"));
    }
    public void selectProfileAndVisibility() {
        click(By.cssSelector("[data-test-id=header-member-menu-profile]"));
    }

    public void initChangeProfilePhoto() {
        WebElement avatar = wd.findElement(By.cssSelector("._2e97X7K2YRLv4Q"));
        new Actions(wd).moveToElement(avatar).perform();
        click(By.cssSelector("._2e97X7K2YRLv4Q"));
    }

//    public void initChangeProfilePhoto() {
//        click(By.cssSelector("button._2e97X7K2YRLv4Q"));
//
//
//    }

    public void attachFile (By locator, File file){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void uploadPhoto() {
        attachFile(By.cssSelector("._34zIcoaCeL1FsG"), new File("C:\\Users\\varuw\\Documents\\GitHub\\QA23Varvara\\trello-web-tests\\src\\test\\resources\\cat_small.png"));

    }

    public void confirmChangeProfile() {
        click(By.cssSelector("[class='_3fzn1d4Uk--rxc _12CX3u0AWDQ5EI']"));
    }

    //Atlassian
    public void goToAtlassianProfile(){
        String trello = wd.getWindowHandle();
        System.out.println(trello);
        click(By.cssSelector("a[href$=manage-profile]"));

        List<String> availableWindows = new ArrayList<>(wd.getWindowHandles());
        if(!availableWindows.isEmpty()){
            wd.switchTo().window(availableWindows.get(1));
        }
        String atlassianAcc = wd.getWindowHandle();
        System.out.println(atlassianAcc);

    }

}
