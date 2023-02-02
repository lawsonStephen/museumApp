Feature: Edit existing artists

  Scenario: Everything works for editing an existing artist
    Given I have a browser open
    When I navigate to "http://localhost:8080/artist/edit?id=6"
    And I Enter "1968" in the birth_year box
    And I click the submit button
    Then I see that "daVinci" was successfully added



  Scenario: Edited Artist shows on Artist page
    Given I have a browser open
    And I navigate to "http:localhost:8080/artist"
    Then the birth_year of Da Vinci displays as 1968