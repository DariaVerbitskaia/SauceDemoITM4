package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Проверка входа в систему без пароля", testName = "Негативный тест логина без пароля", groups = {"smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Pge")
    @Feature("Login")
    @Story("Login without password")
    @TmsLink("ITM-1")
    @Issue("ITM-1-4")
    @Description("Пользователь не может войти на сайт,если поле пароль не заполнено. Пользователь получает уведомление об ошибке.")
    public void checkLoginWithoutPassword() {
        loginPage.open()
                 .login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке");
    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Login")
    @Story("Login without Username")
    @TmsLink("ITM-2")
    @Issue("ITM-2-4")
    @Description("Пользователь не может войти на сайт,если поле Имя не заполнено. Пользователь получает уведомление об ошибке.")
    public void checkLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required1",
                "Сообщение об ошибке");
    }


    @DataProvider (name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user","","Epic sadface: Password is required"},
                {"","secret_sauce","Epic sadface: Username is required"},
                {"test","test","Epic sadface: Username and password do not match any user in this service"},
        };
    }

    @Test (dataProvider = "loginData")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Page")
    @Feature("Login")
    @Story("Login with Negative value")
    @TmsLink("ITM-3")
    @Issue("ITM-3-4")
    @Description("Пользователь не может войти на сайт,если поле пароль и имя заполнено некорректными данными. Пользователь получает уведомление об ошибке.")
    public void checkLoginWithNegativeValue(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение об ошибке");
    }

    @Test(priority = 2, description = "Проверка успешного входа", testName = "Позитивный тест входа на сайт", groups = {"smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Daria V.")
    @Link("https://www.saucedemo.com/")
    @Epic("Login Pge")
    @Feature("Login")
    @Story("Success Login")
    @TmsLink("ITM-4")
    @Issue("ITM-4-4")
    @Description("Успешный вход пользователя на сайт.")
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }
}