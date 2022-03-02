package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = ".css-k008qs")
    WebElement destinationEl;

    @FindBy(xpath = "//input[@name='month']")
    WebElement monthEl;

    @FindBy(xpath = "//input[@name='day']")
    WebElement dayEl;
    @FindBy(xpath = "//input[@name='year']")
    WebElement yearEl;

    @FindBy(xpath = "//input[@name='month']")
    List<WebElement> dateEl;

    String firstName = randomName(6);
    String lastName = randomName(6);
    String email = randomEmail(6);
    String phoneNumber = randomPhone(7);
    String month = randomMonthAndDay(1);
    String day = randomMonthAndDay(1);
    String year = randomYear(2);

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

    public void enterMonth(int numOfPassengers){
        inputElement(monthEl, month);
    }
    public void enterDay(int numOfPassengers){
        inputElement(dayEl, day);
    }
    public void enterYear(int numOfPassengers) {
        inputElement(yearEl, year);
    }

    public boolean checkIfPageExists () {
        return isElementsPresent(dateEl);
    }



    public String destination = getText(destinationEl);



}
