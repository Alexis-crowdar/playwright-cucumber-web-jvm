@SwagLabsLogin
Feature: Login to the SwagLabs application

  @CorrectCredentials
  Scenario: Login to the SwagLabs application with the correct credentials.
    Given that the user launched SwagLabs application
    When try to login with credentials username: "standard_user" and password: "secret_sauce"
    Then must visualize the home page

  @WrongCredentials
  Scenario: Login to the SwagLabs application with the wrong credentials.
    Given that the user launched SwagLabs application
    When try to login with credentials username: "locked_out_user" and password: "secret_sauce"
    Then must not visualize the home page