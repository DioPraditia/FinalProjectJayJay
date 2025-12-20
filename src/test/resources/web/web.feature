@web
Feature: Web UI Automation

  @E2E
  Scenario: Web Ui Automation E2E
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage
    Then user is on checkoutpage
    When user click button Add to chart
    When user click icon shipping to cart
    When user click button checkout
    And user input first name with "Jhon"
    And user input last name with "Doe"
    And user input postal code with "12250"
    When user click button continue
    When user click button finish
    When user click button back home
    Then user is on homepage
    When user click button hamburger
    When user click logout
    Then user is on login page

  @valid-login
  Scenario: Login using valid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  @invalid-login
  Scenario: Login using invalid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "invalid"
    When user click login button
    Then user able toc see error message "Epic sadface: Username and password do not match any user in this service"

  @invalid-login
  Scenario: Login using invalid username
    Given user is on login page
    And user input username with "standard"
    And user input password with "invalid"
    When user click login button
    Then user able toc see error message "Epic sadface: Username and password do not match any user in this service"

  @invalid-login
  Scenario: Login with empty password
    Given user is on login page
    And user input username with "standard"
    And user input password with ""
    When user click login button
    Then user able toc see error message ""

