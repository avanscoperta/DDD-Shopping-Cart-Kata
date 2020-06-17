Feature: Reservation

  Scenario: Reservation on item added
    Given item <cold beer> is available in the catalog
    And I am a registered user
    When I add cold beer to my shopping cart
    Then a cold beer is reserved for me