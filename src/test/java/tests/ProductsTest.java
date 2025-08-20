package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPage;

public class ProductsTest extends BaseTest{

    @Test(priority = 1, description = "Проверка добавления товара в корзину со страницы товаров", testName = "Добавление в корзину", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Add to cart")
    @TmsLink("ITM-5")
    @Issue("ITM-5-4")
    @Description("Пользователь может добавить товар в корзину со страницы товаров.")
    public void checkItemAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.addToCart();
    }

    @Test(priority = 2, description = "Проверка удаления товара из корзины со страницы товаров", testName = "Удалени из корзины", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Remove from cart")
    @TmsLink("ITM-6")
    @Issue("ITM-6-4")
    @Description("Пользователь может удалить товар из корзины со страницы товаров не переходя в саму корзину.")
    public void checkItemRemoveFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.addToCart();
        productsPage.removeFromCart();
    }

    @Test(priority = 3, description = "Проверка добавления товара в корзину с карточки товара", testName = "Добавление в корзину", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Add to cart")
    @TmsLink("ITM-7")
    @Issue("ITM-7-5")
    @Description("Пользователь может добавить товар в корзину с карточки товара.")
    public void checkItemAddToCartFromItemPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.addToCartFromItemPage();
    }

    @Test(priority = 4, description = "Проверка удаления товара из корзины с карточки товара", testName = "Удаление из корзины", groups = {"smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Remove from cart")
    @TmsLink("ITM-8")
    @Issue("ITM-8-5")
    @Description("Пользователь может удалить товар из корзины с карточки товара не переходя в саму корзину.")
    public void checkItemRemoveFromCartFromItemPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.addToCartFromItemPage();
        productsPage.removeFromCartFromItemPage();
    }

    @Test(priority = 5, description = "Проверка перехода между страницами", testName = "Навигация на сайте", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Remove from cart")
    @TmsLink("ITM-8")
    @Issue("ITM-8-5")
    @Description("Пользователь может переходить между страницей товаров и карточкой продукта.")
    public void checkNavigationBetweenItemAndProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.returnFromItemPageToProductsPage();
        productsPage.isPageOpened();
    }

    @Test(priority = 6, description = "Проверка заголовка на страницы", testName = "Соответствие заголовка", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/inventory.html")
    @Epic("Product Page")
    @Feature("Products")
    @Story("Context")
    @TmsLink("ITM-9")
    @Issue("ITM-9-4")
    @Description("Проверка прогрузки контента.")
    public void checkTitleOnProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        String actualTitle = productsPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Products", "Заголовок страницы некорректный");
    }
}