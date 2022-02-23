Feature: Booking

#  Scenario Outline: Book a Flight row: "<row>"
  Scenario: Book a Flight
    Given I navigate to Booking
    Then I navigate to flights page
    And I select flight class "PREMIUM_ECONOMY"
    And I select number of adults "4"
    And I add destination "Barcelona" "Spain"
    And I add departure date and return date "2022-02-27"  "2022-03-17"
    Then I check direct flights only
    And I click search

#   Examples:
#      | row |
#     | 1 |
#    | 2 |






