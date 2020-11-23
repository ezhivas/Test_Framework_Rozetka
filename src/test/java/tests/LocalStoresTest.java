package tests;

import Pages.MainPage;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class LocalStoresTest {

    private final String mainPage = "https://rozetka.com.ua/";
    WebDriver driver = new ChromeDriver();


    @Test
    public void testStoresKiev() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(mainPage);
        Thread.sleep(20000);
        String testCity = "Киев";


        MainPage.cityButtonClick();
        MainPage.clickSomeCity(testCity);
        MainPage.clickApplyCity();
        MainPage.getStoresList();

    }
    @Test
    public void testStoresKharkov() throws InterruptedException {

        String testCity = "Харьков";
        driver.manage().window().maximize();
        driver.get(mainPage);
        Thread.sleep(20000);

        WebElement element_1 = driver.findElement(By.xpath("//button[@class='button--link header-cities__label']"));
        element_1.click();
        List<WebElement> popularCitiesList = driver.findElements(By.xpath("//ul[@class='header-location__popular']/li/a"));
        for (WebElement webElement : popularCitiesList) {
            String cityValue = webElement.getText();
            if (cityValue.contains(testCity)) {
                webElement.click();
                Thread.sleep(5000);
                break;
            }
        }
        WebElement buttonApply = driver.findElement(By.xpath("//button[@class='button button_size_medium button_color_green']"));
        buttonApply.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement add = driver.findElement(By.xpath("//ul/li[@class='main-addresses__item']"));
        Thread.sleep(5000);
        List<WebElement> addreses = driver.findElements(By.xpath("//ul/li[@class='main-addresses__item']"));
        for (WebElement webElement : addreses) {
            String store = webElement.getText();
            System.out.println(store);
        }
        driver.quit();
    }

}
