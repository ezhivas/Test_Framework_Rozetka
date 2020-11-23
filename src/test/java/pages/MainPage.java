package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {

    static WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


   public static void cityButtonClick() {

        driver.findElement(By.xpath("//button[@class='button--link header-cities__label']")).click();


    }

    public static void clickSomeCity(String city) {
        List<WebElement> popularCitiesList = driver.findElements(By.xpath("//ul[@class='header-location__popular']/li/a"));
        for (WebElement webElement : popularCitiesList) {
            String cityValue = webElement.getText();
            if (cityValue.contains(city)) {
                webElement.click();
                break;
            }
        }
    }

    public static void clickApplyCity() {
        driver.findElement(By.xpath("//button[@class='button button_size_medium button_color_green']")).sendKeys(Keys.ENTER);
    }

    public static void selectProductCategorie(String categorie) {
        Actions actions = new Actions(driver);
        WebElement hiddenProductsList = driver.findElement(By.xpath("//div[@class='menu__hidden-content'"));
        actions.moveToElement(hiddenProductsList).build().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='menu__hidden-list']"));
        for (WebElement webElement : products) {
            String product = webElement.getText();
            if (product.equalsIgnoreCase(categorie)) webElement.click();
            break;
        }
    }


    public static void getStoresList() {
        WebElement add = driver.findElement(By.xpath("//ul/li[@class='main-addresses__item']"));
        List<WebElement> addreses = driver.findElements(By.xpath("//ul/li[@class='main-addresses__item']"));
        for (WebElement webElement : addreses) {
            String store = webElement.getText();
            System.out.println(store);
        }
        driver.quit();
    }

    public static void getPage(String url) {
        driver.get(url);
    }

}


// //button[@class='button--link header-cities__label'] кнопка город

// //div[@class='main-sidebar__block main-support'] поддержка

// //div[@class='main-stores'] весь блок контактов

// //div[@class='main-sidebar__block main-addresses'] адреса магазинов вот здесь город указан



