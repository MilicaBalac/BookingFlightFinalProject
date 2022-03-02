package steps;

import excel_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.*;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BookingSteps extends BaseTest {

    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String WAIT_TIME = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT_TIME");
    String ENV = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ENV");

    Map<String, String> data;
    String testDataPath = "src/test/test_data/";


    @Before
    public void setUP() throws Exception {
        setUPTest(BROWSER, Integer.parseInt(WAIT_TIME));
    }


    @After
    public void tearDown() throws IOException {
        reportScreenshot("end", "Screenshot on end or fail");
        quit();
    }

    @Given("I load test data from {string} {string} {string}")
    public void iLoadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
        ExcelUtilities excelUtilities = new ExcelUtilities();
        data = excelUtilities.getRowData(testDataPath + fileName + ".xlsx", sheetName, rowNum);
    }

    @Given("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startApplication(ENV);
    }

    @Then("I navigate to flights page")
    public void iNavigateToFlightsPage() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.openFlightPage();
    }

    @And("I select flight class")
    public void iSelectFlightClass() {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlightClass(data.get("ClassType"));
    }

    @And("I select number of adults")
    public void iSelectNumberOfAdults() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addAdults(data.get("AdultsNum"));
    }

    @And("I add destination")
    public void iAddDestination() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addLocation(data.get("City"), data.get("State"));
    }

    @And("I add departure date and return date")
    public void iAddDepartureDateAndReturnDate() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectDepartAndReturnDate(data.get("departureDate"), data.get("returnDate"));
    }

    @Then("I check direct flights only")
    public void iCheckDirectFlightsOnly() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.checkDirectFlights();
    }

    @And("I click search")
    public void iClickSearch() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSearch();
    }

    @Then("I choose stops and flight time")
    public void iChooseStopsAndFlightTime() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.chooseStops(data.get("stops"));
        flightsPage.chooseDepartFlightTime(data.get("flightTime"));

    }

    @Then("I choose presentation")
    public void iChoosePresentation() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.choosePresentation(data.get("presentation"));
    }

    @Then("I click to see flight")
    public void iClickToSeeFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickToSeeFlightDetails(data.get("flightNum"));
    }


    @Then("I verify visibility of flights details")
    public void iVerifyVisibilityOfFlightsDetails() {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.verifyVisibilityOfDetails();
    }

    @Then("I verify prices")
    public void iVerifyPrices() {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.verifyPrices(data.get("flightNum"));

    }

    @Then("I select flight")
    public void iSelectFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlight();
    }

    @Then("I choose type of tickets")
    public void iChooseTypeOfTickets() throws InterruptedException {
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        boolean exist = ticketTypePage.checkIfPageExists();
        if(exist) {
            ticketTypePage.chooseTicketType(data.get("ticketType"));
        }
    }

    @Then("I verify final price")
    public void iVerifyFinalPrice() {
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        boolean exist = ticketTypePage.checkIfPageExists();
        if(exist) {
            ticketTypePage.verifyFinalPrice(data.get("priceTicketType"));
        }
    }

    @Then("I click next button")
    public void iClickNextButton() throws InterruptedException {

        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        boolean exist = ticketTypePage.checkIfPageExists();
        if(exist) {
            ticketTypePage.clickNextButton();
        }
    }

    @Then("I enter contact details")
    public void iEnterContactDetails() {
        WhosFlyingPage whosFlyingPage = new WhosFlyingPage(driver);
        whosFlyingPage.enterEmail();
        whosFlyingPage.enterCountryCode(data.get("countryCode"));
        whosFlyingPage.enterPhoneNumber();
    }

    @Then("I enter names of passengers and gender")
    public void iEnterNamesOfPassengersAndGender() {
        int num = Integer.parseInt(data.get("AdultsNum"));
        WhosFlyingPage whosFlyingPage = new WhosFlyingPage(driver);

        for (int i =0; i < num; i++){
            whosFlyingPage.enterFirstName(i);
            whosFlyingPage.enterLastName(i);
            whosFlyingPage.chooseGender(i);
          if(whosFlyingPage.checkIfPageExists()) {
              whosFlyingPage.enterMonth(i);
              whosFlyingPage.enterDay(i);
              whosFlyingPage.enterYear(i);
          }
        }
    }

    @Then("I click next")
    public void iClickNext() throws InterruptedException {
        WhosFlyingPage whosFlyingPage = new WhosFlyingPage(driver);
        whosFlyingPage.clickNext();
    }

    @Then("I select seats")
    public void iSelectSeats() throws InterruptedException {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        selectSeatPage.selectSeat();
    }

    @Then("I click  last next button")
    public void iClickLastNextButton() throws InterruptedException {
        SelectSeatPage selectSeatPage = new SelectSeatPage(driver);
        selectSeatPage.clickNext();
    }

    @Then("I verify flight destination")
    public void iVerifyFlightDestination() {
        CheckAndPayPage checkAndPayPage = new CheckAndPayPage(driver);
        checkAndPayPage.verifyDestination();
    }


    @Then("I choose meal")
    public void iChooseMeal() throws InterruptedException {
        BaggageAndExtras baggageAndExtras = new BaggageAndExtras(driver);
        boolean exist = baggageAndExtras.checkIfLuggageExists();
        if(exist) {
            baggageAndExtras.chooseMeal(data.get("AdultsNum"));
        }
    }


    @Then("I click next page")
    public void iClickNextPage() throws InterruptedException {
        BaggageAndExtras baggageAndExtras = new BaggageAndExtras(driver);
        boolean exist = baggageAndExtras.checkIfLuggageExists();
        if(exist) {
            baggageAndExtras.clickNext();
        }
    }
}
