Feature: Add a Painting and errors display

  Scenario Outline: Everything works for adding a painting for each artist
    Given I have a browser open
    When I navigate to "http:localhost:8080/painting/add"
    And I enter "Dave's painting" in the name box
    And I Enter "1968" in the painting_year box
    And I Enter "100.0" in the painting_price box
    And I Select <artist> from the artist dropdown
    And I click the submit button
    Then I see that "Dave's painting" was successfully added


    Examples:
      | artist |
      |"Michelangelo"|
      |"Rodin"|
      |"Donatello"|
      |"VanGogh"|
      |"Picasso"|
      |"daVinci"|
      |"Rembrandt"|
      |"Monet"|
      |"Dali"|
      |"Warhol"|
      |"Vermeer"|
      |"Raphael"|
      |"Gauguin"|
      |"Titian"|
      |"Munch"|
      |"Matisse"|
      |"Renoir"|
      |"OKeeffe"|
      |"Klimt"|
      |"Cezanne"|
      |"Pollock"|


  Scenario Outline: Everything works for adding a painting for each museum
    Given I have a browser open
    When I navigate to "http:localhost:8080/painting/add"
    And I enter "Dave's painting" in the name box
    And I Enter "1968" in the painting_year box
    And I Enter "100.0" in the painting_price box
    And I Select <museum> from the museum dropdown
    And I click the submit button
    Then I see that "Dave's painting" was successfully added

    Examples:
      | museum |
      |"Prado"                                          |
      |"Louvre"                                         |
      |"British Museum"                                 |
      |"National Gallery"                               |
      |"Accademia"                                      |
      |"St Peters Basilica"                             |
      |"Sistine Chapel"                                 |
      |"Van Gogh Museum"                                |
      |"American Museum of Natural History"             |
      |"Smithsonian National Museum of American History"|
      |"Tate Modern"                                    |
      |"Uffizi Gallery"                                 |
      |"Hermitage Museum"                               |
      |"Rijksmuseum"                                    |
      |"Musée dOrsay"                                   |
      |"Museum of Modern Art"                           |
      |"National Museum of Korea"                       |
      |"Pergamon Museum"                                |

  Scenario: Blank name field gives correct error message
    Given I have a browser open
    When I navigate to "http:localhost:8080/painting/add"
    And I enter "" in the name box
    And I Enter "1968" in the painting_year box
    And I Enter "100.0" in the painting_price box
    And I click the submit button
    Then I see the "Painting name is blank" error message