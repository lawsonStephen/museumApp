Feature: Edit existing sculptures
  Scenario: Everything works for editing an existing sculpture
    Given I have a browser open
    When I navigate to "http://localhost:8080/sculpture/edit?id=3"
    And I Enter "2020" in the sculpture_year box
    And I click the submit button
    Then I see that "Thinker" was successfully added



  Scenario: Edited Sculpture shows on Sculpture page
    Given I have a browser open
    And I navigate to "http:localhost:8080/sculpture"
    Then the sculpture_year of Thinker displays as 2020