package com.sevgmo.stationpassport.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SevgmoHomePage {

    private WebDriver driver;

    @FindBy(className="navbar-header")
    private WebElement navbarHeaderSevgmo;

    public SevgmoHomePage(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public String getNavbarHeader(){
        return navbarHeaderSevgmo.getText();
    }
}
