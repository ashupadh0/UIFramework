@reposearch_Regression
Feature: To verify repo search homepage

    @TC01
  Scenario: To verify content displayed in the home page
    Given repo search home page is launched
    When user is in home page
    Then data in the home page should be available


  @TC02
  Scenario: To verify search functionality in the home page

    Given repo search home page is launched
    When user searches data "Ashutosh"
    Then only repositories with name "Ashutosh" should be displayed

  @TC03
  Scenario: To verify headers in the table of the home page

    Given repo search home page is launched
    When user is in home page
    And  user searches data "Ashutosh"
    Then table should contain Name,Owner,Stars ,Link and Details

  @TC04
  Scenario: To verify default numbers of rows present in the homepage

    Given repo search home page is launched
    When user is in home page
    And  user searches data "Ashutosh"
    Then table should contain "10" rows by default


  @TC05
  Scenario: To verify a click on a link opens a new tab

    Given repo search home page is launched
    When  user searches data "Ashutosh"
    Then a new tab should be opened when user clicks on a link

  @TC06
  Scenario: To verify link opened in a new tab

    Given repo search home page is launched
    When  user searches data "Ashutosh"
    Then url in the new tab should be same as the link clicked on

  @TC07
  Scenario: To verify details column in the home page

    Given repo search home page is launched
    And  user searches data "Ashutosh"
    When user clicks on details
    Then repo details should be displayed

  @TC08
  Scenario Outline: To verify repo details displayed

    Given repo search home page is launched
    And  user searches data "Ashutosh"
    When user clicks on details
    Then alert should contain details of the repository <testCase>

    Examples:
            | testCase |
            | TC_08    |

  @TC09
  Scenario: To verify get details pop up is closed successfully

    Given repo search home page is launched
    And  user searches data "Ashutosh"
    When user clicks on details
    Then details popup should close when clicked on ok button

  @TC10
  Scenario Outline: To verify data on the home page changes based on number of rows selected

    Given repo search home page is launched
    And  user searches data "Ashutosh"
    When user selects <rows>
    Then <rows> should be displayed in the homepage

    Examples:
      |rows|
      |10|
#      |25|
#      |50|


