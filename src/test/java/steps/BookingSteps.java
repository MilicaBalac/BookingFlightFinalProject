package steps;

import excel_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.FlightsPage;
import pages.TicketTypePage;
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
     //   quit();
    }

//    @Given("I load test data from {string} {string} {string}")
//    public void iLoadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
//        ExcelUtilities excelUtilities = new ExcelUtilities();
//        data = excelUtilities.getRowData(testDataPath + fileName + ".xlsx", sheetName, rowNum);
//        System.out.println(data.get("Location"));
//    }

    @Given("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startApplication(ENV);
    }

    @Then("I navigate to flights page")
    public void iNavigateToFlightsPage() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.openFlightPage();
    }

    @And("I select flight class {string}")
    public void iSelectFlightClass(String classType) {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlightClass(classType);
    }

    @And("I select number of adults {string}")
    public void iSelectNumberOfAdults(String num) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addAdults(num);
    }

    @And("I add destination {string} {string}")
    public void iAddDestination(String city, String place) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addLocation(city, place);
    }

    @And("I add departure date and return date {string}  {string}")
    public void iAddDepartureDateAndReturnDate(String departDate, String returnDate) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectDepartAndReturnDate(departDate, returnDate);
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

    @Then("I choose stops and flight time {string} {string}")
    public void iChooseStopsAndFlightTime(String stops, String time) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.chooseStops(stops);
        flightsPage.chooseFlightTime(time);
    }

    @Then("I choose presentation {string}")
    public void iChoosePresentation(String presentation) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.choosePresentation(presentation);
    }

    @Then("I click to see flight {string}")
    public void iClickToSeeFlight(String num) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickToSeeFlightDetails(num);
    }


    @Then("I verify visibility of flights details")
    public void iVerifyVisibilityOfFlightsDetails() {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.verifyVisibilityOfDetails();
    }

    @Then("I verify prices {string}")
    public void iVerifyPrices(String num) {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.verifyPrices(num);

    }

    @Then("I select flight")
    public void iSelectFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlight();
    }

    @Then("I choose type of tickets {string}")
    public void iChooseTypeOfTickets(String type) throws InterruptedException {
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        ticketTypePage.chooseTicketType(type);
    }

    @Then("I verify final price {string}")
    public void iVerifyFinalPrice(String ticketType) {
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        ticketTypePage.verifyFinalPrice(ticketType);
    }

    @Then("I click next button")
    public void iClickNextButton() throws InterruptedException {
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        ticketTypePage.clickNextButton();
    }


}
