package stepdefinitions;

import actions.RepoSearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.RepoSearch;
import utils.Actions;
import utils.JsonReader;
import utils.WaitAction;

import java.util.HashMap;

import static stepdefinitions.SetUp.wait;
import static utils.Logger.Log;

public class RepoSearchStepDefinitions {

    WebDriver driver = SetUp.driver;
    final String jsonPath = "src/test/java/resources/testData/Repo.json";

    @Given("^repo search home page is launched$")
    public void repo_search_home_page_is_launched()
    {
        PageFactory.initElements(driver, RepoSearch.class);
        RepoSearchActions.verifyHomePageIsDisplayed(driver,wait,RepoSearch.repository_Header);
    }

    @When("^user searches data \"([^\"]*)\"$")
    public void repo_search_home_page_is_launched(String data)
    {
        PageFactory.initElements(driver, RepoSearch.class);
        RepoSearchActions.searchRepository(driver,wait,RepoSearch.repository_searchText,data);
        WaitAction.waitForPageLoad(driver, wait, RepoSearch.repository_searchIcon);
        RepoSearch.repository_searchIcon.click();
        WaitAction.waitForPageLoad(driver, wait, RepoSearch.repository_repoTable);
    }

    @Then("^only repositories with name \"([^\"]*)\" should be displayed$")
    public void repo_with_name(String name)
    {
       // WaitAction.waitForPageLoad();
        PageFactory.initElements(driver, RepoSearch.class);
        for(WebElement ele : RepoSearch.repository_Names){
            if(!ele.getText().contains(name))
                Assert.fail("All name values do not contain the name searched");
        }
    }

    @When("^user is in home page$")
    public void user_is_in_home_page()
    {
        WaitAction.waitForPageLoad(driver,wait,RepoSearch.repository_Header);
    }

    @Then("^table should contain Name,Owner,Stars ,Link and Details$")
    public void name_owner_stars()
    {
        PageFactory.initElements(driver, RepoSearch.class);
        RepoSearchActions.verifyHeaders(driver, wait);
    }

    @Then("^table should contain \"([^\"]*)\" rows by default$")
    public void name_owner_stars(String numberOfRows)
    {
        Actions.scrollToBottomOfPage();
        String numRows = RepoSearch.repository_numberOfRows.getText();
        Assert.assertEquals("Default number of rows is not 10", numberOfRows, numRows);
    }

    @When("^user selects (.*)$")
    public void user_selects_rows(String numberOfRows)
    {
        Actions.scrollToBottomOfPage();
        WaitAction.waitForPageLoad(driver , new WebDriverWait(driver, 20),
                RepoSearch.repository_rowArrowDropDown);
        RepoSearch.repository_rowArrowDropDown.click();
        WaitAction.waitForPageLoad(driver, new WebDriverWait(driver, 20) , RepoSearch.repository_rowList);
        WaitAction.waitForPageLoad(driver, wait ,
                driver.findElement(By.xpath("//li[contains(text(),'" + numberOfRows + "')]")));
        driver.findElement(By.xpath("//li[contains(text(),'" + numberOfRows + "')]")).click();
    }

    @Then("^(.*)should be displayed in the homepage$")
    public void rows_displayed_in_the_homepage(String numberOfRows)
    {
       Assert.assertEquals("Row number did not change after selecting values from row dropdown",
               Integer.parseInt(numberOfRows.trim()), RepoSearch.repository_Names.size());
    }

    @Then("^url in the new tab should be same as the link clicked on$")
    @Then("^a new tab should be opened when user clicks on a link$")
    public void user_clicks_on_a_link()
    {
        PageFactory.initElements(driver, RepoSearch.class);
        RepoSearchActions.verifyNewLinkTab(driver, wait, RepoSearch.repository_link);
    }

    @When("^user clicks on details$")
    public void user_clicks_on_a_detail()
    {
        WaitAction.waitForPageLoad(driver, new WebDriverWait(driver , 20), RepoSearch.repository_getDetails );
        RepoSearch.repository_getDetails.click();
    }

    @Then("^repo details should be displayed$")
    public void repo_details_should_be_displayed() {
      try
      {
          WaitAction.waitForPageLoad(driver, wait, RepoSearch.repository_detailsHeader);
          Log.info("Details of repository is displayed");
      }
      catch(Exception e)
      {
          Assert.fail("Details of repository is not displayed\"");
      }
    }

    @Then("^details popup should close when clicked on ok button$")
    public void alert_should_close()
    {
        WaitAction.waitForPageLoad(driver, wait, RepoSearch.repository_detailsHeader);
        WaitAction.waitForPageLoad(driver, new WebDriverWait(driver, 10), RepoSearch.repository_detailsOkButton);
        RepoSearch.repository_detailsOkButton.click();
        try{
            WaitAction.waitForInvisibilityOfElements(driver, new WebDriverWait(driver , 15)
            ,RepoSearch.repository_lastThreeCommitters);
            Assert.fail("Repository details are still visible");
        }
        catch (Exception e) {
            Log.info("Repo Details are no longer visible");
        }
    }

    @Then("^alert should contain details of the repository (.*)$")
    public void alert_should_contain_details(String testCaseId) {
        WaitAction.waitForPageLoad(driver, wait, RepoSearch.repository_detailsHeader);
        HashMap<String, String> map = JsonReader.getMapFromJson(jsonPath,testCaseId);
        try {
            WaitAction.waitForPageLoad(driver, new WebDriverWait(driver, 30),
                    driver.findElement(By.xpath("//p[contains(text(),'" + map.get("lastthreecommitters") + "')]")));
            WaitAction.waitForPageLoad(driver, new WebDriverWait(driver, 10),
                    driver.findElement(By.xpath("//p[contains(text(),'" + map.get("recentforkeduser") + "')]")));
            WaitAction.waitForPageLoad(driver, new WebDriverWait(driver, 10),
                    driver.findElement(By.xpath("//p[contains(text(),'" + map.get("recentforkeduserbio") + "')]")));
            Log.info("All repository details are displayed successfully");
        }
        catch (Exception e)
        {
            Assert.fail("Repo details displayed is not correct");
        }

    }

    @Then("^data in the home page should be available$")
    public void dataInTheHomePageShouldBeAvailable() {
        if(WaitAction.isDisplayed(driver,RepoSearch.repository_NoDataMessage))
            Assert.fail("Data is not loaded by default in the home page");
    }
}
