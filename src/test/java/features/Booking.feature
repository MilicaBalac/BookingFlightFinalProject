Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
  Scenario: Book a Flight

    Given I navigate to Booking
    Then I navigate to flights page
    And I select flight class "BUSINESS"
    And I select number of adults "3"
    And I add destination "Barcelona" "Catalonia"
    And I add departure date and return date "2022-03-01"  "2022-03-17"
    Then I check direct flights only
    And I click search
    Then I choose stops and flight time "1 stop max" "12:00 AM - 5:59 AM"
    Then I choose presentation "Cheapest"
    Then I click to see flight "2"
    Then I verify visibility of flights details
    Then I verify prices "2"
    Then I select flight

    Then I choose type of tickets "Flexible ticket"
    Then I verify final price "flexible"
    Then I click next button

    Then I enter contact details "RS"
    Then I enter names of passengers and gender "3"
    Then I click next

    Then I select seats
    Then I click  last next button

    Then I verify flight destination

#   Examples:
#      | row |
#     | 1 |
#    | 2 |






