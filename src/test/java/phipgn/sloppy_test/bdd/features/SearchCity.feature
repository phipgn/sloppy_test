@searchCity
Feature: Search weather in my city
  As a user, I want to find the weather information for a specific city

  @validCities
  Scenario Outline: I want to search weather with valid cities
    Given User searches weather for <query>
    Then User should see a valid search dropdown menu for <query>

    Examples: 
      | query      |
      | London     |
      | London, GB |
