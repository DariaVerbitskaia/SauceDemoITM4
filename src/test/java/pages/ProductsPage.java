package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ProductsPage extends BasePage {

    private final By ADD_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private final By ADD_BUTTON_ITEM_PAGE = By.id("add-to-cart");
    private final By REMOVE_BUTTON_ITEM_PAGE = By.id("remove");
    private final By BUTTON_BACK_TO_PRODUCTS = By.name("back-to-products");
    private final By TITLE = By.className("title");
    private final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    private final By ITEM_CART = By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL +"inventory.html");
    }

    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }

    public boolean addToCart() {
        driver.findElement(ADD_BUTTON).click();
        return !driver.findElements(CART_BADGE).isEmpty();
    }

    public boolean removeFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
        return driver.findElements(CART_BADGE).isEmpty();
    }

    public boolean addToCartFromItemPage() {
        driver.findElement(ADD_BUTTON_ITEM_PAGE).click();
        return !driver.findElements(CART_BADGE).isEmpty();
    }

    public boolean removeFromCartFromItemPage() {
        driver.findElement(REMOVE_BUTTON_ITEM_PAGE).click();
        return driver.findElements(CART_BADGE).isEmpty();
    }

    public void openItemCart() {
        driver.findElement(ITEM_CART).click();
    }

    public void returnFromItemPageToProductsPage() {
        driver.findElement(BUTTON_BACK_TO_PRODUCTS).click();
    }
}