package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TicketTypePage extends BasePage {
    WebDriver driver;

    public TicketTypePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid='checkout_ticket_type_inner_next']")
    WebElement nextBtn;

    @FindBy(xpath = "//div[contains(text(), 'ticket type')]")
    List<WebElement> typePage;

    public boolean checkIfPageExists () {
       return isElementsPresent(typePage);
    }

    public void chooseTicketType (String ticketType) throws InterruptedException {
            clickElement(driver.findElement(By.xpath("//div[text()='" + ticketType + "']//..//..//..//span")));
    }

    public void verifyFinalPrice (String ticketType) {
            String expectedPrice = getText(driver.findElement(By.xpath("//div[@data-testid='ticket_type_radio_" + ticketType + "']//div[@class='css-1vg6q84']")));
            String acctualPrice = getText(driver.findElement(By.cssSelector("[data-testid='breakdown_list_price']")));

            Assert.assertEquals(acctualPrice, expectedPrice);
    }

    public void clickNextButton() throws InterruptedException {
            clickElement(nextBtn);
    }
}
