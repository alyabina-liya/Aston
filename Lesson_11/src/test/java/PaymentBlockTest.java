import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Epic("MTS")
@Feature("Онлайн пополнение без комиссии")
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
    @Story("Проверка блока оплаты")
    @DisplayName("Проверка блока Онлайн пополнение без комиссии")
    @Description("Проверка заголовка, логотипов платежных систем и ссылки 'Подробнее о сервисе'")
    public void testPaymentBlock() {

        Allure.step("Проверить заголовок блока оплаты");
        Assertions.assertTrue(
                mainPage.getTitle().toLowerCase().contains("онлайн пополнение")
        );

        Allure.step("Проверить количество логотипов платежных систем");
        Assertions.assertEquals(5, mainPage.getLogoCount());

        Allure.step("Перейти по ссылке 'Подробнее о сервисе'");
        mainPage.clickMoreLink();

        Allure.step("Проверить переход на страницу порядка оплаты");
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("poryadok-oplaty")
        );
    }

    @Test
    @Story("Проверка плейсхолдеров")
    @DisplayName("Проверка плейсхолдеров всех типов оплаты")
    @Description("Проверка плейсхолдеров поля ввода для всех вариантов оплаты")
    public void testPlaceholders() {

        Allure.step("Проверить плейсхолдер для 'Услуги связи'");
        mainPage.selectPaymentType("Услуги связи");
        Assertions.assertEquals(
                "Номер телефона",
                mainPage.getPhonePlaceholder()
        );

        Allure.step("Проверить плейсхолдер для 'Домашний интернет'");
        mainPage.selectPaymentType("Домашний интернет");
        Assertions.assertEquals(
                "Номер абонента",
                mainPage.getPhonePlaceholder()
        );

        Allure.step("Проверить плейсхолдер для 'Рассрочка'");
        mainPage.selectPaymentType("Рассрочка");
        Assertions.assertEquals(
                "Номер счета на 44",
                mainPage.getPhonePlaceholder()
        );

        Allure.step("Проверить плейсхолдер для 'Задолженность'");
        mainPage.selectPaymentType("Задолженность");
        Assertions.assertEquals(
                "Номер счета на 2073",
                mainPage.getPhonePlaceholder()
        );
    }

    @Test
    @Story("Переход к оплате")
    @DisplayName("Проверка формы оплаты")
    @Description("Проверка отображения данных на странице оплаты после заполнения формы")
    public void testContinueButton() {

        Allure.step("Выбрать тип оплаты 'Услуги связи'");
        mainPage.selectPaymentType("Услуги связи");

        Allure.step("Заполнить форму оплаты");
        mainPage.enterPhone("297777777");
        mainPage.enterSum("10");
        mainPage.enterEmail("test@test.com");

        Allure.step("Нажать кнопку 'Продолжить'");
        mainPage.clickContinue();

        PaymentPage paymentPage = new PaymentPage(driver);

        Allure.step("Проверить сумму платежа");
        Assertions.assertTrue(
                paymentPage.getAmount().contains("10")
        );

        Allure.step("Проверить номер телефона");
        Assertions.assertTrue(
                paymentPage.getPhone().contains("297777777")
        );

        Allure.step("Проверить подписи полей банковской карты");
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

        Allure.step("Проверить текст кнопки оплаты");
        Assertions.assertTrue(
                paymentPage.getPayButtonText().contains("10")
        );

        Allure.step("Проверить наличие иконок платежных систем");
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