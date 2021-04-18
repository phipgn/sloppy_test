@searchCity
Feature: Search weather in my city
  As a user, I want to find the weather information for a specific city

  Background: 
    Given User launches and maximizes the browser
    And User waits for the loader to be disappeared

  @validCities
  Scenario Outline: U001: I want to search weather with valid cities
    Given User searches weather for <query>
    Then User should see a valid search dropdown menu for <query>
    And User selects a random dropdown option
    Then Hourly Forecast section should be diplaying in content section
    Then Minute Forecast section should be diplaying in content section
    Then Eight-Day Forecast section should be diplaying in content section
    Then Map should be displaying in content section
    Then All the verifications should be passed

    Examples: 
      | query      |
      | London     |
      | London, GB |
      | Haiphong   |
      | Hanoi      |

  @invalidCities
  Scenario Outline: U002: I want to search weather with invalid cities
    Given User searches weather for <query>
    Then User should see search not found message

    Examples: 
      | query     |
      | in flames |
      | pod       |
