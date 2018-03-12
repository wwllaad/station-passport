package com.sevgmo.stationpassport.login;

import com.sevgmo.stationpassport.pagefactory.SevgmoHomePage;
import com.sevgmo.stationpassport.pagefactory.SevgmoLoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("FieldCanBeLocal")
public class LoginTest {

    private WebDriver driver;
    private SevgmoLoginPage sevgmoLoginPage;
    private SevgmoHomePage sevgmoHomePage;

    private static final String URL = "http://localhost:8080/login";
    private static final String CHROME_DRIVER_PATH ="C:/chromedriver_win32/chromedriver.exe";

    @Before
    public void setup(){
        File file = new File(CHROME_DRIVER_PATH);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testSevgmoLogin(){
        sevgmoLoginPage = new SevgmoLoginPage(driver);
        sevgmoLoginPage.loginToSevgmo("Vlad", "root");
        sevgmoHomePage = new SevgmoHomePage(driver);
        Assert.assertTrue(sevgmoHomePage.getNavbarHeader().toLowerCase().equals("метеостанции крыма"));
    }

    @After
    public void close(){
        driver.quit();
    }
}



