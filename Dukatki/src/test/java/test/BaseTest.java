package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import po.BasePage;
import po.NavigationBar;

import java.util.List;

public class BaseTest {
    private WebDriver driver;
    //Michalek69
    //dupa123
    @Before
    public void loginToShop(){
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://dukatki.pl/");
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.openLoginPage()
                .successfulLogin("tmjpbwtpcxwkkscieq@tmmcv.net", "dupa123");
    }

    @After
    public void logoutFromShop(){
        NavigationBar navigationBar = new NavigationBar(driver);
        navigationBar.logout();
        driver.quit();
    }





}
