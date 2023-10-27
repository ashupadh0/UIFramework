package utils;

import org.openqa.selenium.JavascriptExecutor;

import static stepdefinitions.SetUp.driver;

public class Actions {

    static JavascriptExecutor js = (JavascriptExecutor) driver;

    public static void scrollToBottomOfPage() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
