package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CommonMethods {

    WebDriver driver;
    int wait = 10;
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Selenium wrapper methods Start
    public void clickElement(WebElement element) throws InterruptedException{
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.click();
        } catch (StaleElementReferenceException e){
            Thread.sleep(1000);
            element.click();
        }
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void hoverElement(WebElement element){
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void inputElement (WebElement element, String value)  {
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    public void typeText(WebElement element, String text) throws InterruptedException {
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
        //    scrollToElement(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).build().perform();
            element.sendKeys(text);
        } catch (StaleElementReferenceException e){
            Thread.sleep(1000);
            element.click();
        }
    }

    public void selectByValue(WebElement element, String value) {
//        WebDriverWait wdWait = new WebDriverWait(driver, wait);
//        wdWait.until(ExpectedConditions.visibilityOf(element));
//        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (StaleElementReferenceException e){
            Select select = new Select(element);
            select.selectByValue(value);
        }
    }

    public void selectByVisibleText(WebElement element, String visibleText) {
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));
        wdWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        } catch (StaleElementReferenceException e){
            Select select = new Select(element);
            select.selectByValue(visibleText);
        }
    }

    public String getText(WebElement element){
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    public String getValue(WebElement element){
        WebDriverWait wdWait = new WebDriverWait(driver, wait);
        wdWait.until(ExpectedConditions.visibilityOf(element));

        return element.getAttribute("value");
    }

    public boolean isElementsPresent(List<WebElement> elements) {
        return elements.size() != 0;
    }
    public boolean isElementPresent(WebElement element) {
        return element != null;
    }
    //Selenium wrapper methods End
}
