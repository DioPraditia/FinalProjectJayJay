@api
Feature: Test API CRUD on DummyAPI

  Scenario: Get list users
    Given User sends GET request to retrieve list users


  Scenario: Create new user
    When User sends POST request to create user with name "John", lastName "Doe", email "John"
    Then Response status code should be 403
    And Response field "name" should be "John"

  Scenario: Put user
    When User sends PUT request to update user with id "692adb19ac7daa6bd3c11a52" name "Dio" and email "John"
    Then Response status code should be 403
    And Response field "name" should be "Dio"

  Scenario: Patch user
    When User sends Patch request to update user with id "692adb19ac7daa6bd3c11a52" name "Doe" and email "John"
    Then Response status code should be 403
    And Response field "name" should be "DoePatch"

  Scenario: Delete user
    When User sends DELETE request to delete user with id "692adb19ac7daa6bd3c11a52"
    Then Response status code should be 403
