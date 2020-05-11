package com.qa.trello.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        long beforeScreenshot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(beforeScreenshot);
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        Thread.sleep(3000);
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();
        Thread.sleep(3000);
        app.getProfile().confirmChangeProfile();

        long afterScreenshot = System.currentTimeMillis();
        app.getProfile().takeScreenshot(afterScreenshot);
        logger.info("screenshot before: screen-"+ beforeScreenshot+".png");
        logger.info("screenshot after: screen-"+ afterScreenshot+".png");

        app.getProfile().returnToHomePage();

    }



}
