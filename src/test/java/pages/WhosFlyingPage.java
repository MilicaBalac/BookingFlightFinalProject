package pages;

import org.openqa.selenium.By;
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

    @FindBy(css = "[name='email']")
    WebElement emailEl;

    @FindBy(css = ".css-1k0jlfl")
    WebElement countryCodeEl;

    @FindBy(css = "[name='phone']")
    WebElement phoneEl;

    @FindBy(css = ".css-b07tw6")
    WebElement nextBtn;

    String firstName = randomName(6);
    String lastName = randomName(6);
    String email = randomEmail(6);
    String phoneNumber = randomPhone(7);

    public void enterEmail() {
        inputElement(emailEl, email);
    }
    public void enterCountryCode(String countryCode) {
        selectByValue(countryCodeEl, countryCode);
    }
    public void enterPhoneNumber() {
        inputElement(phoneEl, phoneNumber);
    }

    public void enterFirstName(int numOfPassengers) {
        inputElement(driver.findElement(By.cssSelector("[name='passengers."+numOfPassengers+".firstName']")), firstName);
    }

    public void enterLastName(int numOfPassengers) {
        inputElement(driver.findElement(By.cssSelector("[name='passengers."+numOfPassengers+".lastName']")), lastName);
    }


    public void chooseGender(int numOfPassengers) {
        randomIndexFromDropDown(driver.findElement(By.cssSelector("[name='passengers."+numOfPassengers+".gender']")));
    }

    public void clickNext() throws InterruptedException {
        clickElement(nextBtn);
    }

}
