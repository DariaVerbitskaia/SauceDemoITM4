package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage extends BasePage {

    private static final By ADD_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private static final By ADD_BUTTON_ITEM_PAGE = By.id("add-to-cart");
    private static final By REMOVE_BUTTON_ITEM_PAGE = By.id("remove");
    private static final By BUTTON_BACK_TO_PRODUCTS = By.name("back-to-products");
    private static final By TITLE = By.className("title");
    private static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    private static final By ITEM_CART = By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL +"inventory.html");
    }

    @Step("Получение Заголовка с открывшейся страницы с продуктами")
    public boolean isPageOpened() {
        return driver.findElement(TITLE).isDisplayed();
    }


    @Step("Добавление товара в корзину со страницы товаров")
    public boolean addToCart() {
        driver.findElement(ADD_BUTTON).click();
        return !driver.findElements(CART_BADGE).isEmpty();
    }

    @Step("Удаление товара из корзины со страницы товаров")
    public boolean removeFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
        return driver.findElements(CART_BADGE).isEmpty();
    }

    @Step("Добавление товара в корзину с карточки товара")
    public boolean addToCartFromItemPage() {
        driver.findElement(ADD_BUTTON_ITEM_PAGE).click();
        return !driver.findElements(CART_BADGE).isEmpty();
    }

    @Step("Удаление товара из корзины с карточки товара")
    public boolean removeFromCartFromItemPage() {
        driver.findElement(REMOVE_BUTTON_ITEM_PAGE).click();
        return driver.findElements(CART_BADGE).isEmpty();
    }

    @Step("Открытие карточки товара")
    public void openItemCart() {
        driver.findElement(ITEM_CART).click();
    }

    @Step("Переход на страницу товаров из корзины")
    public void returnFromItemPageToProductsPage() {
        driver.findElement(BUTTON_BACK_TO_PRODUCTS).click();
    }
    @Step("Получение текста Заголовка")
    public String getPageTitle() {
        return driver.findElement(TITLE).getText();
    }
}