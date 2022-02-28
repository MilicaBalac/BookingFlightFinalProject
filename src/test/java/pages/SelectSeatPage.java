package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectSeatPage extends BasePage{

	WebDriver driver;

	public SelectSeatPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".Accordion-module__icon___2j9RS")
	List<WebElement> viewSeatsEl;

	@FindBy(xpath = "//button[@aria-expanded='true']//..//div[@class = 'css-suxfu6']")
	List<WebElement> passengers;

	@FindBy(xpath = "//button[@aria-expanded='true']//..//div[@class='Accordion-module__content___2xGZy']//div[@class='css-dcom7u']")
	List<WebElement> allSeats;

	@FindBy(css = ".css-b07tw6")
	WebElement nextBtn;


	public void selectSeat () throws InterruptedException {
		for (int i = 0; i < viewSeatsEl.size();i++) {
			Thread.sleep(2000);
			clickElement(viewSeatsEl.get(i));
			for (int j = 0; j < passengers.size(); j++) {
				Thread.sleep(2000);
				if(allSeats.size() > passengers.size())
				clickElement(allSeats.get(j+1));
				else{
					clickElement(allSeats.get(j-1));
				}
			}
		}
	}

	public void clickNext() throws InterruptedException {
		clickElement(nextBtn);
	}


}
