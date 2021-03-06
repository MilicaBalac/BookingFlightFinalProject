package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

    @FindBy(css = "[placeholder='Return']")
    WebElement returnBtn;

    @FindBy(css = ".InputCheckbox-module__field___1mRcZ")
    WebElement directFlights;

    @FindBy(css = ".css-ya5gr9")
    WebElement searchBtn;

    @FindBy(css = "[data-testid='searchresults_card']")
    List<WebElement> flightsCard;

    @FindBy (css = "[data-testid='flight_card_bound_select_flight']")
    List <WebElement> seeFlightBtn;

    @FindBy(css ="[SheetContainer-module__content___1idtO]]")
    WebElement detailsScreen;

    @FindBy(xpath ="//div[@class='css-yyi517']//div[@data-test-id='flight_card_price_main_price']")
    List <WebElement> expectedPrice;

    @FindBy(xpath = "//div[@class='css-2zyr2k']//div[@data-test-id='flight_card_price_main_price']")
    WebElement acctualPrice;

    @FindBy(css = "[data-testid='flight_details_inner_modal_select_button']")
    WebElement selectFlightBtn;

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
       // clickElement(returnBtn);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));
    }

    public void checkDirectFlights() throws InterruptedException {
        clickElement(directFlights);
    }

    public void clickSearch() throws InterruptedException {
        clickElement(searchBtn);
        Thread.sleep(3000);
    }

    public void chooseStops(String stops) throws InterruptedException {

        if (isElementsPresent(flightsCard)) {
            clickElement(driver.findElement(By.xpath("//div[text() ='" + stops + "']")));
        } else {
            checkDirectFlights();
            Thread.sleep(2000);
            clickElement(driver.findElement(By.xpath("//div[text() ='" + stops + "']")));
        }
    }

    public void chooseDepartFlightTime(String time) throws InterruptedException {
        if (isElementsPresent(flightsCard)) {
            clickElement(driver.findElement(By.xpath("//div[contains(text(), 'Departs')]//..//..//div[contains(text(),'"+time+"')]//..//..//span")));
        } else {
            checkDirectFlights();
            Thread.sleep(2000);
            clickElement(driver.findElement(By.xpath("//div[contains(text(), 'Departs')]//..//..//div[contains(text(),'"+time+"')]//..//..//span")));
        }

    }

    public void chooseArrivesFlightTime(String time) throws InterruptedException {
        if (isElementsPresent(flightsCard)) {
            clickElement(driver.findElement(By.xpath("//div[contains(text(), 'Arrives')]//..//..//div[contains(text(),'"+time+"')]//..//..//span")));
        } else {
            checkDirectFlights();
            Thread.sleep(2000);
            clickElement(driver.findElement(By.xpath("//div[contains(text(), 'Arrives')]//..//..//div[contains(text(),'"+time+"')]//..//..//span")));
        }

    }

    public void choosePresentation(String presentation) throws InterruptedException {
        if (isElementsPresent(flightsCard)) {
            clickElement(driver.findElement(By.xpath("//span[text()='"+presentation+"']")));
        } else {
            checkDirectFlights();
            Thread.sleep(2000);
            clickElement(driver.findElement(By.xpath("//span[text()='"+presentation+"']")));
        }
    }

    public void clickToSeeFlightDetails(String num) throws InterruptedException {
        clickElement(seeFlightBtn.get(Integer.parseInt(num)));
    }

    public void verifyVisibilityOfDetails() {
        Assert.assertTrue(isElementPresent(detailsScreen));
    }

    public void verifyPrices(String num) {

       String expePrice = getText(expectedPrice.get(Integer.parseInt(num))).substring(1).replace(",", "");
       Double expPrice = Double.parseDouble(expePrice);

        System.out.println("Ocekivana cena sa osnovne strane: " +expPrice);
       Double adultsNum = Double.parseDouble(getText(adultEl).substring(0,1));
        System.out.println("Broj putnika " + adultsNum);
       Double expecPrice = expPrice * adultsNum;
        System.out.println("Ocekivana cena pomnozena sa rojem putnikad: " + expePrice);
       double roundOff = Math.round(expecPrice*100.0)/100.0;
        System.out.println("Zaokruzena ocekivana cena " + roundOff);

       String acctPrice = getText(acctualPrice).substring(1).replace(",", "");
       Double accPrice = Double.parseDouble(acctPrice);

        System.out.println("Prava cena: " + acctPrice);
       if(roundOff == accPrice) {
           Assert.assertEquals(accPrice, roundOff);
       } else {
           Assert.assertEquals(accPrice, expPrice);
        }
    }

    public void selectFlight () throws InterruptedException {
        clickElement(selectFlightBtn);
    }


}