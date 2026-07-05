import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        switchToFrame();
    }

    private final By iframe =
            By.cssSelector("iframe.payment-widget-iframe");

    private final By amount =
            By.cssSelector("span.ng-star-inserted");

    private final By phone =
            By.cssSelector(".pay-description__text, .pay-description");

    private final By cardNumber =
            By.id("cc-number");

    private final By cardDate =
            By.cssSelector("input[formcontrolname='expirationDate']");

    private final By cardCvc =
            By.cssSelector("input[formcontrolname='cvc']");

    private final By cardHolder =
            By.cssSelector("input[formcontrolname='holder']");

    private final By cardNumberLabel =
            By.xpath("//label[contains(text(),'Номер карты')]");

    private final By cardDateLabel =
            By.xpath("//label[contains(text(),'Срок действия')]");

    private final By cardCvcLabel =
            By.xpath("//label[contains(text(),'CVC')]");

    private final By cardHolderLabel =
            By.xpath("//label[contains(text(),'Имя и фамилия')]");

    private final By payButton =
            By.cssSelector("button[type='submit'] span");

    private final By paymentSystems =
            By.cssSelector(".cards-brands img");

    private void switchToFrame() {

        WebElement frame = wait.until(
                ExpectedConditions.visibilityOfElementLocated(iframe));

        driver.switchTo().frame(frame);
    }

    @Step("Получить сумму платежа")
    public String getAmount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(amount))
                .getText();
    }

    @Step("Получить номер телефона")
    public String getPhone() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(phone))
                .getText();
    }

    @Step("Получить надпись поля 'Номер карты'")
    public String getCardNumberLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberLabel))
                .getText();
    }

    @Step("Получить надпись поля 'Срок действия'")
    public String getCardDateLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardDateLabel))
                .getText();
    }

    @Step("Получить надпись поля 'CVC'")
    public String getCardCvcLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardCvcLabel))
                .getText();
    }

    @Step("Получить надпись поля 'Имя и фамилия на карте'")
    public String getCardHolderLabel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderLabel))
                .getText();
    }

    @Step("Получить плейсхолдер поля даты карты")
    public String getCardDatePlaceholder() {
        return driver.findElement(cardDate).getAttribute("placeholder");
    }

    @Step("Получить текст кнопки оплаты")
    public String getPayButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton))
                .getText();
    }

    @Step("Получить количество иконок платежных систем")
    public int getPaymentSystemsCount() {
        List<WebElement> systems = driver.findElements(paymentSystems);
        return systems.size();
    }
}
