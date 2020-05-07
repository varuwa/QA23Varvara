package com.qa.trello.tests;

import org.testng.annotations.Test;

public class ProfileModificationTests extends TestBase {

    @Test
    public void testChangeProfileAvatar() throws InterruptedException {
        app.getProfile().clickOnAvatar();
        app.getProfile().selectProfileAndVisibility();
        Thread.sleep(3000);
        app.getProfile().initChangeProfilePhoto();
        app.getProfile().uploadPhoto();
        Thread.sleep(3000);
        app.getProfile().confirmChangeProfile();
    }



}
