package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Проверка входа в систему без пароля", testName = "Негативный тест логина без пароля", groups = {"smoke"})
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required1",
                "Сообщение об ошибке");
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
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
    public void checkLoginWithNegativeValue(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                expectedMessage,
                "Сообщение об ошибке");
    }

    @Test(priority = 2, description = "Проверка успешного входа", testName = "Позитивный тест входа на сайт", groups = {"smoke"})
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }
}