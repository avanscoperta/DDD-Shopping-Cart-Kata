Feature: Reservation

  Scenario: Reservation on item added
    Given item cold beer is available in the catalog
    And I am a registered user
    When I add the item to my shopping cart
    Then the item should be reserved for me

    Scenario: Reservation on item retired
      Given item cold beer is available in the catalog
      And I am a registered user
      And the inventory for cold beer is 0
      When I add the item to my shopping cart
      Then I should receive a lame excuse
