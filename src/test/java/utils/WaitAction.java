package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utils.Logger.Log;

public class WaitAction {

    public static void waitForPageLoad(WebDriver driver, WebDriverWait wait, WebElement element) {

        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForInvisibilityOfElements(WebDriver driver, WebDriverWait wait, WebElement element) {

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementAttributeValue(WebDriver driver, WebDriverWait wait, WebElement element, String attribute, String attributeValue) {
        wait.until(ExpectedConditions.attributeContains(element, attribute, attributeValue));
    }

    public static boolean isDisplayed(WebDriver driver, WebElement element) {
        try {
            if (element.isDisplayed())
                return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public static boolean fluentWait(WebDriver driver, final WebElement element, long timeoutInSeconds, long pollTimeInSeconds) {

        long startTime = System.currentTimeMillis();

        Wait<WebDriver> fluentWaiter = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .pollingEvery(Duration.ofSeconds(pollTimeInSeconds))
                .ignoring(NoSuchElementException.class);
        try {
            fluentWaiter.until(ExpectedConditions.visibilityOf(element));
            long estimatedTime = System.currentTimeMillis() - startTime;
            Log.info("Time taken for this WebElement to be visible: " + estimatedTime / 1000 + "seconds");
            return true;
        } catch (TimeoutException e) {
            Log.info("Fluent Wait : Element is not found.");
            return false;
        }
    }
}
