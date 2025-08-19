package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static tests.AllureUtils.takeScreenshot;


public class LoginPage extends BasePage {


    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вход в систему с именем пользователя: {user} и паролем {password}")
    public ProductsPage login(String user, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Получение уведомления в случае ошибки входа")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}