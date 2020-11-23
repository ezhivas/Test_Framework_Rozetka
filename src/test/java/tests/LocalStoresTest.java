package tests;

import org.junit.Before;
import pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocalStoresTest {

    private final String mainPageURL = "https://rozetka.com.ua/";


    @Before
    public void setUP() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
    }

    @Test
    public void testStoresKiev(){
        String testCity = "Киев";

        MainPage.getPage(mainPageURL);
        MainPage.cityButtonClick();
        MainPage.clickSomeCity(testCity);
        MainPage.clickApplyCity();
        MainPage.getStoresList();

    } @Test
    public void testStoresKharkov() {
        String testCity = "Харьков";

        MainPage.getPage(mainPageURL);
        MainPage.cityButtonClick();
        MainPage.clickSomeCity(testCity);
        MainPage.clickApplyCity();
        MainPage.getStoresList();

    }



}
