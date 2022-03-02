package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BaggageAndExtras extends BasePage{

	WebDriver driver;

	public BaggageAndExtras(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[data-testid='checkout_extras_inner_next']")
	WebElement nextBtn;

	@FindBy(xpath = "//div[contains(text(), 'Luggage')]")
	List<WebElement> luggagePage;

	@FindBy(xpath = "//div[contains(text(), 'Checked bags')]")
	List<WebElement> bagsPart;

	public boolean checkIfLuggageExists () {
		return isElementsPresent(luggagePage);
	}
	public boolean checkIfBagsExists () {
		return isElementsPresent(bagsPart);
	}

	public void chooseMeal(String passengersNum) throws InterruptedException {

		if (checkIfBagsExists()) {
		clickNext();
		} else {
			for (int i = 0; i < Integer.parseInt(passengersNum); i++) {
				randomIndexFromDropDown(driver.findElements(By.cssSelector(".InputSelect-module__field___10SP5")).get(i));
			}
		}
	}
	public void clickNext() throws InterruptedException {
		clickElement(nextBtn);
	}
}
