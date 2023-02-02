Feature: Edit existing museums

  Scenario: Everything works for editing an existing museum
    Given I have a browser open
    When I navigate to "http://localhost:8080/museum/edit?id=3"
    And I Enter "Iceland" in the location box
    And I click the submit button
    Then I see that "British Museum" was successfully added



  Scenario: Edited Museum shows on Museum page
    Given I have a browser open
    And I navigate to "http:localhost:8080/museum"
    Then the location of the British Museum displays as Iceland