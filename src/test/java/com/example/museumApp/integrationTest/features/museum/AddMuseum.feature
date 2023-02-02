Feature: Add a Museum and errors display

  Scenario: Everything works for adding a museum
    Given I have a browser open
    When I navigate to "http:localhost:8080/museum/add"
    And I enter "Dave's Museum" in the name box
    And I Enter "Coventry" in the location box
    And I click the submit button
    Then I see that "Dave's Museum" was successfully added

  Scenario Outline: One blank field gives correct error message
    Given I have a browser open
    When I navigate to "http:localhost:8080/museum/add"
    And I enter <name> in the name box
    And I Enter <place> in the location box
    And I click the submit button
    Then I see the <expected> error message

    Examples:
      | name | place | expected |
      |     ""    | "Coventry" | "Museum name is blank" |
      |  "Dave's Museum" |     ""     | "Museum location is blank" |

  Scenario: Two blank fields gives correct error messages
    Given I have a browser open
    When I navigate to "http:localhost:8080/museum/add"
    And I enter "" in the name box
    And I Enter "" in the location box
    And I click the submit button
    Then I see both error messages