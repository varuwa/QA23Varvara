package com.qa.trello.tests;

import com.qa.trello.framework.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();
    // делегирование, вместо наследования, обращение через ссылку "app.", удалить final

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
