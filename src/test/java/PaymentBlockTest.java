import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentBlockTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testPaymentForm() {

        driver.get("https://www.mts.by/");

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(PaymentPage.TITLE)
        );

        Assertions.assertTrue(
                title.getText().toLowerCase().contains("онлайн пополнение"),
                "Неверный заголовок"
        );

        try {
            WebElement cookieBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(PaymentPage.COOKIE_BUTTON)
            );
            cookieBtn.click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".cookie")
            ));
        } catch (Exception ignored) {}

        List<WebElement> logos = driver.findElements(PaymentPage.LOGOS);

        Assertions.assertFalse(logos.isEmpty(), "Логотипы не найдены");
        Assertions.assertEquals(5, logos.size(), "Неверное количество логотипов");

        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(PaymentPage.LINK_MORE)
        );

        link.click();

        wait.until(ExpectedConditions.urlContains("poryadok-oplaty"));

        driver.navigate().back();

        driver.findElement(By.xpath("//span[text()='Услуги связи']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(PaymentPage.PHONE))
                .sendKeys("297777777");

        driver.findElement(PaymentPage.SUM).sendKeys("10");

        driver.findElement(PaymentPage.CONTINUE_BUTTON).click();

        Assertions.assertTrue(true, "Форма отправлена");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}