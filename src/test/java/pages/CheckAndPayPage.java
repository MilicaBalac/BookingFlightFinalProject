package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckAndPayPage extends BasePage{

	WebDriver driver;

	public CheckAndPayPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@data-testid='trip_summary_cities']//div[@class='css-k008qs']")
	WebElement destinationEl;

	public String accDestination = getText(destinationEl);

	public void verifyDestination() {
		WhosFlyingPage whosFlyingPage = new WhosFlyingPage(driver);
		String expDes = whosFlyingPage.destination;
		Assert.assertEquals(accDestination, expDes);
	}





}
