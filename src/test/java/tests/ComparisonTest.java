package tests;

import Pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ComparisonTest {
    private final String mainPage = "https://rozetka.com.ua/";
    WebDriver driver = new ChromeDriver();

    @Test
    public void compareTwoProductsFromMonitors(){
        driver.manage().window().maximize();
        driver.get(mainPage);
        String categorie = "Мониторы";
        MainPage.selectProductCategorie(categorie);

    }















}
