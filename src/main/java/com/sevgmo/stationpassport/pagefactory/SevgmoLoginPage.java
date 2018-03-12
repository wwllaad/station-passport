package com.sevgmo.stationpassport.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SevgmoLoginPage {

    private WebDriver driver;

    @FindBy(name="username")
    private WebElement usernameSevgmo;

    @FindBy(name="password")
    private WebElement passwordSevgmo;

    @FindBy(name="submit")
    private WebElement submitButton;

    public SevgmoLoginPage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    private void setUsername(String username){
       usernameSevgmo.sendKeys(username);
    }

    private void setPassword(String password){
        passwordSevgmo.sendKeys(password);
    }

    private void clickLogin(){
        submitButton.click();
    }

    public void loginToSevgmo(String username,String password){
        this.setUsername(username);
        this.setPassword(password);
        this.clickLogin();
    }
}
