Feature: NaukriDailyUpdate

  Scenario: Login and Upload Resume
    Given user launches the browser
    When user opens the Naukri login page
    And user enters username and password
    And user navigates to profile and uploads resume
    Then user should be logged in successfully