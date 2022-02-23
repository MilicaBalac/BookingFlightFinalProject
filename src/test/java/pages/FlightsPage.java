package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage extends BasePage {

    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@data-decider-header='flights']")
    WebElement flights;

    @FindBy(css = "select.css-1k0jlfl")
    WebElement flightClass;

    @FindBy(xpath = "//div[contains(text(), 'adult')]")
    WebElement adultEl;

    @FindBy(css = ".css-153jucu")
    List<WebElement> incAdultNum;

    @FindBy(css = ".css-1bal7l4 .css-ya5gr9")
    WebElement addAdultNumBtn;

    @FindBy(css = "[data-testid='searchbox_destination_input']")
    WebElement whereToDestination;

    @FindBy(css = "[data-testid='searchbox_destination']")
    WebElement whereTo;

    @FindBy(xpath = "//input[@placeholder='Depart']")
    WebElement departBtn;

    @FindBy(xpath = "//input[@placeholder='Return']")
    WebElement returnBtn;

    @FindBy(css = ".InputCheckbox-module__field___1mRcZ")
    WebElement directFlights;

    @FindBy(css = ".css-ya5gr9")
    WebElement searchBtn;

    public void openFlightPage() throws InterruptedException {
        clickElement(flights);
    }


    public void selectFlightClass(String classType) {
        selectByValue(flightClass, classType);
    }


    public void addAdults(String num) throws InterruptedException {
        clickElement(adultEl);
        Thread.sleep(1000);

        if (num.equals("1")) {
            //do nothing
        } else if (Integer.parseInt(num) > 1) {
            for (int i = 2; i <= Integer.parseInt(num); i++) {
                clickElement(incAdultNum.get(0));
            }
        }
        clickElement(addAdultNumBtn);
    }

    public void addLocation(String city, String place) throws InterruptedException {
        clickElement(whereTo);
        inputElement(whereToDestination, city);
        Thread.sleep(wait);
        clickElement(driver.findElement(By.xpath("//div[contains(text(),'" + place + "')]")));
    }

    public void selectDepartAndReturnDate(String departDate, String returnDate) throws InterruptedException {
        clickElement(departBtn);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + departDate + "']")));
        clickElement(returnBtn);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));
    }

    public void checkDirectFlights() throws InterruptedException {
        clickElement(directFlights);
    }

    public void clickSearch() throws InterruptedException {
        clickElement(searchBtn);
    }


}
