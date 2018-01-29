package com.sevgmo.stationpassport.login;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/login");
    }
    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.name("username"));
        loginField.sendKeys("Vlad");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();
        WebElement testPage = driver.findElement(By.id("root"));
        String testMessage = testPage.getText();
        Assert.assertEquals("TEST", testMessage);
    }
    @AfterClass
    public static void tearDown() {
//        WebElement menuUser = driver.findElement(By.cssSelector(".login-button__menu-icon"));
//        menuUser.click();
//        WebElement logoutButton = driver.findElement(By.id("login__logout"));
//        logoutButton.click();
        driver.quit();
    }
}