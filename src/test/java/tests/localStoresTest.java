package tests;


import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;



public class localStoresTest {

    WebDriver driver = new FirefoxDriver();

    private final String mainPage = "https://rozetka.com.ua/";

    @Test
    public void testStoresKharkov() throws InterruptedException {


        String testCity = "Харьков";
        driver.manage().window().maximize();
        driver.get(mainPage);
        Thread.sleep(20000);

        WebElement element_1 = driver.findElement(By.xpath("//button[@class='button--link header-cities__label']"));
        element_1.click();
        List<WebElement> popularCitiesList = driver.findElements(By.xpath("//ul[@class='header-location__popular']/li"));
        for (WebElement webElement : popularCitiesList) {
            String cityValue = webElement.getText();
            System.out.println(cityValue);
            if (cityValue.contains(testCity)) {
                webElement.click();
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
    @Test
    public void testStoresKiev() throws InterruptedException {

        String testCity = "Кие";
        driver.manage().window().maximize();
        driver.get(mainPage);
        Thread.sleep(2000);

        WebElement element_1 = driver.findElement(By.xpath("//button[@class='button--link header-cities__label']"));
        element_1.click();
        Thread.sleep(10000);
        /*List<WebElement> popularCitiesList = driver.findElements(By.xpath("//ul[@class='header-location__popular']/li"));
        for (WebElement webElement : popularCitiesList) {
            String cityValue = webElement.getText();
            if (cityValue.contains(testCity)) {
                System.out.println(cityValue);
                webElement.click();
                Thread.sleep(5000);
                break;
            }

        }*/
        /*WebElement inputCityField = driver.findElement(By.xpath("//input[@class='autocomplete__input ng-untouched ng-pristine ng-valid']"));
        inputCityField.click();


        inputCityField.clear();
        Thread.sleep(1000);
        inputCityField.sendKeys("К");
        Thread.sleep(10000);
        inputCityField.sendKeys("и");
        Thread.sleep(10000);
        inputCityField.sendKeys("е");
        Thread.sleep(10000);*/

        WebElement element = driver.findElement(By.xpath("//input[@class='autocomplete__input ng-untouched ng-pristine ng-valid']"));
        Actions navigator = new Actions(driver);
        navigator.click(element)
                .sendKeys(Keys.END)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.HOME)
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("К")
                .sendKeys("и")
                .sendKeys("е")
                .perform();
        Thread.sleep(10000);
        //WebElement a = driver.findElement(By.xpath("//li[@class='autocomplete__item dialog_list'"));
        List<WebElement> wel = driver.findElements(By.xpath("//li[@class='autocomplete__item dialog_list']"));
        for(WebElement webElement : wel) {
            String str = webElement.getText();
            System.out.println(str);
        }

        Thread.sleep(2000);

        WebElement buttonApply = driver.findElement(By.xpath("//button[@class='button button_size_medium button_color_green']"));
        buttonApply.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        WebElement add = driver.findElement(By.xpath("//ul/li[@class='main-addresses__item']"));
        //Thread.sleep(5000);
        List<WebElement> addreses = driver.findElements(By.xpath("//ul/li[@class='main-addresses__item']"));
        for (WebElement webElement : addreses) {
            String store = webElement.getText();
            System.out.println(store);
        }
driver.quit();
    }

}
