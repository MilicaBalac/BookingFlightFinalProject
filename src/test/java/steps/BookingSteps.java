package steps;

import excel_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.FlightsPage;
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

    @And("I select number of adults {string}")
    public void iSelectNumberOfAdults(String num) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addAdults(num);
    }

//    @And("I select flight class {string}")
//    public void iSelectFlightClass(String classType) throws InterruptedException {
//        FlightsPage flightsPage = new FlightsPage(driver);
//        flightsPage.selectFlightClass(classType);
//    }
}