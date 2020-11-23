package tests;

import org.junit.Before;
import pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ComparisonTest {
    private final String mainPage = "https://rozetka.com.ua/";
    WebDriver driver = new ChromeDriver();


    @Before
    public void setUP() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
    }


    @Test
    public void compareTwoProductsFromMonitors(){
        String categorie = "Мониторы";
        MainPage.selectProductCategorie(categorie);

    }















}
