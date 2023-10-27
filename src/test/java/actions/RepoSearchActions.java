package actions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.RepoSearch;
import utils.WaitAction;

import java.util.Set;

import static stepdefinitions.SetUp.wait;

public class RepoSearchActions {

    public static void verifyHomePageIsDisplayed(WebDriver driver, WebDriverWait wait , WebElement element)
    {
       if(!WaitAction.isDisplayed(driver, element))
           Assert.fail("Home page is not displayed");
    }

    public static void searchRepository(WebDriver driver, WebDriverWait wait , WebElement element, String dataToSearch)
    {
        element.sendKeys(dataToSearch);
    }

    public static void verifyHeaders(WebDriver driver, WebDriverWait wait) {

        if(!RepoSearch.repository_repoName.getText().equals("Name"))
            Assert.fail("Name header is not available");
        if(!RepoSearch.repository_repoOwner.getText().equals("Owner"))
            Assert.fail("Owner header is not available");
        if(!RepoSearch.repository_repoStars.getText().equals("Stars"))
            Assert.fail("Stars header is not available");
        if(!RepoSearch.repository_repoLinkLabel.getText().equals("Link"))
            Assert.fail("Link header is not available");
        if(!RepoSearch.repository_repoDetails.getText().equals("Details"))
            Assert.fail("Details header is not available");
    }

    public static void verifyNewLinkTab(WebDriver driver, WebDriverWait wait, WebElement link) {
        WaitAction.waitForPageLoad(driver, wait , link);
        String originalWindow = driver.getWindowHandle();
        link.click();
        String textFromLink = link.getText();
        Set<String> allTabs = driver.getWindowHandles();
        for(String tabs: allTabs){
            if(!tabs.equals(originalWindow)) {
                driver.switchTo().window(tabs);
                break;
            }
        }
        if(!driver.getTitle().contains(textFromLink))
        Assert.fail("Title of new tab is not similar to the link clicked");
    }
}
