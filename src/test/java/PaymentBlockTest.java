import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaymentBlockTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        mainPage = new MainPage(driver);
        mainPage.closeCookie();
    }

    @Test
    public void testPaymentBlock() {

        Assertions.assertTrue(
                mainPage.getTitle().toLowerCase().contains("онлайн пополнение")
        );

        Assertions.assertEquals(5, mainPage.getLogoCount());

        mainPage.clickMoreLink();

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("poryadok-oplaty")
        );
    }

    @Test
    public void testPlaceholders() {

        mainPage.selectPaymentType("Услуги связи");
        Assertions.assertEquals(
                "Номер телефона",
                mainPage.getPhonePlaceholder()
        );

        mainPage.selectPaymentType("Домашний интернет");
        Assertions.assertEquals(
                "Номер абонента",
                mainPage.getPhonePlaceholder()
        );

        mainPage.selectPaymentType("Рассрочка");
        Assertions.assertEquals(
                "Номер счета на 44",
                mainPage.getPhonePlaceholder()
        );

        mainPage.selectPaymentType("Задолженность");
        Assertions.assertEquals(
                "Номер счета на 2073",
                mainPage.getPhonePlaceholder()
        );
    }

    @Test
    public void testContinueButton() {

        mainPage.selectPaymentType("Услуги связи");

        mainPage.enterPhone("297777777");
        mainPage.enterSum("10");
        mainPage.enterEmail("test@test.com");

        mainPage.clickContinue();

        PaymentPage paymentPage = new PaymentPage(driver);

        Assertions.assertTrue(
                paymentPage.getAmount().contains("10")
        );

        Assertions.assertTrue(
                paymentPage.getPhone().contains("297777777")
        );

        Assertions.assertEquals(
                "Номер карты",
                paymentPage.getCardNumberLabel()
        );

        Assertions.assertEquals(
                "Срок действия",
                paymentPage.getCardDateLabel()
        );

        Assertions.assertEquals(
                "CVC",
                paymentPage.getCardCvcLabel()
        );

        Assertions.assertEquals(
                "Имя и фамилия на карте",
                paymentPage.getCardHolderLabel()
        );

        Assertions.assertEquals(
                "ММ / ГГ",
                paymentPage.getCardDatePlaceholder()
        );

        Assertions.assertTrue(
                paymentPage.getPayButtonText().contains("10")
        );

        Assertions.assertTrue(
                paymentPage.getPaymentSystemsCount() >= 4
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}