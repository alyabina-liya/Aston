import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import io.qameta.allure.Step;

public class MainPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By title = By.cssSelector(".pay__wrapper h2");
    private final By logos = By.cssSelector(".pay__partners img");
    private final By moreLink = By.linkText("Подробнее о сервисе");

    private final By cookieButton = By.xpath(
            "//button[contains(text(),'Принять') or contains(text(),'Согласен') or contains(text(),'Accept')]"
    );

    private final By selectHeader = By.cssSelector(".select__header");

    private final By phone = By.cssSelector(".pay-form.opened input:first-of-type");
    private final By sum = By.cssSelector(".pay-form.opened input.total_rub");
    private final By email = By.cssSelector(".pay-form.opened input.email");

    private final By continueButton = By.cssSelector(".pay-form.opened button");

    @Step("Получить заголовок блока оплаты")
    public String getTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title))
                .getText()
                .replace("\n", " ")
                .trim();
    }

    @Step("Закрыть окно cookies")
    public void closeCookie() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        } catch (Exception ignored) {
        }
    }

    @Step("Получить количество логотипов платежных систем")
    public int getLogoCount() {
        return driver.findElements(logos).size();
    }

    @Step("Нажать ссылку 'Подробнее о сервисе'")
    public void clickMoreLink() {
        wait.until(ExpectedConditions.elementToBeClickable(moreLink)).click();
    }

    @Step("Выбрать тип оплаты: {type}")
    public void selectPaymentType(String type) {

        wait.until(ExpectedConditions.elementToBeClickable(selectHeader)).click();

        By option = By.xpath("//p[normalize-space()='" + type + "']");

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(option)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );

        wait.until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                element
        );
    }

    @Step("Получить плейсхолдер поля телефона")
    public String getPhonePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phone))
                .getAttribute("placeholder");
    }

    @Step("Ввести номер телефона: {value}")
    public void enterPhone(String value) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phone)
        );
        element.clear();
        element.sendKeys(value);
    }

    @Step("Ввести сумму: {value}")
    public void enterSum(String value) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(sum)
        );
        element.clear();
        element.sendKeys(value);
    }

    @Step("Ввести e-mail: {value}")
    public void enterEmail(String value) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(email)
        );
        element.clear();
        element.sendKeys(value);
    }

    @Step("Нажать кнопку 'Продолжить'")
    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}
