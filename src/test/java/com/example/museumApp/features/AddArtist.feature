@AddingTests
Feature: Add an Artist

  Scenario: Everything works for adding an artist
    Given I have a browser open
    When I navigate to "http:localhost:8080/artist/add"
    And I enter "Dave" in the name box
    And I Enter "Coventry" in the birthplace box
    And I Enter "1968" in the birth_year box
    And I click the submit button
    Then I see that "Dave" was successfully added

  Scenario Outline: Blank fields give correct error messages
    Given I have a browser open
    When I navigate to "http:localhost:8080/artist/add"
    And I enter <name> in the name box
    And I Enter <place> in the birthplace box
    And I Enter <year> in the birth_year box
    And I click the submit button
    Then I see the <expected> error message

    Examples:
      | name | place | year | expected |
      |     ""    | "Coventry" | "1998" | "Artist name is blank" |
      |  "Lawson" |     ""     | "1998" | "Artist birthplace is blank" |
