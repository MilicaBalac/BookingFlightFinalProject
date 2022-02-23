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

    @FindBy (xpath = "//div[@class='css-1ntod47']")
    WebElement flightClassEl;
    @FindBy (xpath = "//select[@class='css-1k0jlfl']")
    WebElement flightClassElSelect;

    @FindBy (xpath = "//div[contains(text(), 'adult')]")
    WebElement adultEl;

    @FindBy (css = ".css-153jucu")
    List<WebElement> incAdultNum;

    @FindBy (css = ".css-1od6d6y")
    List<WebElement> decAdultNum;

    @FindBy (css = ".css-1bal7l4 .css-ya5gr9")
    WebElement addAdultNumBtn;


    public void openFlightPage() throws InterruptedException {
        clickElement(flights);
    }

    public void selectFlightClass(String classType) throws InterruptedException {
        clickElement(flightClassEl);
        selectByVisibleText(flightClassElSelect, classType);
    }

       public void addAdults(String num) throws InterruptedException {
        clickElement(adultEl);
        Thread.sleep(1000);

        if(num.equals("1")){
            //do nothing
        } else if(Integer.parseInt(num)< 1){
            clickElement(decAdultNum.get(0));
        } else {
            for(int i = 0; i <= Integer.parseInt(num); i++) {
                clickElement(incAdultNum.get(0));
            }
        }
        clickElement(addAdultNumBtn);
    }
}
