package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class RepoSearch {

    @CacheLookup
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Repository List')]")
    public static WebElement repository_Header;

    @FindBy(how = How.XPATH, using = "//h6[contains(text(),'No Data Found')]")
    public static WebElement repository_NoDataMessage;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search']")
    public static WebElement repository_searchText;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='search']")
    public static WebElement repository_searchIcon;

    @FindBy(how = How.XPATH, using = "//tbody[contains(@class,'MuiTableBody-root')]//tr//td[1]")
    public static List<WebElement> repository_Names;

    @FindBy(how = How.XPATH, using = "//tbody[contains(@class,'MuiTableBody')]")
    public static WebElement repository_repoTable;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'MuiTable-root')]//thead//tr//th[1]")
    public static WebElement repository_repoName;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'MuiTable-root')]//thead//tr//th[2]")
    public static WebElement repository_repoOwner;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'MuiTable-root')]//thead//tr//th[3]")
    public static WebElement repository_repoStars;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'MuiTable-root')]//thead//tr//th[4]")
    public static WebElement repository_repoLinkLabel;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'MuiTable-root')]//thead//tr//th[5]")
    public static WebElement repository_repoDetails;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiTablePagination-select')]")
    public static WebElement repository_numberOfRows;

    @FindBy(how = How.XPATH, using = "//tbody[contains(@class,'MuiTableBody-root')]//tr[1]//td[4]//a")
    public static WebElement repository_link;

    @FindBy(how = How.XPATH, using = "//tbody[contains(@class,'MuiTableBody-root')]//tr[1]//td[5]//span")
    public static WebElement repository_getDetails;

    @FindBy(how = How.XPATH, using = "//h2[@id='customized-dialog-title']")
    public static WebElement repository_detailsHeader;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiDialogContent-root MuiDialogContent-dividers')]//following::div[1]//p[1]")
    public static WebElement repository_lastThreeCommitters;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiGrid-root')]//p[4]")
    public static WebElement repository_recentForkedUser;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiGrid-root')]//p[6]")
    public static WebElement repository_recentForkedUserBio;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Ok')]")
    public static WebElement repository_detailsOkButton;

    @FindBy(how = How.XPATH, using = "//li[@data-value='50']")
    public static WebElement repository_fiftyRows;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiTablePagination-select MuiSelect-select MuiSelect-standard MuiInputBase-input css-')]")
    public static WebElement repository_rowArrowDropDown;

    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list css-')]")
    public static WebElement repository_rowList;

}