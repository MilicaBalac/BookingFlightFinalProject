package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhosFlyingPage extends BasePage {

    public WhosFlyingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#__bui-73")
    WebElement emailEl;

    @FindBy(css = ".css-1k0jlfl")
    WebElement countryCodeEl;

    @FindBy(css = "#phone")
    WebElement phoneEl;

    public void enterEmail(String email) {
        inputElement(emailEl, email);
    }
    public void enterCountryCode(String countryCode) {
        selectByValue(countryCodeEl, countryCode);
    }
    public void enterPhoneNumber(String phoneNumber) {
        inputElement(phoneEl, phoneNumber);
    }

}
