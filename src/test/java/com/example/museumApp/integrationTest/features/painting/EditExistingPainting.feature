Feature: Edit existing painting
  Scenario: Everything works for editing an existing painting
    Given I have a browser open
    When I navigate to "http://localhost:8080/painting/edit?id=5"
    And I Enter "2020" in the painting_year box
    And I click the submit button
    Then I see that "Mona Lisa" was successfully added



  Scenario: Edited Painting shows on Painting page
    Given I have a browser open
    And I navigate to "http:localhost:8080/painting"
    Then the painting_year of Mona Lisa displays as 2020