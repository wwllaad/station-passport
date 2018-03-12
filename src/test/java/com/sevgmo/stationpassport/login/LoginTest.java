package com.sevgmo.stationpassport.login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    @Test
    public void userLogin() {
        File file = new File("C:/chromedriver_win32/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/login");

        WebElement loginField = driver.findElement(By.name("username"));
        loginField.sendKeys("Vlad");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("root");
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();
        WebElement label = driver.findElement(By.className("navbar-header"));
        String testMessage = label.getText();
        Assert.assertEquals("Метеостанции Крыма", testMessage);
        driver.quit();
    }
}



