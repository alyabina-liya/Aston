import org.openqa.selenium.By;

public class PaymentPage {

    public static final By TITLE = By.cssSelector(".pay__wrapper h2");
    public static final By LOGOS = By.cssSelector(".pay__partners img");
    public static final By LINK_MORE = By.linkText("Подробнее о сервисе");
    public static final By COOKIE = By.cssSelector(".cookie, .cookie.show");
    public static final By PHONE = By.id("connection-phone");
    public static final By SUM = By.id("connection-sum");
    public static final By CONTINUE_BUTTON =
            By.cssSelector("#pay-connection button.button__default");
    public static final By COOKIE_BUTTON =
            By.xpath("//button[contains(text(),'Принять') or contains(text(),'Согласен') or contains(text(),'Accept')]");
}