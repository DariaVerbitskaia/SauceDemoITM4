import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LocatorsTest {
    @Test
    public void test() {

        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.linkText("Sauce Labs Backpack"));
        driver.findElement(By.partialLinkText("Bike Light"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(text(), 'Fleece Jacket')]"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name ')]"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']//ancestor::div"));
        driver.findElement(By.xpath("//div[@class='inventory_item_label']//descendant::div[contains(@class, 'inventory_item_name')]"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Onesie']/following::*"));
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']/parent::div"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']/preceding::*"));
        driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Bolt T-Shirt']"));
        driver.findElement(By.cssSelector(".product_sort_container"));
        driver.findElement(By.cssSelector(".header_secondary_container .product_sort_container"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.cssSelector("div.pricebar"));
        driver.findElement(By.cssSelector("[class='pricebar']"));
        driver.findElement(By.cssSelector("[class~='btn']"));
        driver.findElement(By.cssSelector("[data-test|='inventory']"));
        driver.findElement(By.cssSelector("[name^='add']"));
        driver.findElement(By.cssSelector("[class$='description']"));
        driver.findElement(By.cssSelector("[class*='label']"));
        driver.quit();
    }
}
