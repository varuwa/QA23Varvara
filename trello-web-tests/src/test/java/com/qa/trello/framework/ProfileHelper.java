package com.qa.trello.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void confirmChangeProfile() {
        click(By.cssSelector("[class='_3fzn1d4Uk--rxc _12CX3u0AWDQ5EI']"));
    }
}
