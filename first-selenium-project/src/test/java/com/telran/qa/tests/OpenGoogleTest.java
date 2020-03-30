package com.telran.qa.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenGoogleTest {
WebDriver wd;

@BeforeClass
public void setUp(){
wd = new ChromeDriver();
wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
wd.get("https://www.google.com/");
}

@Test
public void testOpenGoogle(){
    wd.findElement(By.className("gb_D")).click();
    wd.findElement(By.className("gb_D")).click();
}

@Test
public void testSearchGoogle(){
    wd.findElement(By.name("q")).click();
    wd.findElement(By.name("q")).clear();
    wd.findElement(By.name("q")).sendKeys("Java");
    
}


@AfterMethod
public void tearDown(){
wd.quit();
}
}
