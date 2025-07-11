package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest{

    @Test
    public void checkItemAddToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.addToCart();
    }

    @Test
    public void checkItemRemoveFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.addToCart();
        productsPage.removeFromCart();
    }

    @Test
    public void checkItemAddToCartFromItemPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.addToCartFromItemPage();
    }

    @Test
    public void checkItemRemoveFromCartFromItemPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.addToCartFromItemPage();
        productsPage.removeFromCartFromItemPage();
    }

    @Test
    public void checkNavigationBetweenItemAndProducts() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.isPageOpened();
        productsPage.openItemCart();
        productsPage.returnFromItemPageToProductsPage();
        productsPage.isPageOpened();
    }
}
